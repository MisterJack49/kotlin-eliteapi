package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CockpitBreachedInfo : Event<CockpitBreachedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): CockpitBreachedInfo =
            api.events.invokeCockpitBreachedEvent(
                    injectJackson().readValue(json, CockpitBreachedInfo::class.java)
            )
}