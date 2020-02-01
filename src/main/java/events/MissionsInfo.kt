package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class MissionsInfo : Event<MissionsInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Active")
    var active: List<Active> = listOf()
    @JsonProperty("Failed")
    var failed: List<Any> = listOf()
    @JsonProperty("Complete")
    var complete: List<Any> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): MissionsInfo =
            api.events.invokeMissionsEvent(
                    injectJackson().readValue(json, MissionsInfo::class.java)
            )
}

class Active {
    @JsonProperty("MissionID")
    var missionId: Long = 0
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("PassengerMission")
    var passengerMission: Boolean = false
    @JsonProperty("Expires")
    var expires: Long = 0
}