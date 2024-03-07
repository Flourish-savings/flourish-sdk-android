package com.flourish.sdk.android

import com.flourish.sdk.android.configuration.Environment
import com.flourish.sdk.android.configuration.Language
import com.flourish.sdk.android.repository.ApiRepository

object Flourish{
    var customerCode: String = ""
    var partnerId: String = ""
    var secret: String = ""
    var token: String = ""
    var environment: Environment = Environment.PRODUCTION
    var language: Language = Language.ENGLISH

    fun initializer(
        customerCode: String,
        partnerId: String,
        secret: String,
        environment: Environment,
        language: Language
    ) {
        this.customerCode = customerCode
        this.partnerId = partnerId
        this.secret = secret
        this.environment = environment
        this.language = language

        ApiRepository().retrieveToken(this)
    }
}
