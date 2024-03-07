package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class GenericEvent(val data: GenericEventData,
                         override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): GenericEvent {
            val data = GenericEventData(
                data = event.getJSONObject("data").getString("data")
            )
            return GenericEvent(data, event.getString("eventName"))
        }
    }
}

data class GenericEventData(val data: String)
