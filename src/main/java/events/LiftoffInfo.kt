package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class LiftoffInfo : Event<LiftoffInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("PlayerControlled")
    var playerControlled: Boolean = false
    @JsonProperty("Latitude")
    var latitude: Double = 0.0
    @JsonProperty("Longitude")
    var longitude: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): LiftoffInfo =
            api.events.invokeLiftoffEvent(
                    injectJackson().readValue(json, LiftoffInfo::class.java)
            )
}