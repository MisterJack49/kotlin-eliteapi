package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MarketInfo : Event<MarketInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("StationName")
    var stationName: String = ""
    @JsonProperty("StarSystem")
    var starSystem: String = ""

    override fun process(json: String, api: EliteDangerousAPI): MarketInfo =
            api.events.invokeMarketEvent(
                    injectJackson().readValue(json, MarketInfo::class.java)
            )
}