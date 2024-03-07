package com.flourish.sdk.android.webview

import android.util.Log
import android.webkit.JavascriptInterface
import com.flourish.sdk.android.events.EventController
import com.flourish.sdk.android.events.FlourishEventManager
import org.json.JSONObject

class JSBridge {
    @JavascriptInterface
    fun receiveMessage(message:String){
        Log.i("JS_INTERFACE", message)
        val jsonObject = JSONObject(message)

        val event = EventController().convertEvent(jsonObject)
        FlourishEventManager.notifyEventOccurred(event)
    }
}
