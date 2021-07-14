package com.gratus.login.interactors

import com.gratus.core.domain.local.GetUserDataResponse
import com.gratus.login.interactors.base.SingleUseCase
import com.gratus.login.domain.repository.LoginRepository
import io.reactivex.Single
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: LoginRepository) :
    SingleUseCase<GetUserDataResponse>() {

    private var token: String = ""

    fun getToken(tokenVal: String) {
        token = tokenVal
    }

    override fun buildUseCaseSingle(): Single<GetUserDataResponse> {
        return repository.getUserData(token)
    }
}
