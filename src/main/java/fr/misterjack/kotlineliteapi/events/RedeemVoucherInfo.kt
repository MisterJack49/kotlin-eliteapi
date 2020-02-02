package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class RedeemVoucherInfo : Event<RedeemVoucherInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Amount")
    var amount: Long = 0
    @JsonProperty("Factions")
    var factions: List<FSDFaction> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): RedeemVoucherInfo =
            api.events.invokeRedeemVoucherEvent(
                    injectJackson().readValue(json, RedeemVoucherInfo::class.java)
            )
}

class FSDFaction {
    @JsonProperty("Faction")
    var factionFaction: String = ""
    @JsonProperty("Amount")
    var amount: Long = 0
}