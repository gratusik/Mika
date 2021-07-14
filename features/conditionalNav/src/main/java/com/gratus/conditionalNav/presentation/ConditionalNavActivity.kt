package com.gratus.conditionalNav.presentation

import com.gratus.conditionalNav.databinding.ActivityConditionalBinding
import com.gratus.conditionalNav.di.DaggerConditionalNavComponent
import com.gratus.core.BaseApplication
import com.gratus.ui.base.BaseActivity

class ConditionalNavActivity : BaseActivity<ActivityConditionalBinding>() {
    override fun onInitDependencyInjection() {
        DaggerConditionalNavComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }

    override fun getViewBinding(): ActivityConditionalBinding =
        ActivityConditionalBinding.inflate(layoutInflater)

    override fun onInitViewBinding() {
    }
}
