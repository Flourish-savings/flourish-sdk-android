package com.flourish.sdk.android.events

import com.flourish.sdk.android.events.types.*
import org.json.JSONObject

class EventController {

    private val BACK_BUTTON_PRESSED = "BACK_BUTTON_PRESSED"
    private val TRIVIA_GAME_FINISHED = "TRIVIA_GAME_FINISHED"
    private val TRIVIA_CLOSED = "TRIVIA_CLOSED"
    private val REFERRAL_COPY = "REFERRAL_COPY"
    private val GIFT_CARD_COPY = "GIFT_CARD_COPY"
    private val HOME_BANNER_ACTION = "HOME_BANNER_ACTION"
    private val MISSION_ACTION = "MISSION_ACTION"

    fun convertEvent(event: JSONObject): Event {
        return when (event.getString("eventName")) {
            BACK_BUTTON_PRESSED -> BackButtonPressedEvent.build(event)
            TRIVIA_GAME_FINISHED -> TriviaGameFinishedEvent.build(event)
            TRIVIA_CLOSED -> TriviaCloseEvent.build(event)
            REFERRAL_COPY -> ReferralCopyEvent.build(event)
            GIFT_CARD_COPY -> GiftCardCopyEvent.build(event)
            HOME_BANNER_ACTION -> HomeBannerActionEvent.build(event)
            MISSION_ACTION -> MissionActionEvent.build(event)
            else -> GenericEvent.build(event)
        }
    }

}
