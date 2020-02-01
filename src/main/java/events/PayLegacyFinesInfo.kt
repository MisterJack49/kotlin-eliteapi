package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PayLegacyFinesInfo : Event<PayLegacyFinesInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Amount")
    var amount: Long = 0
    @JsonProperty("BrokerPercentage")
    var brokerPercentage: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): PayLegacyFinesInfo =
            api.events.invokePayLegacyFinesEvent(
                    injectJackson().readValue(json, PayLegacyFinesInfo::class.java)
            )
}