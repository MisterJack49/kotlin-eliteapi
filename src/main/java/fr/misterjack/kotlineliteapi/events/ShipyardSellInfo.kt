package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ShipyardSellInfo : Event<ShipyardSellInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("ShipType")
    var shipType: String = ""
    @JsonProperty("ShipType_Localised")
    var shipTypeLocalised: String = ""
    @JsonProperty("SellShipID")
    var sellShipId: Long = 0
    @JsonProperty("ShipPrice")
    var shipPrice: Long = 0
    @JsonProperty("MarketID")
    var marketId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ShipyardSellInfo =
            api.events.invokeShipyardSellEvent(
                    injectJackson().readValue(json, ShipyardSellInfo::class.java)
            )
}