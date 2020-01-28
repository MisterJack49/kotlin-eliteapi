package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ApproachSettlementInfo : Event<ApproachSettlementInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("Latitude")
    var latitude: Double = 0.0
    @JsonProperty("Longitude")
    var longitude: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): ApproachSettlementInfo =
            api.events.invokeApproachSettlementEvent(
                    injectJackson().readValue(json, ApproachSettlementInfo::class.java)
            )
}