package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class InterdictedInfo : Event<InterdictedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Submitted")
    var submitted : Boolean =false
    @JsonProperty("Interdictor")
    var interdictor : String =""
    @JsonProperty("Interdictor_Localised")
    var interdictorLocalised : String =""
    @JsonProperty("IsPlayer")
    var isPlayer : Boolean =false
    @JsonProperty("Faction")
    var faction : String =""

    override fun process(json: String, api: EliteDangerousAPI): InterdictedInfo =
            api.events.invokeInterdictedEvent(
                    injectJackson().readValue(json, InterdictedInfo::class.java)
            )
}