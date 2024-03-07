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

        val apiService = ApiClient.create()
        val call = apiService.generateToken(requestBody)

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        flourish.token = data.token
                    }
                } else {
                    Log.e("API token request error", "message")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("API token request error", "message")
            }
        })
    }
}