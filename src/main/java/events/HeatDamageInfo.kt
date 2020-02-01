package events

import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class HeatDamageInfo : Event<HeatDamageInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): HeatDamageInfo =
            api.events.invokeHeatDamageEvent(
                    injectJackson().readValue(json, HeatDamageInfo::class.java)
            )
}