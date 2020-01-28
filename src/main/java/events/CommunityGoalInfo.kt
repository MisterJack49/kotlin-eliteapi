package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CommunityGoalInfo : Event<CommunityGoalInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("CurrentGoals")
    var currentGoals: List<CurrentGoal> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): CommunityGoalInfo =
            api.events.invokeCommunityGoalEvent(
                    injectJackson().readValue(json, CommunityGoalInfo::class.java)
            )
}

class CurrentGoal {
    @JsonProperty("CGID")
    var cgid: Long = 0
    @JsonProperty("Title")
    var title: String = ""
    @JsonProperty("SystemName")
    var systemName: String = ""
    @JsonProperty("MarketName")
    var marketName: String = ""
    @JsonProperty("Expiry")
    var expiry: Date = Date()
    @JsonProperty("IsComplete")
    var isComplete: Boolean = false
    @JsonProperty("CurrentTotal")
    var currentTotal: Long = 0
    @JsonProperty("PlayerContribution")
    var playerContribution: Long = 0
    @JsonProperty("NumContributors")
    var numContributors: Long = 0
    @JsonProperty("TopRankSize")
    var topRankSize: Long = 0
    @JsonProperty("PlayerInTopRank")
    var playerInTopRank: Boolean = false
    @JsonProperty("TierReached")
    var tierReached: String = ""
    @JsonProperty("PlayerPercentileBand")
    var playerPercentileBand: Long = 0
    @JsonProperty("Bonus")
    var bonus: Long = 0
}