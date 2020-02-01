package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ShipyardSwapInfo : Event<ShipyardSwapInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("ShipType")
    var shipType: String = ""
    @JsonProperty("ShipType_Localised")
    var shipTypeLocalised: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0
    @JsonProperty("StoreOldShip")
    var storeOldShip: String = ""
    @JsonProperty("StoreShipID")
    var storeShipId: Long = 0
    @JsonProperty("MarketID")
    var marketId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ShipyardSwapInfo =
            api.events.invokeShipyardSwapEvent(
                    injectJackson().readValue(json, ShipyardSwapInfo::class.java)
            )
}