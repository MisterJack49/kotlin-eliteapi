package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class DiscoveryScanInfo : Event<DiscoveryScanInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("Bodies")
    var bodies: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): DiscoveryScanInfo =
            api.events.invokeDiscoveryScanEvent(
                    injectJackson().readValue(json, DiscoveryScanInfo::class.java)
            )
}