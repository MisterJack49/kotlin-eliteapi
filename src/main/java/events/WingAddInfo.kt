package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class WingAddInfo : Event<WingAddInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""

    override fun process(json: String, api: EliteDangerousAPI): WingAddInfo =
            api.events.invokeWingAddEvent(
                    injectJackson().readValue(json, WingAddInfo::class.java)
            )
}