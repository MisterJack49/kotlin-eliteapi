package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CollectCargoInfo : Event<CollectCargoInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Type_Localised")
    var typeLocalised: String = ""
    @JsonProperty("Stolen")
    var stolen: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): CollectCargoInfo =
            api.events.invokeCollectCargoEvent(
                    injectJackson().readValue(json, CollectCargoInfo::class.java)
            )
}