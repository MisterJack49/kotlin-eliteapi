package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class FSSSignalDiscoveredInfo : Event<FSSSignalDiscoveredInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("SignalName")
    var signalName: String = ""
    @JsonProperty("SignalName_Localised")
    var signalNameLocalised: String = ""
    @JsonProperty("USSType")
    var ussType: String = ""
    @JsonProperty("USSType_Localised")
    var ussTypeLocalised: String = ""
    @JsonProperty("SpawningState")
    var spawningState: String = ""
    @JsonProperty("SpawningState_Localised")
    var spawningStateLocalised: String = ""
    @JsonProperty("SpawningFaction")
    var spawningFaction: String = ""
    @JsonProperty("ThreatLevel")
    var threatLevel: Long = 0
    @JsonProperty("TimeRemaining")
    var timeRemaining: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): FSSSignalDiscoveredInfo =
            api.events.invokeFSSSignalDiscoveredEvent(
                    injectJackson().readValue(json, FSSSignalDiscoveredInfo::class.java)
            )
}