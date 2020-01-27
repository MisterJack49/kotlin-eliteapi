package events

import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class AfmuRepairsInfo : Event<AfmuRepairsInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Module")
    var module: String = ""
    @JsonProperty("Module_Localised")
    var moduleLocalised: String = ""
    @JsonProperty("FullyRepaired")
    var fullyRepaired: Boolean = false
    @JsonProperty("Health")
    var health: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): AfmuRepairsInfo =
            api.events.invokeAfmuRepairsEvent(
                    injectJackson().readValue(json, AfmuRepairsInfo::class.java)
            )
}
