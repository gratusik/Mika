package com.gratus.login.presentation

import com.gratus.core.BaseApplication
import com.gratus.login.databinding.ActivityLoginBinding
import com.gratus.login.di.DaggerLoginComponent
import com.gratus.ui.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun onInitDependencyInjection() {
        DaggerLoginComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }

    override fun getViewBinding(): ActivityLoginBinding =
        ActivityLoginBinding.inflate(layoutInflater)

    override fun onInitViewBinding() {
    }
}
