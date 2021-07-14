package com.gratus.dialog.presentation

import android.os.Bundle
import com.gratus.core.BaseApplication
import com.gratus.dialog.R
import com.gratus.dialog.databinding.FragmentOneBinding
import com.gratus.dialog.di.DaggerDialogComponent
import com.gratus.ui.base.BaseFragment

class OneFragment :
    BaseFragment<FragmentOneBinding>(FragmentOneBinding::inflate) {
    override fun onInitViewBinding(savedInstanceState: Bundle?) {
        binding.dialog1Button.setOnClickListener {
            navController?.navigate(
                R.id.action_oneFragment_to_dialogOneFragment
            )
        }
    }

    override fun onInitDependencyInjection() {
        DaggerDialogComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }
}
