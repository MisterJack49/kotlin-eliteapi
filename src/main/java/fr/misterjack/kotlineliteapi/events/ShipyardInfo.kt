package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ShipyardInfo : Event<ShipyardInfo> {

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

    override fun process(json: String, api: EliteDangerousAPI): ShipyardInfo =
            api.events.invokeShipyardEvent(
                    injectJackson().readValue(json, ShipyardInfo::class.java)
            )
}