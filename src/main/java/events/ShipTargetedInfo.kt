package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ShipTargetedInfo : Event<ShipTargetedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("TargetLocked")
    var targetLocked: Boolean = false
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("Ship_Localised")
    var shipLocalised: String = ""
    @JsonProperty("ScanStage")
    var scanStage: Long = 0
    @JsonProperty("PilotName")
    var pilotName: String = ""
    @JsonProperty("PilotName_Localised")
    var pilotNameLocalised: String = ""
    @JsonProperty("PilotRank")
    var pilotRank: String = ""
    @JsonProperty("ShieldHealth")
    var shieldHealth: Double = 0.0
    @JsonProperty("HullHealth")
    var hullHealth: Double = 0.0
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("LegalStatus")
    var legalStatus: String = ""
    @JsonProperty("Bounty")
    var bounty: Long = 0
    @JsonProperty("Subsystem")
    var subsystem: String = ""
    @JsonProperty("Subsystem_Localised")
    var subsystemLocalised: String = ""
    @JsonProperty("SubsystemHealth")
    var subsystemHealth: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): ShipTargetedInfo =
            api.events.invokeShipTargetedEvent(
                    injectJackson().readValue(json, ShipTargetedInfo::class.java)
            )
}