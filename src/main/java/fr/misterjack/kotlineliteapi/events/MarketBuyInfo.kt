package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MarketBuyInfo : Event<MarketBuyInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Type_Localised")
    var typeLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("BuyPrice")
    var buyPrice: Long = 0
    @JsonProperty("TotalCost")
    var totalCost: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): MarketBuyInfo =
            api.events.invokeMarketBuyEvent(
                    injectJackson().readValue(json, MarketBuyInfo::class.java)
            )
}