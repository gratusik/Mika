package com.gratus.login.presentation

import android.app.AlertDialog
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.gratus.core.BaseApplication
import com.gratus.core.util.network.ResourceState
import com.gratus.login.R
import com.gratus.login.databinding.FragmentLoginBinding
import com.gratus.login.di.DaggerLoginComponent
import com.gratus.ui.base.BaseFragmentViewModel

class LoginFragment :
    BaseFragmentViewModel<FragmentLoginBinding, LoginViewModel>(FragmentLoginBinding::inflate) {
    private var username: String? = null
    override fun onInitViewBinding(savedInstanceState: Bundle?) {
        // get email and password from text input layout
        // with this we can do validation on type using text change listener
        if (savedInstanceState != null) {
            if (savedInstanceState.getString(getString(R.string.username)) != null) {
                setPageVisibility(savedInstanceState.getString(getString(R.string.username))!!)
            }
        }
        binding.loginBt.setOnClickListener {
            it.hideKeyboard()
            viewModel.login(binding.email.text.toString(), binding.password.text.toString())
            observeLogin()
        }
    }

    private fun observeUser() {
        // observe user data to user full name
        viewModel.getUserData.observe(
            viewLifecycleOwner,
            {
                when (it.status) {
                    ResourceState.LOADING -> {
                    }
                    ResourceState.SUCCESS -> {
                        binding.progressBar.isVisible = false
                        it.data?.fullName?.let { it1 -> setPageVisibility(it1) }
                    }
                    ResourceState.ERROR -> {
                        binding.progressBar.isVisible = false
                        it.message?.let { it1 -> alertDialog(it1) }
                    }
                    else -> {
                        binding.progressBar.isVisible = false
                    }
                }
            }
        )
    }

    private fun observeLogin() {
        // observe login response to get the token
        viewModel.loginResponse.observe(
            viewLifecycleOwner,
            {
                when (it.status) {
                    ResourceState.LOADING -> {
                        binding.progressBar.isVisible = true
                    }
                    ResourceState.SUCCESS -> {
                        it.data?.greeting?.let { it1 -> alertDialog(it1) }
                        it.data?.token?.let { it1 -> viewModel.getUser(it1) }
                        observeUser()
                    }
                    ResourceState.ERROR -> {
                        binding.progressBar.isVisible = false
                        it.message?.let { it1 -> alertDialog(it1) }
                    }
                    else -> {
                        binding.progressBar.isVisible = false
                    }
                }
            }
        )
    }

    override fun onInitDependencyInjection() {
        DaggerLoginComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }

    override fun onInitViewModel() {
        viewModel =
            ViewModelProvider(this, factory)
                .get(LoginViewModel::class.java)
    }

    private fun setPageVisibility(user: String) {
        username = user
        binding.credentialLayout.isVisible = false
        binding.fullNameView.isVisible = true
        binding.fullNameView.text = user
    }

    // alert dialog to display error or success message got from the response
    private fun alertDialog(message: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setMessage(message)
        builder.setCancelable(true)

        builder.setPositiveButton(
            "OK"
        ) { dialog, which ->
            dialog.dismiss()
        }

        val alert: AlertDialog = builder.create()
        alert.show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(getString(R.string.username), username)
    }
}
