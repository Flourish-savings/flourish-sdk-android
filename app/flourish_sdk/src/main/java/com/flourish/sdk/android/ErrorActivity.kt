package com.flourish.sdk.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.flourish.sdk.android.repository.ApiRepository


class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_error)
        ApiRepository().retrieveToken(Flourish)

        val intent = Intent(this, RewardsActivity::class.java)
        startActivity(intent)
    }
}
