package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class HomeBannerActionEvent(val data: HomeBannerActionEventData,
                             override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): HomeBannerActionEvent {
            val data = HomeBannerActionEventData(
                data = event.getJSONObject("data").getString("data")
            )
            return HomeBannerActionEvent(data, event.getString("eventName"))
        }
    }
}

data class HomeBannerActionEventData(val data: String)
