package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ModuleStoreInfo : Event<ModuleStoreInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("Slot")
    var slot: String = ""
    @JsonProperty("StoredItem")
    var storedItem: String = ""
    @JsonProperty("StoredItem_Localised")
    var storedItemLocalised: String = ""
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0
    @JsonProperty("Hot")
    var hot: Boolean = false
    @JsonProperty("EngineerModifications")
    var engineerModifications: String = ""
    @JsonProperty("Level")
    var level: Long = 0
    @JsonProperty("Quality")
    var quality: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): ModuleStoreInfo =
            api.events.invokeModuleStoreEvent(
                    injectJackson().readValue(json, ModuleStoreInfo::class.java)
            )
}