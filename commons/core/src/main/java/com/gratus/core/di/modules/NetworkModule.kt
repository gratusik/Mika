package com.gratus.core.di.modules

import com.gratus.core.data.local.Proxy
import com.gratus.core.data.local.ProxyHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideProxy(proxy: Proxy): ProxyHelper {
        return proxy
    }
}
