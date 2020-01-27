package events

import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import injectJackson
import java.util.Date

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class ReservoirReplenishedInfo : Event<ReservoirReplenishedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("FuelMain")
    var fuelMain: Double = 0.0
    @JsonProperty("FuelReservoir")
    var fuelReservoir: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): ReservoirReplenishedInfo =
            api.events.invokeReservoirReplenishedEvent(
                    injectJackson().readValue(json, ReservoirReplenishedInfo::class.java)
            )

}
