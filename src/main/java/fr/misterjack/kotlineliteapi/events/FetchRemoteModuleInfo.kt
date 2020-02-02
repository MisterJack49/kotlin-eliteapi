package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class FetchRemoteModuleInfo : Event<FetchRemoteModuleInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("StorageSlot")
    var storageSlot: Long = 0
    @JsonProperty("StoredItem")
    var storedItem: String = ""
    @JsonProperty("StoredItem_Localised")
    var storedItemLocalised: String = ""
    @JsonProperty("ServerId")
    var serverId: Long = 0
    @JsonProperty("TransferCost")
    var transferCost: Long = 0
    @JsonProperty("TransferTime")
    var transferTime: Long = 0
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): FetchRemoteModuleInfo =
            api.events.invokeFetchRemoteModuleEvent(
                    injectJackson().readValue(json, FetchRemoteModuleInfo::class.java)
            )
}