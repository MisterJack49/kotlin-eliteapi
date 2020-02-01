package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ShutdownInfo : Event<ShutdownInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): ShutdownInfo =
            api.events.invokeShutdownEvent(
                    injectJackson().readValue(json, ShutdownInfo::class.java)
            )
}