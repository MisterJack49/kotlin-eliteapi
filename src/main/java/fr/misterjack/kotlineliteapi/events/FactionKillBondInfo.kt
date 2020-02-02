package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class FactionKillBondInfo : Event<FactionKillBondInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Reward")
    var reward: Long = 0
    @JsonProperty("AwardingFaction")
    var awardingFaction: String = ""
    @JsonProperty("AwardingFaction_Localised")
    var awardingFactionLocalised: String = ""
    @JsonProperty("VictimFaction")
    var victimFaction: String = ""
    @JsonProperty("VictimFaction_Localised")
    var victimFactionLocalised: String = ""

    override fun process(json: String, api: EliteDangerousAPI): FactionKillBondInfo =
            api.events.invokeFactionKillBondEvent(
                    injectJackson().readValue(json, FactionKillBondInfo::class.java)
            )
}