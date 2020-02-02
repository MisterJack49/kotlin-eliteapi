package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MarketSellInfo : Event<MarketSellInfo> {

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
    @JsonProperty("SellPrice")
    var sellPrice: Long = 0
    @JsonProperty("TotalSale")
    var totalSale: Long = 0
    @JsonProperty("AvgPricePaid")
    var avgPricePaid: Long = 0
    @JsonProperty("StolenGoods")
    var stolenGoods: Boolean = false
    @JsonProperty("BlackMarket")
    var blackMarket: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): MarketSellInfo =
            api.events.invokeMarketSellEvent(
                    injectJackson().readValue(json, MarketSellInfo::class.java)
            )
}