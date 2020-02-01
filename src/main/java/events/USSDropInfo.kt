package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class USSDropInfo : Event<USSDropInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("USSType")
    var ussType: String = ""
    @JsonProperty("USSType_Localised")
    var ussTypeLocalised: String = ""
    @JsonProperty("USSThreat")
    var ussThreat: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): USSDropInfo =
            api.events.invokeUSSDropEvent(
                    injectJackson().readValue(json, USSDropInfo::class.java)
            )
}