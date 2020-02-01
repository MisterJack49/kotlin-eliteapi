package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class SquadronCreatedInfo : Event<SquadronCreatedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("SquadronName")
    var SquadronName: String = ""

    override fun process(json: String, api: EliteDangerousAPI): SquadronCreatedInfo =
            api.events.invokeSquadronCreatedEvent(
                    injectJackson().readValue(json, SquadronCreatedInfo::class.java)
            )
}