package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MissionRedirectedInfo : Event<MissionRedirectedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MissionID")
    var missionId: Long = 0
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("NewDestinationStation")
    var newDestinationStation: String = ""
    @JsonProperty("NewDestinationSystem")
    var newDestinationSystem: String = ""
    @JsonProperty("OldDestinationStation")
    var oldDestinationStation: String = ""
    @JsonProperty("OldDestinationSystem")
    var oldDestinationSystem: String = ""

    override fun process(json: String, api: EliteDangerousAPI): MissionRedirectedInfo =
            api.events.invokeMissionRedirectedEvent(
                    injectJackson().readValue(json, MissionRedirectedInfo::class.java)
            )
}