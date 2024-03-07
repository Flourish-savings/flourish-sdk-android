package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class GiftCardCopyEvent(val data: GiftCardCopyEventData,
                             override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): GiftCardCopyEvent {
            val data = GiftCardCopyEventData(
                giftCardCode = event.getJSONObject("data").getString("giftCardCode")
            )
            return GiftCardCopyEvent(data, event.getString("eventName"))
        }
    }
}

data class GiftCardCopyEventData(val giftCardCode: String)
