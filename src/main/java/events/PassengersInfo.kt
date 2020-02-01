package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PassengersInfo : Event<PassengersInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Manifest")
    var manifest: List<Manifest> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): PassengersInfo =
            api.events.invokePassengersEvent(
                    injectJackson().readValue(json, PassengersInfo::class.java)
            )
}

class Manifest {
    @JsonProperty("MissionID")
    var missionId: Long = 0
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("VIP")
    var vip: Boolean = false
    @JsonProperty("Wanted")
    var wanted: Boolean = false
    @JsonProperty("Count")
    var count: Long = 0
}