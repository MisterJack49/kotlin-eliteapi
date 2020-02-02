package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class FSDJumpInfo : Event<FSDJumpInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("StarSystem")
    var starSystem: String = ""
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("StarPos")
    var starPos: List<Double> = listOf()
    @JsonProperty("SystemAllegiance")
    var systemAllegiance: String = ""
    @JsonProperty("SystemEconomy")
    var systemEconomy: String = ""
    @JsonProperty("SystemEconomy_Localised")
    var systemEconomyLocalised: String = ""
    @JsonProperty("SystemSecondEconomy")
    var systemSecondEconomy: String = ""
    @JsonProperty("SystemSecondEconomy_Localised")
    var systemSecondEconomyLocalised: String = ""
    @JsonProperty("SystemGovernment")
    var systemGovernment: String = ""
    @JsonProperty("SystemGovernment_Localised")
    var systemGovernmentLocalised: String = ""
    @JsonProperty("SystemSecurity")
    var systemSecurity: String = ""
    @JsonProperty("SystemSecurity_Localised")
    var systemSecurityLocalised: String = ""
    @JsonProperty("Population")
    var population: Long = 0
    @JsonProperty("Powers")
    var powers: List<String> = listOf()
    @JsonProperty("PowerplayState")
    var powerplayState: String = ""
    @JsonProperty("JumpDist")
    var jumpDist: Double = 0.0
    @JsonProperty("FuelUsed")
    var fuelUsed: Double = 0.0
    @JsonProperty("FuelLevel")
    var fuelLevel: Double = 0.0
    @JsonProperty("Factions")
    var jumpFactions: List<FSDJumpFaction> = listOf()
    @JsonProperty("SystemFaction")
    var systemFaction: SystemFaction = SystemFaction()
    @JsonProperty("FactionState")
    var factionState: String = ""

    override fun process(json: String, api: EliteDangerousAPI): FSDJumpInfo =
            api.events.invokeFSDJumpEvent(
                    injectJackson().readValue(json, FSDJumpInfo::class.java)
            )
}

class FSDJumpFaction {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("FactionState")
    var factionState: String = ""
    @JsonProperty("Government")
    var government: String = ""
    @JsonProperty("Influence")
    var influence: Double = 0.0
    @JsonProperty("Allegiance")
    var allegiance: String = ""
    @JsonProperty("Happiness")
    var happiness: String = ""
    @JsonProperty("Happiness_Localised")
    var happinessLocalised: String = ""
    @JsonProperty("MyReputation")
    var myReputation: Double = 0.0
    @JsonProperty("RecoveringStates")
    var recoveringStates: List<IngState> = listOf()
    @JsonProperty("PendingStates")
    var pendingStates: List<IngState> = listOf()
    @JsonProperty("ActiveStates")
    var activeStates: List<ActiveState> = listOf()
}

class FSDActiveState {
    @JsonProperty("State")
    var state: String = ""
}

class IngState {
    @JsonProperty("State")
    var state: String = ""
    @JsonProperty("Trend")
    var trend: Long = 0
}