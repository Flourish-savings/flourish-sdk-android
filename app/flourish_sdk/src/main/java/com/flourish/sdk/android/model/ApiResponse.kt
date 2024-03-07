package com.flourish.sdk.android.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("access_token")
    val token: String
)
