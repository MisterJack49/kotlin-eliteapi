package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class CrewAssignInfo : Event<CrewAssignInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("CrewID")
    var crewId: Long = 0
    @JsonProperty("Role")
    var role: String = ""

    override fun process(json: String, api: EliteDangerousAPI): CrewAssignInfo =
            api.events.invokeCrewAssignEvent(
                    injectJackson().readValue(json, CrewAssignInfo::class.java)
            )
}