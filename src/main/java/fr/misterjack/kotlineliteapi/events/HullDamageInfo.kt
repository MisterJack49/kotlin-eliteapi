package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class HullDamageInfo : Event<HullDamageInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Health")
    var health: Double = 0.0
    @JsonProperty("PlayerPilot")
    var playerPilot: Boolean = false
    @JsonProperty("Fighter")
    var fighter: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): HullDamageInfo =
            api.events.invokeHullDamageEvent(
                    injectJackson().readValue(json, HullDamageInfo::class.java)
            )
}