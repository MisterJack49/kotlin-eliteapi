package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class EjectCargoInfo : Event<EjectCargoInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Type_Localised")
    var typeLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("Abandoned")
    var abandoned: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): EjectCargoInfo =
            api.events.invokeEjectCargoEvent(
                    injectJackson().readValue(json, EjectCargoInfo::class.java)
            )
}