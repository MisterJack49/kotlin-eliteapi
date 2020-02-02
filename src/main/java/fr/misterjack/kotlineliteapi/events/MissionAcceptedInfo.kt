package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MissionAcceptedInfo : Event<MissionAcceptedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("LocalisedName")
    var localisedName: String = ""
    @JsonProperty("Commodity")
    var commodity: String = ""
    @JsonProperty("Commodity_Localised")
    var commodityLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("DestinationSystem")
    var destinationSystem: String = ""
    @JsonProperty("Expiry")
    var expiry: Date = Date()
    @JsonProperty("Influence")
    var influence: String = ""
    @JsonProperty("Reputation")
    var reputation: String = ""
    @JsonProperty("Reward")
    var reward: Long = 0
    @JsonProperty("PassengerCount")
    var passengerCount: Long = 0
    @JsonProperty("PassengerVIPs")
    var passengerViPs: Boolean = false
    @JsonProperty("PassengerWanted")
    var passengerWanted: Boolean = false
    @JsonProperty("PassengerType")
    var passengerType: String = ""
    @JsonProperty("MissionID")
    var missionId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): MissionAcceptedInfo =
            api.events.invokeMissionAcceptedEvent(
                    injectJackson().readValue(json, MissionAcceptedInfo::class.java)
            )
}