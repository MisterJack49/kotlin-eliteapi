package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class JetConeBoostInfo : Event<JetConeBoostInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("BoostValue")
    var boostValue: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): JetConeBoostInfo =
            api.events.invokeJetConeBoostEvent(
                    injectJackson().readValue(json, JetConeBoostInfo::class.java)
            )
}