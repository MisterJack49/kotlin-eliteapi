package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ModuleRetrieveInfo : Event<ModuleRetrieveInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("Slot")
    var slot: String = ""
    @JsonProperty("RetrievedItem")
    var retrievedItem: String = ""
    @JsonProperty("RetrievedItem_Localised")
    var retrievedItemLocalised: String = ""
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
    @JsonProperty("SwapOutItem")
    var swapOutItem: String = ""
    @JsonProperty("SwapOutItem_Localised")
    var swapOutItemLocalised: String = ""

    override fun process(json: String, api: EliteDangerousAPI): ModuleRetrieveInfo =
            api.events.invokeModuleRetrieveEvent(
                    injectJackson().readValue(json, ModuleRetrieveInfo::class.java)
            )
}