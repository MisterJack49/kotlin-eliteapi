package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CrewMemberJoinsInfo : Event<CrewMemberJoinsInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Crew")
    var crew: String = ""

    override fun process(json: String, api: EliteDangerousAPI): CrewMemberJoinsInfo =
            api.events.invokeCrewMemberJoinsEvent(
                    injectJackson().readValue(json, CrewMemberJoinsInfo::class.java)
            )
}