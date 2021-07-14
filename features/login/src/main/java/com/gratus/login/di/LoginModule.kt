package com.gratus.login.di

import com.gratus.login.interactors.GetUserUseCase
import com.gratus.core.data.local.Proxy
import com.gratus.login.data.repository.LoginRepoImpl
import com.gratus.login.domain.repository.LoginRepository
import com.gratus.login.interactors.LoginUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [LoginFeatureModule::class])
class LoginModule {
    // repo provider
    @Provides
    fun provideLoginRepository(
        proxy: Proxy
    ): LoginRepository {
        return LoginRepoImpl(
            proxy
        )
    }

    @Provides
    fun providesLoginUseCase(loginRepository: LoginRepository): LoginUseCase {
        return LoginUseCase(loginRepository)
    }

    @Provides
    fun providesGetUserUseCase(loginRepository: LoginRepository): GetUserUseCase {
        return GetUserUseCase(loginRepository)
    }
}
