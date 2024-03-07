package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class ReferralCopyEvent(val data: ReferralCopyEventData,
                         override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): ReferralCopyEvent {
            val data = ReferralCopyEventData(
                referralCode = event.getJSONObject("data").getString("referralCode")
            )
            return ReferralCopyEvent(data, event.getString("eventName"))
        }
    }
}

data class ReferralCopyEventData(val referralCode: String)
