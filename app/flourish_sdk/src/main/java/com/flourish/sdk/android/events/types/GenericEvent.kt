package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class GenericEvent(val data: Any,
                   override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): GenericEvent {
            val data = event.getJSONObject("data")
            return GenericEvent(data, event.getString("eventName"))
        }
    }
}
