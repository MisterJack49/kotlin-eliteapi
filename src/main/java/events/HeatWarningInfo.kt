package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class HeatWarningInfo : Event<HeatWarningInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): HeatWarningInfo =
            api.events.invokeHeatWarningEvent(
                    injectJackson().readValue(json, HeatWarningInfo::class.java)
            )
}