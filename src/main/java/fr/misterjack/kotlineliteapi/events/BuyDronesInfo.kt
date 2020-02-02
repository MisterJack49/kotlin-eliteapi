package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class BuyDronesInfo : Event<BuyDronesInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("BuyPrice")
    var buyPrice: Long = 0
    @JsonProperty("TotalCost")
    var totalCost: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): BuyDronesInfo =
            api.events.invokeBuyDronesEvent(
                    injectJackson().readValue(json, BuyDronesInfo::class.java)
            )
}