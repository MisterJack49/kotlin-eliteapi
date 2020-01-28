package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CrewMemberRoleChangeInfo : Event<CrewMemberRoleChangeInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Crew")
    var crew: String = ""
    @JsonProperty("Role")
    var role: String = ""

    override fun process(json: String, api: EliteDangerousAPI): CrewMemberRoleChangeInfo =
            api.events.invokeCrewMemberRoleChangeEvent(
                    injectJackson().readValue(json, CrewMemberRoleChangeInfo::class.java)
            )
}