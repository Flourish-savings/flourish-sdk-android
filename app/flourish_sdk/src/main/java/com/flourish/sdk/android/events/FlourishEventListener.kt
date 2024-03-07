package com.flourish.sdk.android.events


interface FlourishEventListener {
    fun onBackButtonPressedEvent(event: Event)
    fun onGenericEvent(event: Event)
    fun onGiftCardCopyEvent(event: Event)
    fun onHomeBannerActionEvent(event: Event)
    fun onMissionActionEvent(event: Event)
    fun onReferralCopyEvent(event: Event)
    fun onTriviaCloseEvent(event: Event)
    fun onTriviaGameFinishedEvent(event: Event)
}