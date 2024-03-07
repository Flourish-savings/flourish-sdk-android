package com.flourish.sdk.android.service

import com.flourish.sdk.android.configuration.Environment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun create(environment: Environment): ApiService {
        val STAGING_BASE_URL = "https://api-stg.flourishfi.com/api/v1/"
        val PRODUCTION_BASE_URL = "https://api.flourishfi.com/api/v1/"

        val baseUrl = if (environment == Environment.PRODUCTION) PRODUCTION_BASE_URL else STAGING_BASE_URL

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}