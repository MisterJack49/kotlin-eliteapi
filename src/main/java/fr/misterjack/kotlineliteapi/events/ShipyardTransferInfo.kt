package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ShipyardTransferInfo : Event<ShipyardTransferInfo> {

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
    @JsonProperty("System")
    var system: String = ""
    @JsonProperty("ShipMarketID")
    var shipMarketId: Long = 0
    @JsonProperty("Distance")
    var distance: Double = 0.0
    @JsonProperty("TransferPrice")
    var transferPrice: Long = 0
    @JsonProperty("TransferTime")
    var transferTime: Long = 0
    @JsonProperty("MarketID")
    var marketId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ShipyardTransferInfo =
            api.events.invokeShipyardTransferEvent(
                    injectJackson().readValue(json, ShipyardTransferInfo::class.java)
            )
}