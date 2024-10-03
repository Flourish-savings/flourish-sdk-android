package com.flourish.sdk.android.webview

import android.content.Context
import android.content.Intent
import android.util.Log
import android.webkit.JavascriptInterface
import com.flourish.sdk.android.ErrorActivity
import com.flourish.sdk.android.events.FlourishEventManager
import com.flourish.sdk.android.events.types.GenericEvent
import com.flourish.sdk.android.events.types.ReferralCopyEvent
import org.json.JSONObject


class JSBridge(private val context: Context) {
    @JavascriptInterface
    fun receiveMessage(message:String){
        Log.i("JS_INTERFACE", message)
        val jsonObject = JSONObject(message)

        val event = GenericEvent.build(jsonObject)

        if(event.eventName == "INVALID_TOKEN") {
            val intent = Intent(context, ErrorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

        if(event.eventName == "REFERRAL_COPY") {
            val referralCopyEvent = event as ReferralCopyEvent
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, referralCopyEvent.data.referralCode)
            context.startActivity(Intent.createChooser(shareIntent, null))
        }

        FlourishEventManager.notifyEventOccurred(event)
    }
}
