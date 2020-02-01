package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PayBountiesInfo : Event<PayBountiesInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Amount")
    var amount: Long = 0
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("Faction_Localised")
    var factionLocalised: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0
    @JsonProperty("BrokerPercentage")
    var brokerPercentage: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): PayBountiesInfo =
            api.events.invokePayBountiesEvent(
                    injectJackson().readValue(json, PayBountiesInfo::class.java)
            )
}