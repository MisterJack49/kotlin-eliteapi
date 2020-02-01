package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class DockingDeniedInfo : Event<DockingDeniedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Reason")
    var reason: String = ""
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("StationName")
    var stationName: String = ""
    @JsonProperty("StationType")
    var stationType: String = ""

    override fun process(json: String, api: EliteDangerousAPI): DockingDeniedInfo =
            api.events.invokeDockingDeniedEvent(
                    injectJackson().readValue(json, DockingDeniedInfo::class.java)
            )
}