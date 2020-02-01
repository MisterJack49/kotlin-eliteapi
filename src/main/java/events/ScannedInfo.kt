package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ScannedInfo : Event<ScannedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("ScanType")
    var scanType: String = ""

    override fun process(json: String, api: EliteDangerousAPI): ScannedInfo =
            api.events.invokeScannedEvent(
                    injectJackson().readValue(json, ScannedInfo::class.java)
            )
}