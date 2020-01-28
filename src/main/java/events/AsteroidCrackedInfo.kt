package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class AsteroidCrackedInfo : Event<AsteroidCrackedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Body")
    var body: String = ""

    override fun process(json: String, api: EliteDangerousAPI): AsteroidCrackedInfo =
            api.events.invokeAsteroidCrackedEvent(
                    injectJackson().readValue(json, AsteroidCrackedInfo::class.java)
            )
}