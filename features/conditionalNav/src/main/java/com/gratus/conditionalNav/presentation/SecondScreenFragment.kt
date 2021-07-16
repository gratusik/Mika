package com.gratus.conditionalNav.presentation

import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.gratus.conditionalNav.R
import com.gratus.conditionalNav.databinding.FragmentSecondScreenBinding
import com.gratus.conditionalNav.di.DaggerConditionalNavComponent
import com.gratus.core.BaseApplication
import com.gratus.ui.base.BaseFragment

class SecondScreenFragment :
    BaseFragment<FragmentSecondScreenBinding>(FragmentSecondScreenBinding::inflate) {
    private val args: SecondScreenFragmentArgs by navArgs()

    override fun onInitViewBinding(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            setNavigationGraph()
        }
    }

    private fun setNavigationGraph() {
        // setting the start destination based on condition got from first screen
        // child Fragment manager deals with fragment transaction within fragments
        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.second_host_fragment) as? NavHostFragment
        navController = nestedNavHostFragment?.navController
        // nav options to pop out the default start destination of child one
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.childOneFragment, true)
            .build()
        if (args.child == 2) {
            navController?.navigate(R.id.childTwoFragment, args.toBundle(), navOptions)
        } else {
            navController?.navigate(R.id.childOneFragment, args.toBundle(), navOptions)
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
