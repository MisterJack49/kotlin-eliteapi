package events

import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.util.Date

class ReservoirReplenishedInfo(@JsonProperty
                               val timestamp: Date,
                               @JsonProperty("event")
                               val eventName: String,
                               @JsonProperty("FuelMain")
                               val fuelMain: Double,
                               @JsonProperty("FuelReservoir")
                               val fuelReservoir: Double) {

    companion object : Event<ReservoirReplenishedInfo> {
        override fun process(json: String, api: EliteDangerousAPI): ReservoirReplenishedInfo =
                api.events.invokeReservoirReplenishedEvent(
                        jacksonObjectMapper().readValue(json, ReservoirReplenishedInfo::class.java)
                )
    }

}
