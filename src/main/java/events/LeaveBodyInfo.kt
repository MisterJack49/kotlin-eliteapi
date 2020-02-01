package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class LeaveBodyInfo : Event<LeaveBodyInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("StarSystem")
    var starSystem: String = ""
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("Body")
    var body: String = ""
    @JsonProperty("BodyID")
    var bodyId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): LeaveBodyInfo =
            api.events.invokeLeaveBodyEvent(
                    injectJackson().readValue(json, LeaveBodyInfo::class.java)
            )
}