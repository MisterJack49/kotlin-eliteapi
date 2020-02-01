package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class QuitACrewInfo : Event<QuitACrewInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Captain")
    var captain: String = ""

    override fun process(json: String, api: EliteDangerousAPI): QuitACrewInfo =
            api.events.invokeQuitACrewEvent(
                    injectJackson().readValue(json, QuitACrewInfo::class.java)
            )
}