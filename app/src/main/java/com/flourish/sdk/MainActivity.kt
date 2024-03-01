package com.flourish.sdk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.button2)

        myButton.setOnClickListener {
            // Start the Flourish library activity
            val intent = Intent("com.flourish.sdk.android.ACTION_SHOW_MY_SCREEN")
            startActivity(intent)
        }

    }
}