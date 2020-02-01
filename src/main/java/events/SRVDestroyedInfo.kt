package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class SRVDestroyedInfo : Event<SRVDestroyedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): SRVDestroyedInfo =
            api.events.invokeSRVDestroyedEvent(
                    injectJackson().readValue(json, SRVDestroyedInfo::class.java)
            )
}