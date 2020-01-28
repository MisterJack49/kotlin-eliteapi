package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CrewMemberQuitsInfo : Event<CrewMemberQuitsInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Crew")
    var crew: String = ""

    override fun process(json: String, api: EliteDangerousAPI): CrewMemberQuitsInfo =
            api.events.invokeCrewMemberQuitsEvent(
                    injectJackson().readValue(json, CrewMemberQuitsInfo::class.java)
            )
}