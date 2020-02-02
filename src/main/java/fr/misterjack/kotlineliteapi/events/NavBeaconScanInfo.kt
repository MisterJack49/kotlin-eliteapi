package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class NavBeaconScanInfo : Event<NavBeaconScanInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("NumBodies")
    var numBodies: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): NavBeaconScanInfo =
            api.events.invokeNavBeaconScanEvent(
                    injectJackson().readValue(json, NavBeaconScanInfo::class.java)
            )
}