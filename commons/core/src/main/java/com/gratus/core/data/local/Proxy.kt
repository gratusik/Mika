package com.gratus.core.data.local

import android.os.SystemClock
import com.gratus.core.domain.local.GetUserDataResponse
import com.gratus.core.domain.local.LogInResponse
import io.reactivex.Completable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

// model of service api 
class Proxy @Inject constructor() : ProxyHelper {
    companion object {
        @JvmStatic
        val initialToken = "" + SystemClock.uptimeMillis()
    }

    override fun logIn(email: String, password: String): Single<LogInResponse> {
        if (!Objects.equals(email, "test@example.com") || !Objects.equals(password, "xyz")) {
            return Completable.complete()
                .delay(1, java.util.concurrent.TimeUnit.SECONDS)
                .andThen(Single.error(Exception("Forbidden")))
        }
        val response = LogInResponse(initialToken, "Hello world!")
        return Single.just(response).delay(1, java.util.concurrent.TimeUnit.SECONDS)
    }

    override fun getUserData(token: String): Single<GetUserDataResponse> {
        if (!Objects.equals(token, initialToken)) {
            return Completable.complete()
                .delay(1, java.util.concurrent.TimeUnit.SECONDS)
                .andThen(Single.error(Exception("Forbidden")))
        }
        val response = GetUserDataResponse("User")
        return Single.just(response).delay(2, java.util.concurrent.TimeUnit.SECONDS)
    }
}
