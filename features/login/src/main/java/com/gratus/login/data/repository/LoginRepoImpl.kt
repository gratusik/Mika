package com.gratus.login.data.repository

import com.gratus.core.data.local.Proxy
import com.gratus.core.domain.local.GetUserDataResponse
import com.gratus.core.domain.local.LogInResponse
import com.gratus.login.domain.repository.LoginRepository
import io.reactivex.Single
import javax.inject.Inject

// data source which hits the service api
class LoginRepoImpl @Inject constructor(
    private var proxy: Proxy
) : LoginRepository {

    override fun login(username: String, password: String): Single<LogInResponse> {
        return proxy.logIn(username, password)
    }

    override fun getUserData(token: String): Single<GetUserDataResponse> {
        return proxy.getUserData(token)
    }
}
