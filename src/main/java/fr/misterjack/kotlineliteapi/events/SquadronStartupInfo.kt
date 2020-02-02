package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class SquadronStartupInfo : Event<SquadronStartupInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("SquadronName")
    var squadronName: String = ""
    @JsonProperty("CurrentRank")
    var currentRank: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): SquadronStartupInfo =
            api.events.invokeSquadronStartupEvent(
                    injectJackson().readValue(json, SquadronStartupInfo::class.java)
            )
}