package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class LocationInfo : Event<LocationInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Docked")
    var docked: Boolean = false
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
    @JsonProperty("Body")
    var body: String = ""
    @JsonProperty("BodyID")
    var bodyId: Long = 0
    @JsonProperty("BodyType")
    var bodyType: String = ""
    @JsonProperty("Factions")
    var factions: List<Faction> = listOf()
    @JsonProperty("SystemFaction")
    var systemFaction: SystemFaction = SystemFaction()

    override fun process(json: String, api: EliteDangerousAPI): LocationInfo =
            api.events.invokeLocationEvent(
                    injectJackson().readValue(json, LocationInfo::class.java)
            )
}

class Faction {
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
    @JsonProperty("ActiveStates")
    var activeStates: List<ActiveState> = listOf()
}

class ActiveState {
    @JsonProperty("State")
    var state: String = ""
}

class SystemFaction {
    @JsonProperty("Name")
    var name: String = ""
}