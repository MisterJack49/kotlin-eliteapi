package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class DockingGrantedInfo : Event<DockingGrantedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("LandingPad")
    var landingPad: Long = 0
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("StationName")
    var stationName: String = ""
    @JsonProperty("StationType")
    var stationType: String = ""

    override fun process(json: String, api: EliteDangerousAPI): DockingGrantedInfo =
            api.events.invokeDockingGrantedEvent(
                    injectJackson().readValue(json, DockingGrantedInfo::class.java)
            )
}