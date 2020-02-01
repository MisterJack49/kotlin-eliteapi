package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class StartJumpInfo : Event<StartJumpInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("JumpType")
    var jumpType: String = ""
    @JsonProperty("StarSystem")
    var starSystem: String = ""
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("StarClass")
    var starClass: String = ""

    override fun process(json: String, api: EliteDangerousAPI): StartJumpInfo =
            api.events.invokeStartJumpEvent(
                    injectJackson().readValue(json, StartJumpInfo::class.java)
            )
}