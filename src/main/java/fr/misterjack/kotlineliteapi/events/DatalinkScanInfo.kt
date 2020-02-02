package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class DatalinkScanInfo : Event<DatalinkScanInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Message")
    var message: String = ""
    @JsonProperty("Message_Localised")
    var messageLocalised: String = ""

    override fun process(json: String, api: EliteDangerousAPI): DatalinkScanInfo =
            api.events.invokeDatalinkScanEvent(
                    injectJackson().readValue(json, DatalinkScanInfo::class.java)
            )
}