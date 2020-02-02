package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class RestockVehicleInfo : Event<RestockVehicleInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Loadout")
    var loadout: String = ""
    @JsonProperty("Cost")
    var cost: Long = 0
    @JsonProperty("Count")
    var count: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): RestockVehicleInfo =
            api.events.invokeRestockVehicleEvent(
                    injectJackson().readValue(json, RestockVehicleInfo::class.java)
            )
}