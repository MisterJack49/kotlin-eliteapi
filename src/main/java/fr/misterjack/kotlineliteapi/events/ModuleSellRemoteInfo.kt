package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ModuleSellRemoteInfo : Event<ModuleSellRemoteInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("StorageSlot")
    var storageSlot: Long = 0
    @JsonProperty("SellItem")
    var sellItem: String = ""
    @JsonProperty("SellItem_Localised")
    var sellItemLocalised: String = ""
    @JsonProperty("ServerId")
    var serverId: Long = 0
    @JsonProperty("SellPrice")
    var sellPrice: Long = 0
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ModuleSellRemoteInfo =
            api.events.invokeModuleSellRemoteEvent(
                    injectJackson().readValue(json, ModuleSellRemoteInfo::class.java)
            )
}