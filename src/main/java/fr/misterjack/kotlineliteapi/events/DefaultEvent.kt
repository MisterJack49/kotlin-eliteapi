package fr.misterjack.kotlineliteapi.events

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class DefaultEvent(
        @JsonProperty
        val timestamp: Date,
        @JsonProperty("event")
        val eventName: String)