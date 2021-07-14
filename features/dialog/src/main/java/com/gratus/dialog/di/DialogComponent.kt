package com.gratus.dialog.di

import com.gratus.core.di.component.CoreComponent
import com.gratus.core.di.scopes.FeatureScope
import com.gratus.dialog.presentation.*
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class]
)
interface DialogComponent {

    fun inject(dialogActivity: DialogActivity)
    fun inject(oneFragment: OneFragment)
    fun inject(twoFragment: TwoFragment)
    fun inject(dialogOneFragment: DialogOneFragment)
    fun inject(dialogTwoFragment: DialogTwoFragment)
}
