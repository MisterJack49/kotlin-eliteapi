package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class CrewHireInfo : Event<CrewHireInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("CrewID")
    var crewId: Long = 0
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("Cost")
    var cost: Long = 0
    @JsonProperty("CombatRank")
    var combatRank: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): CrewHireInfo =
            api.events.invokeCrewHireEvent(
                    injectJackson().readValue(json, CrewHireInfo::class.java)
            )
}