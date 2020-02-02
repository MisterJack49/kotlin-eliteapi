package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MassModuleStoreInfo : Event<MassModuleStoreInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    var event: String = ""
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0
    @JsonProperty("Items")
    var items: List<Item> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): MassModuleStoreInfo =
            api.events.invokeMassModuleStoreEvent(
                    injectJackson().readValue(json, MassModuleStoreInfo::class.java)
            )
}

class Item {
    @JsonProperty("Slot")
    var slot: String = ""
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Hot")
    var hot: Boolean = false
    @JsonProperty("EngineerModifications")
    var engineerModifications: String = ""
    @JsonProperty("Level")
    var level: Long = 0
    @JsonProperty("Quality")
    var quality: Double = 0.0
}