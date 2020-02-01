package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class SystemsShutdownInfo : Event<SystemsShutdownInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): SystemsShutdownInfo =
            api.events.invokeSystemsShutdownEvent(
                    injectJackson().readValue(json, SystemsShutdownInfo::class.java)
            )
}