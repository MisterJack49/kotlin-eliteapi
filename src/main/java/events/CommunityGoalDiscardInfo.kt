package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CommunityGoalDiscardInfo : Event<CommunityGoalDiscardInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("System")
    var system: String = ""

    override fun process(json: String, api: EliteDangerousAPI): CommunityGoalDiscardInfo =
            api.events.invokeCommunityGoalDiscardEvent(
                    injectJackson().readValue(json, CommunityGoalDiscardInfo::class.java)
            )
}