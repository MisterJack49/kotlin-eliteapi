package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class CrewLaunchFighterInfo : Event<CrewLaunchFighterInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Crew")
    var crew: String = ""

    override fun process(json: String, api: EliteDangerousAPI): CrewLaunchFighterInfo =
            api.events.invokeCrewLaunchFighterEvent(
                    injectJackson().readValue(json, CrewLaunchFighterInfo::class.java)
            )
}