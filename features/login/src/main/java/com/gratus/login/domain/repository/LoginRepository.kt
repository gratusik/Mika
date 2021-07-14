package com.gratus.login.domain.repository

import com.gratus.core.domain.local.GetUserDataResponse
import com.gratus.core.domain.local.LogInResponse
import io.reactivex.Single

// repo to getLatest Comic ID
interface LoginRepository {
    fun login(username: String, password: String): Single<LogInResponse>
    fun getUserData(token: String): Single<GetUserDataResponse>
}
