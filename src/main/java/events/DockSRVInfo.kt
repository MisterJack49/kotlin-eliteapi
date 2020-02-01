package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class DockSRVInfo : Event<DockSRVInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): DockSRVInfo =
            api.events.invokeDockSRVEvent(
                    injectJackson().readValue(json, DockSRVInfo::class.java)
            )
}