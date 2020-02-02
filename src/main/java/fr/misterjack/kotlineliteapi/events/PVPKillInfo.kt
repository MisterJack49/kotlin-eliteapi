package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class PVPKillInfo : Event<PVPKillInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Victim")
    var victim: String = ""
    @JsonProperty("CombatRank")
    var combatRank: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): PVPKillInfo =
            api.events.invokePVPKillEvent(
                    injectJackson().readValue(json, PVPKillInfo::class.java)
            )
}