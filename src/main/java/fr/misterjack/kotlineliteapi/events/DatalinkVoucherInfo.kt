package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class DatalinkVoucherInfo : Event<DatalinkVoucherInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Reward")
    var reward: Long = 0
    @JsonProperty("VictimFaction")
    var victimFaction: String = ""
    @JsonProperty("PayeeFaction")
    var payeeFaction: String = ""

    override fun process(json: String, api: EliteDangerousAPI): DatalinkVoucherInfo =
            api.events.invokeDatalinkVoucherEvent(
                    injectJackson().readValue(json, DatalinkVoucherInfo::class.java)
            )
}