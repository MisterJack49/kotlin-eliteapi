package fr.misterjack.kotlineliteapi.events

import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import java.util.Date

interface Event<T> {
    val timestamp: Date
    val eventName: String

    fun process(json: String, api: EliteDangerousAPI): T
}