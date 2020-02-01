package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class StoredModulesInfo : Event<StoredModulesInfo> {

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
    @JsonProperty("Items")
    var items: List<StoredModuleItem> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): StoredModulesInfo =
            api.events.invokeStoredModulesEvent(
                    injectJackson().readValue(json, StoredModulesInfo::class.java)
            )
}

class StoredModuleItem {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("StorageSlot")
    var storageSlot: Long = 0
    @JsonProperty("StarSystem")
    var starSystem: String = ""
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("TransferCost")
    var transferCost: Long = 0
    @JsonProperty("TransferTime")
    var transferTime: Long = 0
    @JsonProperty("BuyPrice")
    var buyPrice: Long = 0
    @JsonProperty("Hot")
    var hot: Boolean = false
    @JsonProperty("EngineerModifications")
    var engineerModifications: String = ""
    @JsonProperty("Level")
    var level: Long = 0
    @JsonProperty("Quality")
    var quality: Double = 0.0
}
