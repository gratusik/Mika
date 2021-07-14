package com.gratus.conditionalNav.presentation

import android.os.Bundle
import com.gratus.conditionalNav.databinding.FragmentFirstScreenBinding
import com.gratus.conditionalNav.di.DaggerConditionalNavComponent
import com.gratus.core.BaseApplication
import com.gratus.ui.base.BaseFragment

class FirstScreenFragment :
    BaseFragment<FragmentFirstScreenBinding>(FragmentFirstScreenBinding::inflate) {
    private var page = -1
    override fun onInitViewBinding(savedInstanceState: Bundle?) {
        // navigate to child one fragment from child two onClick of button
        binding.child1Button.setOnClickListener {
            page = 1
            pageTransition(page)
        }
        // navigate to child two fragment from child one onClick of button
        binding.child2Button.setOnClickListener {
            page = 2
            pageTransition(page)
        }
    }

    private fun pageTransition(page: Int) {
        val action =
            FirstScreenFragmentDirections.actionFirstScreenFragmentToSecondScreenFragment(page)
        navController?.navigate(action)
    }

    override fun onInitDependencyInjection() {
        DaggerConditionalNavComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }
}
