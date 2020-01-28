package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CommunityGoalRewardInfo : Event<CommunityGoalRewardInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("System")
    var system: String = ""
    @JsonProperty("Reward")
    var reward: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): CommunityGoalRewardInfo =
            api.events.invokeCommunityGoalRewardEvent(
                    injectJackson().readValue(json, CommunityGoalRewardInfo::class.java)
            )
}