package com.gratus.dialog.presentation

import com.gratus.core.BaseApplication
import com.gratus.dialog.R
import com.gratus.dialog.databinding.FragmentDialogOneBinding
import com.gratus.dialog.di.DaggerDialogComponent
import com.gratus.dialog.domain.local.DialogData
import com.gratus.ui.base.BaseDialogFragment

class DialogOneFragment :
    BaseDialogFragment<FragmentDialogOneBinding>(FragmentDialogOneBinding::inflate) {
    override fun onInitDependencyInjection() {
        DaggerDialogComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }

    override fun onInitViewBinding() {
        binding.dialogText.text = getString(R.string.dialog1)
        binding.choiceResultText.text = getString(R.string.your_choice)
        binding.choice1Button.text = getString(R.string.choice_a)
        binding.choice2Button.text = getString(R.string.choice_b)
        // select choice a or b in this dialog
        binding.choice1Button.setOnClickListener {
            dialogNavigation(binding.choice1Button.text.toString())
        }
        binding.choice2Button.setOnClickListener {
            dialogNavigation(binding.choice2Button.text.toString())
        }
    }

    private fun dialogNavigation(choice: String) {
        // navigate to dialog two with choice A or B
        // done using safe args
        val dialogData = DialogData(choice)
        val action =
            DialogOneFragmentDirections.actionDialogOneFragmentToDialogTwoFragment(dialogData)
        navController?.navigate(action)

        // can be done also using bundle
//        val bundle = bundleOf(
//            getString(R.string.choice_1) to choice,
//        )
        // navController?.navigate(R.id.action_dialogOneFragment_to_dialogTwoFragment, bundle)
    }
}
