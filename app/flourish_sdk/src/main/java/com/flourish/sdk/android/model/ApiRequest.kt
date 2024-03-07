package com.flourish.sdk.android.model

import com.google.gson.annotations.SerializedName

data class ApiRequest(
    @SerializedName("partner_uuid")
    val partnerUuid: String,

    @SerializedName("partner_secret")
    val partnerSecret: String,

    @SerializedName("customer_code")
    val customerCode: String
)
