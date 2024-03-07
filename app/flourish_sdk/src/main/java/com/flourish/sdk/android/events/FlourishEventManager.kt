package com.flourish.sdk.android.events

object FlourishEventManager {
    private val listeners = mutableListOf<FlourishEventListener>()

    fun addListener(listener: FlourishEventListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: FlourishEventListener) {
        listeners.remove(listener)
    }

    fun notifyEventOccurred(event: Event) {
        for (listener in listeners) {
            listener.onBackButtonPressedEvent(event)
        }
    }
}
