package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class VehicleSwitchInfo : Event<VehicleSwitchInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("To")
    var to: String = ""

    override fun process(json: String, api: EliteDangerousAPI): VehicleSwitchInfo =
            api.events.invokeVehicleSwitchEvent(
                    injectJackson().readValue(json, VehicleSwitchInfo::class.java)
            )
}