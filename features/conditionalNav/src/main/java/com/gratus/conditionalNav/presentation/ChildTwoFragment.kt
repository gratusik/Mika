package com.gratus.conditionalNav.presentation

import android.os.Bundle
import com.gratus.conditionalNav.R
import com.gratus.conditionalNav.databinding.FragmentChildTwoBinding
import com.gratus.conditionalNav.di.DaggerConditionalNavComponent
import com.gratus.core.BaseApplication
import com.gratus.ui.base.BaseFragment

class ChildTwoFragment :
    BaseFragment<FragmentChildTwoBinding>(FragmentChildTwoBinding::inflate) {
    override fun onInitViewBinding(savedInstanceState: Bundle?) {
        // navigate to child one fragment from child two onClick of button
        binding.child1Button.setOnClickListener {
            navController?.navigate(
                R.id.action_childTwoFragment_to_childOneFragment
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
