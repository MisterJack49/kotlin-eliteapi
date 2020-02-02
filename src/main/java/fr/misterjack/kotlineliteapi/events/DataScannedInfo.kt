package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class DataScannedInfo : Event<DataScannedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Type_Localised")
    var typeLocalised: String = ""

    override fun process(json: String, api: EliteDangerousAPI): DataScannedInfo =
            api.events.invokeDataScannedEvent(
                    injectJackson().readValue(json, DataScannedInfo::class.java)
            )
}