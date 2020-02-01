package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class WingInviteInfo : Event<WingInviteInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""

    override fun process(json: String, api: EliteDangerousAPI): WingInviteInfo =
            api.events.invokeWingInviteEvent(
                    injectJackson().readValue(json, WingInviteInfo::class.java)
            )
}