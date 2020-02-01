package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ShieldStateInfo : Event<ShieldStateInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("ShieldsUp")
    var shieldsUp: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): ShieldStateInfo =
            api.events.invokeShieldStateEvent(
                    injectJackson().readValue(json, ShieldStateInfo::class.java)
            )
}