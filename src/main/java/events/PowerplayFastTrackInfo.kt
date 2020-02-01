package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PowerplayFastTrackInfo : Event<PowerplayFastTrackInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Power")
    var power: String = ""
    @JsonProperty("Cost")
    var cost: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): PowerplayFastTrackInfo =
            api.events.invokePowerplayFastTrackEvent(
                    injectJackson().readValue(json, PowerplayFastTrackInfo::class.java)
            )
}