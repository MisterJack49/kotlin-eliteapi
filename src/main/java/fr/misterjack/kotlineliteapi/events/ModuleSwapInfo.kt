package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ModuleSwapInfo : Event<ModuleSwapInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("FromSlot")
    var fromSlot: String = ""
    @JsonProperty("ToSlot")
    var toSlot: String = ""
    @JsonProperty("FromItem")
    var fromItem: String = ""
    @JsonProperty("FromItem_Localised")
    var fromItemLocalised: String = ""
    @JsonProperty("ToItem")
    var toItem: String = ""
    @JsonProperty("ToItem_Localised")
    var toItemLocalised: String = ""
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ModuleSwapInfo =
            api.events.invokeModuleSwapEvent(
                    injectJackson().readValue(json, ModuleSwapInfo::class.java)
            )
}