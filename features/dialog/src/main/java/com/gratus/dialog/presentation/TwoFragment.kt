package com.gratus.dialog.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.gratus.core.BaseApplication
import com.gratus.dialog.R
import com.gratus.dialog.databinding.FragmentTwoBinding
import com.gratus.dialog.di.DaggerDialogComponent
import com.gratus.dialog.domain.local.DialogData
import com.gratus.ui.base.BaseFragment

class TwoFragment :
    BaseFragment<FragmentTwoBinding>(FragmentTwoBinding::inflate) {
    private val args: TwoFragmentArgs by navArgs()
    private lateinit var dialogData: DialogData

    @SuppressLint("SetTextI18n")
    override fun onInitViewBinding(savedInstanceState: Bundle?) {
        dialogData = args.choices
        binding.resultText.text =
            getString(R.string.screen1_results) + " " + dialogData.choice
    }

    override fun onInitDependencyInjection() {
        DaggerDialogComponent
            .builder()
            .coreComponent(BaseApplication.coreComponent)
            .build()
            .inject(this)
    }
}
