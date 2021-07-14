package com.gratus.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragmentViewModel<B : ViewBinding, VM : BaseViewModel>(private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> B) :
    Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private var _binding: B? = null
    val binding get() = _binding!!

    lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        onInitViewBinding(savedInstanceState)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInitDependencyInjection()
        onInitViewModel()
    }

    abstract fun onInitViewModel()
    abstract fun onInitDependencyInjection()
    abstract fun onInitViewBinding(savedInstanceState: Bundle?)

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    //hide keyboard on click login button
    fun View.hideKeyboard(): Boolean {
        try {
            val inputMethodManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
        } catch (ignored: RuntimeException) {
        }
        return false
    }
}
