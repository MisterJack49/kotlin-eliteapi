package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ShipyardBuyInfo : Event<ShipyardBuyInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("ShipType")
    var shipType: String = "-"
    @JsonProperty("ShipType_Localised")
    var shipTypeLocalised: String = "-"
    @JsonProperty("ShipPrice")
    var shipPrice: Long = 0
    @JsonProperty("StoreOldShip")
    var storeOldShip: String = "-"
    @JsonProperty("StoreShipID")
    var storeShipId: Long = 0
    @JsonProperty("MarketID")
    var marketId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ShipyardBuyInfo =
            api.events.invokeShipyardBuyEvent(
                    injectJackson().readValue(json, ShipyardBuyInfo::class.java)
            )
}