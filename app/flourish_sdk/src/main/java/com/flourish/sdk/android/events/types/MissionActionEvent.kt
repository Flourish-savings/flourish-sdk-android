package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class MissionActionEvent(val data: MissionActionEventData,
                         override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): MissionActionEvent {
            val data = MissionActionEventData(
                type = event.getJSONObject("data").getString("type")
            )
            return MissionActionEvent(data, event.getString("eventName"))
        }
    }
}

data class MissionActionEventData(val type: String)
