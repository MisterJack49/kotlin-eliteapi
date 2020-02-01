package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class JoinedSquadronInfo : Event<JoinedSquadronInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("SquadronName")
    var squadronName: String = ""

    override fun process(json: String, api: EliteDangerousAPI): JoinedSquadronInfo =
            api.events.invokeJoinedSquadronEvent(
                    injectJackson().readValue(json, JoinedSquadronInfo::class.java)
            )
}