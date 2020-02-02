package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class BountyInfo : Event<BountyInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Rewards")
    var rewards: List<Reward> = listOf()
    @JsonProperty("Target")
    var target: String = ""
    @JsonProperty("TotalReward")
    var totalReward: Long = 0
    @JsonProperty("VictimFaction")
    var victimFaction: String = ""
    @JsonProperty("SharedWithOthers")
    var sharedWithOthers: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): BountyInfo =
            api.events.invokeBountyEvent(
                    injectJackson().readValue(json, BountyInfo::class.java)
            )
}

class Reward {
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("Reward")
    var rewardReward: Long = 0
}