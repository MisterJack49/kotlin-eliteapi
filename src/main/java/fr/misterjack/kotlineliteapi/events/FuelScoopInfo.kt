package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class FuelScoopInfo : Event<FuelScoopInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Scooped")
    var scooped: Double = 0.0
    @JsonProperty("Total")
    var total: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): FuelScoopInfo =
            api.events.invokeFuelScoopEvent(
                    injectJackson().readValue(json, FuelScoopInfo::class.java)
            )
}