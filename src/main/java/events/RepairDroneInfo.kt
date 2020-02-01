package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class RepairDroneInfo : Event<RepairDroneInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("HullRepaired")
    var hullRepaired: Double = 0.0
    @JsonProperty("CockpitRepaired")
    var cockpitRepaired: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): RepairDroneInfo =
            api.events.invokeRepairDroneEvent(
                    injectJackson().readValue(json, RepairDroneInfo::class.java)
            )
}