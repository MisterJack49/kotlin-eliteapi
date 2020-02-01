package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class MiningRefinedInfo : Event<MiningRefinedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Type_Localised")
    var typeLocalised: String = ""

    override fun process(json: String, api: EliteDangerousAPI): MiningRefinedInfo =
            api.events.invokeMiningRefinedEvent(
                    injectJackson().readValue(json, MiningRefinedInfo::class.java)
            )
}