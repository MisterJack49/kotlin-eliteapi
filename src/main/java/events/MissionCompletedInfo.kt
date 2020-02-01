package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class MissionCompletedInfo : Event<MissionCompletedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("MissionID")
    var missionId: Long = 0
    @JsonProperty("TargetType")
    var targetType: String = ""
    @JsonProperty("TargetType_Localised")
    var targetTypeLocalised: String = ""
    @JsonProperty("TargetFaction")
    var targetFaction: String = ""
    @JsonProperty("NewDestinationSystem")
    var newDestinationSystem: String = ""
    @JsonProperty("DestinationSystem")
    var destinationSystem: String = ""
    @JsonProperty("NewDestinationStation")
    var newDestinationStation: String = ""
    @JsonProperty("DestinationStation")
    var destinationStation: String = ""
    @JsonProperty("Target")
    var target: String = ""
    @JsonProperty("Reward")
    var reward: Long = 0
    @JsonProperty("MaterialsReward")
    var materialsReward: List<MaterialsReward> = listOf()
    @JsonProperty("FactionEffects")
    var factionEffects: List<FactionEffect> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): MissionCompletedInfo =
            api.events.invokeMissionCompletedEvent(
                    injectJackson().readValue(json, MissionCompletedInfo::class.java)
            )

}

class FactionEffect {
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("Effects")
    var effects: List<Effect> = listOf()
    @JsonProperty("Influence")
    var influence: List<Influence> = listOf()
    @JsonProperty("ReputationTrend")
    var reputationTrend: String = ""
    @JsonProperty("Reputation")
    var reputation: String = ""
}

class Effect {
    @JsonProperty("Effect")
    var effectEffect: String = ""
    @JsonProperty("Effect_Localised")
    var effectLocalised: String = ""
    @JsonProperty("Trend")
    var trend: String = ""
}

class Influence {
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("Trend")
    var trend: String = ""
    @JsonProperty("Influence")
    var influenceInfluence: String = ""
}

class MaterialsReward {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Category")
    var category: String = ""
    @JsonProperty("Category_Localised")
    var categoryLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
}