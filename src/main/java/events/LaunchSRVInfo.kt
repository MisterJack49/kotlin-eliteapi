package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class LaunchSRVInfo : Event<LaunchSRVInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Loadout")
    var loadout: String = ""
    @JsonProperty("PlayerControlled")
    var playerControlled: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): LaunchSRVInfo =
            api.events.invokeLaunchSRVEvent(
                    injectJackson().readValue(json, LaunchSRVInfo::class.java)
            )
}