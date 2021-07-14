package com.gratus.dialog.presentation

import com.gratus.core.BaseApplication
import com.gratus.dialog.databinding.ActivityDialogBinding
import com.gratus.dialog.di.DaggerDialogComponent
import com.gratus.ui.base.BaseActivity

class DialogActivity : BaseActivity<ActivityDialogBinding>() {
    override fun onInitDependencyInjection() {
        DaggerDialogComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }

    override fun getViewBinding(): ActivityDialogBinding =
        ActivityDialogBinding.inflate(layoutInflater)

    override fun onInitViewBinding() {
    }
}
