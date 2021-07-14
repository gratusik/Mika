package com.gratus.dialog.presentation

import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.gratus.core.BaseApplication
import com.gratus.dialog.R
import com.gratus.dialog.databinding.FragmentDialogOneBinding
import com.gratus.dialog.di.DaggerDialogComponent
import com.gratus.dialog.domain.local.DialogData
import com.gratus.ui.base.BaseDialogFragment

class DialogTwoFragment :
    BaseDialogFragment<FragmentDialogOneBinding>(FragmentDialogOneBinding::inflate) {
    private val args: DialogTwoFragmentArgs by navArgs()
    private lateinit var dialogData: DialogData
    override fun onInitDependencyInjection() {
        DaggerDialogComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }

    override fun onInitViewBinding() {
        binding.dialogText.text = getString(R.string.dialog2)
        binding.choiceResultText.text = getString(R.string.dialog_result)
        binding.resultText.isVisible = true
        dialogData = args.choices
        binding.resultText.text = dialogData.choice
        binding.choice1Button.text = getString(R.string.choice_c)
        binding.choice2Button.text = getString(R.string.choice_d)
        // select choice c or d in this dialog
        binding.choice1Button.setOnClickListener {
            dialogNavigation(binding.choice1Button.text.toString())
        }
        binding.choice2Button.setOnClickListener {
            dialogNavigation(binding.choice2Button.text.toString())
        }
    }

    private fun dialogNavigation(choice: String) {
        // navigate to second screen with choice C or D
        // and also concat the previous choice
        // done using safe args
        dialogData.choice = dialogData.choice + "," + choice
        val action = DialogTwoFragmentDirections.actionDialogTwoFragmentToTwoFragment(
            dialogData
        )
        navController?.navigate(action)
//        val bundle = bundleOf(
//            getString(R.string.choice_2) to arguments?.getString(getString(R.string.choice_1)) + "," + choice,
//        )
//        navController?.navigate(R.id.action_dialogTwoFragment_to_twoFragment, bundle)
    }
}
