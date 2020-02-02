package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ShieldStateInfo : Event<ShieldStateInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("ShieldsUp")
    var shieldsUp: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): ShieldStateInfo =
            api.events.invokeShieldStateEvent(
                    injectJackson().readValue(json, ShieldStateInfo::class.java)
            )
}