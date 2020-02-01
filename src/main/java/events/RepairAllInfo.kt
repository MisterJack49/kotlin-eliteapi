package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class RepairAllInfo : Event<RepairAllInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Cost")
    var cost: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): RepairAllInfo =
            api.events.invokeRepairAllEvent(
                    injectJackson().readValue(json, RepairAllInfo::class.java)
            )
}