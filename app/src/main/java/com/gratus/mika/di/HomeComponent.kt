package com.gratus.mika.di

import com.gratus.core.di.component.CoreComponent
import com.gratus.core.di.scopes.FeatureScope
import com.gratus.mika.HomeActivity
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class]
)
interface HomeComponent {

    fun inject(homeActivity: HomeActivity)
}
