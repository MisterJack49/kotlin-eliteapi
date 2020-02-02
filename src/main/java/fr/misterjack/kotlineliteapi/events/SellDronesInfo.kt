package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class SellDronesInfo : Event<SellDronesInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("SellPrice")
    var sellPrice: Long = 0
    @JsonProperty("TotalSale")
    var totalSale: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): SellDronesInfo =
            api.events.invokeSellDronesEvent(
                    injectJackson().readValue(json, SellDronesInfo::class.java)
            )
}