package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class BuyTradeDataInfo : Event<BuyTradeDataInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("System")
    var system: String = ""
    @JsonProperty("Cost")
    var cost: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): BuyTradeDataInfo =
            api.events.invokeBuyTradeDataEvent(
                    injectJackson().readValue(json, BuyTradeDataInfo::class.java)
            )
}