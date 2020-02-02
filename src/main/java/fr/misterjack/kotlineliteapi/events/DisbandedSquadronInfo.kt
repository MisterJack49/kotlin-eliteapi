package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class DisbandedSquadronInfo : Event<DisbandedSquadronInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("SquadronName")
    var squadronName: String = ""

    override fun process(json: String, api: EliteDangerousAPI): DisbandedSquadronInfo =
            api.events.invokeDisbandedSquadronEvent(
                    injectJackson().readValue(json, DisbandedSquadronInfo::class.java)
            )
}