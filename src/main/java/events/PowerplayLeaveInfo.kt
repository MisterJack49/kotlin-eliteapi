package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PowerplayLeaveInfo : Event<PowerplayLeaveInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Power")
    var power: String = ""

    override fun process(json: String, api: EliteDangerousAPI): PowerplayLeaveInfo =
            api.events.invokePowerplayLeaveEvent(
                    injectJackson().readValue(json, PowerplayLeaveInfo::class.java)
            )
}