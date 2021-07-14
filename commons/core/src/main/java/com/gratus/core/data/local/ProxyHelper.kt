package com.gratus.core.data.local

import com.gratus.core.domain.local.GetUserDataResponse
import com.gratus.core.domain.local.LogInResponse
import io.reactivex.Single

interface ProxyHelper {
    fun logIn(email: String, password: String): Single<LogInResponse>
    fun getUserData(token: String): Single<GetUserDataResponse>
}
