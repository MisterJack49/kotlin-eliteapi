package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CargoDepotInfo : Event<CargoDepotInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MissionID")
    var missionId: Long = 0
    @JsonProperty("UpdateType")
    var updateType: String = ""
    @JsonProperty("CargoType")
    var cargoType: String = ""
    @JsonProperty("CargoType_Localised")
    var cargoTypeLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("StartMarketID")
    var startMarketId: Long = 0
    @JsonProperty("EndMarketID")
    var endMarketId: Long = 0
    @JsonProperty("ItemsCollected")
    var itemsCollected: Long = 0
    @JsonProperty("ItemsDelivered")
    var itemsDelivered: Long = 0
    @JsonProperty("TotalItemsToDeliver")
    var totalItemsToDeliver: Long = 0
    @JsonProperty("Progress")
    var progress: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): CargoDepotInfo =
            api.events.invokeCargoDepotEvent(
                    injectJackson().readValue(json, CargoDepotInfo::class.java)
            )
}