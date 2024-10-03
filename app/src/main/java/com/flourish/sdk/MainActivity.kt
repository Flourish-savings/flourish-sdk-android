package com.flourish.sdk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.flourish.sdk.android.configuration.Environment
import com.flourish.sdk.android.Flourish
import com.flourish.sdk.android.configuration.Language
import com.flourish.sdk.android.events.Event
import com.flourish.sdk.android.events.FlourishEventListener
import com.flourish.sdk.android.events.FlourishEventManager

class MainActivity : AppCompatActivity(), FlourishEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Flourish.initializer(
            customerCode = "HERE_YOU_WILL_USE_YOUR_CUSTOMER_CODE",
            partnerId = "HERE_YOU_WILL_USE_YOUR_PARTNER_ID",
            secret = "HERE_YOU_WILL_USE_YOUR_SECRET",
            environment = Environment.STAGING,
            language = Language.ENGLISH
        )

        FlourishEventManager.addListener(this)

        val myButton: Button = findViewById(R.id.button2)

        myButton.setOnClickListener {
            // Start the Flourish library activity
            val intent = Intent("com.flourish.sdk.android.ACTION_OPEN")
            startActivity(intent)
        }

    }

    override fun onGenericEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }

}