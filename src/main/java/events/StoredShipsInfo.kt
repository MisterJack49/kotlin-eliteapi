package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class StoredShipsInfo : Event<StoredShipsInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("StationName")
    var stationName: String = ""
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("StarSystem")
    var starSystem: String = ""
    @JsonProperty("ShipsHere")
    var shipsHere: List<Any> = listOf()
    @JsonProperty("ShipsRemote")
    var shipsRemote: List<ShipsRemote> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): StoredShipsInfo =
            api.events.invokeStoredShipsEvent(
                    injectJackson().readValue(json, StoredShipsInfo::class.java)
            )
}

class ShipsRemote {
    @JsonProperty("ShipID")
    var shipId: Long = 0
    @JsonProperty("ShipType")
    var shipType: String = ""
    @JsonProperty("StarSystem")
    var starSystem: String = ""
    @JsonProperty("ShipMarketID")
    var shipMarketId: Long = 0
    @JsonProperty("TransferPrice")
    var transferPrice: Long = 0
    @JsonProperty("TransferTime")
    var transferTime: Long = 0
    @JsonProperty("Value")
    var value: Long = 0
    @JsonProperty("Hot")
    var hot: Boolean = false
    @JsonProperty("ShipType_Localised")
    var shipTypeLocalised: String = ""
    @JsonProperty("Name")
    var name: String = ""
}