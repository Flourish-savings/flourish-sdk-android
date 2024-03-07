package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class BackButtonPressedEvent(val data: BackButtonPressedData,
                             override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): BackButtonPressedEvent {
            val data = BackButtonPressedData(
                path = event.getJSONObject("data").getString("path")
            )
            return BackButtonPressedEvent(data, event.getString("eventName"))
        }
    }
}

data class BackButtonPressedData(val path: String)
