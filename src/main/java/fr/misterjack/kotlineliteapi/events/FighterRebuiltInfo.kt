package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class FighterRebuiltInfo : Event<FighterRebuiltInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Loadout")
    var loadout: String = ""

    override fun process(json: String, api: EliteDangerousAPI): FighterRebuiltInfo =
            api.events.invokeFighterRebuiltEvent(
                    injectJackson().readValue(json, FighterRebuiltInfo::class.java)
            )
}