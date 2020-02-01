package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class OutfittingInfo : Event<OutfittingInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("StationName")
    var stationName: String = ""
    @JsonProperty("StarSystem")
    var starSystem: String = ""

    override fun process(json: String, api: EliteDangerousAPI): OutfittingInfo =
            api.events.invokeOutfittingEvent(
                    injectJackson().readValue(json, OutfittingInfo::class.java)
            )
}

