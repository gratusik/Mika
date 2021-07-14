package com.gratus.conditionalNav.di

import com.gratus.conditionalNav.presentation.*
import com.gratus.core.di.component.CoreComponent
import com.gratus.core.di.scopes.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class]
)
interface ConditionalNavComponent {

    fun inject(conditionalNavActivity: ConditionalNavActivity)
    fun inject(firstScreenFragment: FirstScreenFragment)
    fun inject(secondScreenFragment: SecondScreenFragment)
    fun inject(childOneFragment: ChildOneFragment)
    fun inject(childTwoFragment: ChildTwoFragment)
}
