package com.gratus.core.di.component

import android.app.Application
import android.content.Context
import com.gratus.core.di.modules.ContextModule
import com.gratus.core.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
    ]
)
interface CoreComponent {
    fun inject(application: Application)
    fun context(): Context
}
