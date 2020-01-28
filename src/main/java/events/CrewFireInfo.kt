package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CrewFireInfo : Event<CrewFireInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("CrewID")
    var crewId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): CrewFireInfo =
            api.events.invokeCrewFireEvent(
                    injectJackson().readValue(json, CrewFireInfo::class.java)
            )
}