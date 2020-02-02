package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ModuleBuyInfo : Event<ModuleBuyInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Slot")
    var slot: String = ""
    @JsonProperty("SellItem")
    var sellItem: String = ""
    @JsonProperty("SellItem_Localised")
    var sellItemLocalised: String = ""
    @JsonProperty("SellPrice")
    var sellPrice: Long = 0
    @JsonProperty("BuyItem")
    var buyItem: String = ""
    @JsonProperty("BuyItem_Localised")
    var buyItemLocalised: String = ""
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("BuyPrice")
    var buyPrice: Long = 0
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ModuleBuyInfo =
            api.events.invokeModuleBuyEvent(
                    injectJackson().readValue(json, ModuleBuyInfo::class.java)
            )
}