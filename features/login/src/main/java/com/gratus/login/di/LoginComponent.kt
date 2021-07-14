package com.gratus.login.di

import com.gratus.core.di.component.CoreComponent
import com.gratus.core.di.scopes.FeatureScope
import com.gratus.login.presentation.LoginActivity
import com.gratus.login.presentation.LoginFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        LoginModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface LoginComponent {

    fun inject(loginActivity: LoginActivity)
    fun inject(loginFragment: LoginFragment)
}
