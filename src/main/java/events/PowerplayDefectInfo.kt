package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PowerplayDefectInfo : Event<PowerplayDefectInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("FromPower")
    var fromPower: String = ""
    @JsonProperty("ToPower")
    var toPower: String = ""

    override fun process(json: String, api: EliteDangerousAPI): PowerplayDefectInfo =
            api.events.invokePowerplayDefectEvent(
                    injectJackson().readValue(json, PowerplayDefectInfo::class.java)
            )
}