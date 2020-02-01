package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class KickCrewMemberInfo : Event<KickCrewMemberInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Crew")
    var crew: String = ""
    @JsonProperty("OnCrime")
    var onCrime: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): KickCrewMemberInfo =
            api.events.invokeKickCrewMemberEvent(
                    injectJackson().readValue(json, KickCrewMemberInfo::class.java)
            )
}