package events

import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ApproachBodyInfo : Event<ApproachBodyInfo> {

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


    override fun process(json: String, api: EliteDangerousAPI): ApproachBodyInfo =
            api.events.invokeApproachBodyEvent(
                    injectJackson().readValue(json, ApproachBodyInfo::class.java)
            )

}