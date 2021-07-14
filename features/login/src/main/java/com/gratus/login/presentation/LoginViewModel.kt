package com.gratus.login.presentation

import androidx.lifecycle.MutableLiveData
import com.gratus.login.interactors.GetUserUseCase
import com.gratus.core.domain.local.GetUserDataResponse
import com.gratus.core.domain.local.LogInResponse
import com.gratus.core.util.network.Resource
import com.gratus.login.interactors.LoginUseCase
import com.gratus.ui.base.BaseViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private var loginUseCase: LoginUseCase,
    private var getUserUseCase: GetUserUseCase
) : BaseViewModel() {
    var loginResponse: MutableLiveData<Resource<LogInResponse>> =
        MutableLiveData(Resource.none())
    var getUserData: MutableLiveData<Resource<GetUserDataResponse>> =
        MutableLiveData(Resource.none())

    fun login(username: String, password: String) {
        loginResponse.value = Resource.loading()
        loginUseCase.getCredentials(username, password)
        loginUseCase.execute(
            onSuccess = {
                loginResponse.value = Resource.success(it)
            },
            onError = {
                loginResponse.value = Resource.error(it.message.toString(), null)
            }
        )
    }

    fun getUser(token: String) {
        getUserData.value = Resource.loading()
        getUserUseCase.getToken(token)
        getUserUseCase.execute(
            onSuccess = {
                getUserData.value = Resource.success(it)
            },
            onError = {
                getUserData.value = Resource.error(it.message.toString(), null)
            }
        )
    }
}
