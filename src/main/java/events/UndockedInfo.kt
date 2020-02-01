package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class UndockedInfo : Event<UndockedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("StationName")
    var stationName: String = ""
    @JsonProperty("StationType")
    var stationType: String = ""
    @JsonProperty("MarketID")
    var marketId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): UndockedInfo =
            api.events.invokeUndockedEvent(
                    injectJackson().readValue(json, UndockedInfo::class.java)
            )
}