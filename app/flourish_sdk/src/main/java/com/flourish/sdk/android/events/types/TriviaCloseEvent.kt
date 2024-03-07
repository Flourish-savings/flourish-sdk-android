package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class TriviaCloseEvent(val data: TriviaCloseEventData,
                       override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): TriviaCloseEvent {
            val prizeList = mutableListOf<TriviaCloseEventPrizes>()
            val prizesJson = event.getJSONObject("data").getJSONObject("prizes") as List<Map<String, Any>>
            prizeList.addAll(prizesJson.map { TriviaCloseEventPrizes.fromJson(it) })

            val data = TriviaCloseEventData(
                hits = event.getJSONObject("data").getInt("totalHitsQuestions"),
                time = event.getJSONObject("data").getString("totalTimeSeconds"),
                questions = event.getJSONObject("data").getInt("totalQuestions"),
                prizes = prizeList
            )
            return TriviaCloseEvent(data, event.getString("eventName"))
        }
    }
}

data class TriviaCloseEventData(val hits: Int, val questions: Int, val time: String, val prizes: List<TriviaCloseEventPrizes>)

data class TriviaCloseEventPrizes(val quantity: Int, val category: String, val label: String) {
    companion object {
        fun fromJson(json: Map<String, Any>): TriviaCloseEventPrizes {
            return TriviaCloseEventPrizes(
                quantity = json["quantity"] as Int,
                category = json["category"] as String,
                label = json["label"] as String
            )
        }
    }
}
