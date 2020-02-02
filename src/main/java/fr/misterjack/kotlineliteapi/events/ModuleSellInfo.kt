package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ModuleSellInfo : Event<ModuleSellInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("Slot")
    var slot: String = ""
    @JsonProperty("SellItem")
    var sellItem: String = ""
    @JsonProperty("SellItem_Localised")
    var sellItemLocalised: String = ""
    @JsonProperty("SellPrice")
    var sellPrice: Long = 0
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ModuleSellInfo =
            api.events.invokeModuleSellEvent(
                    injectJackson().readValue(json, ModuleSellInfo::class.java)
            )
}