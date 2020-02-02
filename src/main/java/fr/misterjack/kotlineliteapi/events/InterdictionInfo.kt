package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class InterdictionInfo : Event<InterdictionInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Success")
    var success: Boolean = false
    @JsonProperty("IsPlayer")
    var isPlayer: Boolean = false
    @JsonProperty("Interdicted")
    var interdicted: String = ""
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("Power")
    var power: String = ""

    override fun process(json: String, api: EliteDangerousAPI): InterdictionInfo =
            api.events.invokeInterdictionEvent(
                    injectJackson().readValue(json, InterdictionInfo::class.java)
            )
}