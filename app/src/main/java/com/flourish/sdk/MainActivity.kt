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
            customerCode = "YOUR_CUSTOMER_CODE",
            partnerId = "YOUR_PARTNER_ID",
            secret = "YOUR_PARTNER_SECRET",
            environment = Environment.STAGING,
            language = Language.PORTUGUESE
        )

        FlourishEventManager.addListener(this)

        val myButton: Button = findViewById(R.id.button2)

        myButton.setOnClickListener {
            // Start the Flourish library activity
            val intent = Intent("com.flourish.sdk.android.ACTION_OPEN")
            startActivity(intent)
        }

    }

    override fun onBackButtonPressedEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }

    override fun onGenericEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }

    override fun onGiftCardCopyEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }

    override fun onHomeBannerActionEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }

    override fun onMissionActionEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }

    override fun onReferralCopyEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }

    override fun onTriviaCloseEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }

    override fun onTriviaGameFinishedEvent(event: Event) {
        Log.d("LibraryEvent", "Event occurred: ${event.eventName}")
    }
}