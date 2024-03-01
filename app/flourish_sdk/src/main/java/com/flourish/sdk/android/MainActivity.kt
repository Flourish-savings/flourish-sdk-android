package com.flourish.sdk.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flourish.sdk.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.flourishApp.loadUrl("https://platform-stg.flourishfi.com/?lang=es&token=eyJhbGciOiJIUzI1NiJ9.eyJjbGllbnRfaWQiOjIsInVzZXJfaWQiOjM3LCJleHAiOjE3MDk0OTM2OTJ9.6Ln_AI65XR6xPgbNH_K2DB3I5zZx7TyARvUT37nWCUw")

        binding.flourishApp.settings.javaScriptEnabled = true
    }
}