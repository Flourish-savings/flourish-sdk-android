package com.flourish.sdk.android.events.types

import com.flourish.sdk.android.events.Event
import org.json.JSONObject

class TriviaGameFinishedEvent(val data: TriviaGameFinishedEventData,
                       override val eventName: String) : Event {
    companion object {
        fun build(event: JSONObject): TriviaGameFinishedEvent {
            val prizeList = mutableListOf<TriviaGameFinishedEventPrizes>()
            val prizesJson = event.getJSONObject("data").getJSONObject("prizes") as List<Map<String, Any>>
            prizeList.addAll(prizesJson.map { TriviaGameFinishedEventPrizes.fromJson(it) })

            val data = TriviaGameFinishedEventData(
                hits = event.getJSONObject("data").getInt("totalHitsQuestions"),
                time = event.getJSONObject("data").getString("totalTimeSeconds"),
                questions = event.getJSONObject("data").getInt("totalQuestions"),
                prizes = prizeList
            )
            return TriviaGameFinishedEvent(data, event.getString("eventName"))
        }
    }
}

data class TriviaGameFinishedEventData(val hits: Int, val questions: Int, val time: String, val prizes: List<TriviaGameFinishedEventPrizes>)

data class TriviaGameFinishedEventPrizes(val quantity: Int, val category: String, val label: String) {
    companion object {
        fun fromJson(json: Map<String, Any>): TriviaGameFinishedEventPrizes {
            return TriviaGameFinishedEventPrizes(
                quantity = json["quantity"] as Int,
                category = json["category"] as String,
                label = json["label"] as String
            )
        }
    }
}
