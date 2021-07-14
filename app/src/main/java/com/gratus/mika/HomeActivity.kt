package com.gratus.mika

import com.gratus.conditionalNav.presentation.ConditionalNavActivity
import com.gratus.core.BaseApplication
import com.gratus.dialog.presentation.DialogActivity
import com.gratus.login.presentation.LoginActivity
import com.gratus.mika.databinding.ActivityHomeBinding
import com.gratus.mika.di.DaggerHomeComponent
import com.gratus.ui.base.BaseActivity
import com.gratus.ui.util.extensions.startActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    // leads to dialog task activity
    private fun intentDialogActivity() {
        startActivity<DialogActivity>()
    }

    // leads to conditional nav task activity
    private fun intentConditionalNavActivity() {
        startActivity<ConditionalNavActivity>()
    }

    // leads to login activity
    private fun intentLoginActivity() {
        startActivity<LoginActivity>()
    }

    override fun onInitDependencyInjection() {
        DaggerHomeComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }

    override fun getViewBinding(): ActivityHomeBinding =
        ActivityHomeBinding.inflate(layoutInflater)

    override fun onInitViewBinding() {
        binding.task1Button.setOnClickListener {
            intentDialogActivity()
        }
        binding.task2Button.setOnClickListener {
            intentConditionalNavActivity()
        }
        binding.task4Button.setOnClickListener {
            intentLoginActivity()
        }
    }
}
