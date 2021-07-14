package com.gratus.conditionalNav.presentation

import android.os.Bundle
import com.gratus.conditionalNav.R
import com.gratus.conditionalNav.databinding.FragmentChildOneBinding
import com.gratus.conditionalNav.di.DaggerConditionalNavComponent
import com.gratus.core.BaseApplication
import com.gratus.ui.base.BaseFragment

class ChildOneFragment :
    BaseFragment<FragmentChildOneBinding>(FragmentChildOneBinding::inflate) {
    override fun onInitViewBinding(savedInstanceState: Bundle?) {
        // navigate to child two fragment from child one onClick of button
        binding.child2Button.setOnClickListener {
            navController?.navigate(
                R.id.action_childOneFragment_to_childTwoFragment
            )
        }
    }

    override fun onInitDependencyInjection() {
        DaggerConditionalNavComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }
}
