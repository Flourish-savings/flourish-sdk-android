package com.flourish.sdk.android.service

import com.flourish.sdk.android.model.ApiRequest
import com.flourish.sdk.android.model.ApiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("access_token")
    fun generateToken(@Body requestBody: ApiRequest): Call<ApiResponse>

    @POST("api/sign_in")
    fun signIn(
        @Header("Authorization") authToken: String,
        @Header("Sdk-Version") sdkVersion: String,
    ): Call<Void>
}