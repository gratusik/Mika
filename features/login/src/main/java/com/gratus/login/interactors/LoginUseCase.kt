package com.gratus.login.interactors

import com.gratus.core.domain.local.LogInResponse
import com.gratus.login.domain.repository.LoginRepository
import com.gratus.login.interactors.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) :
    SingleUseCase<LogInResponse>() {

    private var username: String = ""
    private var password: String = ""

    fun getCredentials(user: String, pass: String) {
        username = user
        password = pass
    }

    override fun buildUseCaseSingle(): Single<LogInResponse> {
        return repository.login(username, password)
    }
}
