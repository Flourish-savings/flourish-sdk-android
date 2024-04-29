package com.flourish.sdk.android.repository

import android.util.Log
import com.flourish.sdk.android.Flourish
import com.flourish.sdk.android.model.ApiRequest
import com.flourish.sdk.android.model.ApiResponse
import com.flourish.sdk.android.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {

    fun retrieveToken(flourish: Flourish) {
        val requestBody = ApiRequest(flourish.partnerId, flourish.secret, flourish.customerCode)
        val apiService = ApiClient.create(environment = Flourish.environment)
        val call = apiService.generateToken(requestBody)

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        flourish.token = data.token
                        signIn(data.token)
                    }
                } else {
                    Log.e("API token request error", response.message())
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.message?.let { Log.e("API token request error", it) }
            }
        })
    }

    fun signIn(authToken: String) {
        val apiService = ApiClient.create(environment = Flourish.environment)
        val sdkVersion = android.os.Build.VERSION.SDK_INT.toString()
        val call = apiService.signIn("Bearer $authToken", sdkVersion)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Log.i("SignIn", "SignIn request success")
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                t.message?.let { Log.e("SignIn request error", it) }
            }
        })
    }
}