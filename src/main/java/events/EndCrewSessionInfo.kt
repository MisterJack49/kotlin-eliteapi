package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class EndCrewSessionInfo : Event<EndCrewSessionInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("OnCrime")
    var onCrime: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): EndCrewSessionInfo =
            api.events.invokeEndCrewSessionEvent(
                    injectJackson().readValue(json, EndCrewSessionInfo::class.java)
            )
}