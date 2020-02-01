package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ReceiveTextInfo : Event<ReceiveTextInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("From")
    var from: String = ""
    @JsonProperty("From_Localised")
    var fromLocalised: String = ""
    @JsonProperty("Message")
    var message: String = ""
    @JsonProperty("Message_Localised")
    var messageLocalised: String = ""
    @JsonProperty("Channel")
    var channel: String = ""

    override fun process(json: String, api: EliteDangerousAPI): ReceiveTextInfo =
            api.events.invokeReceiveTextEvent(
                    injectJackson().readValue(json, ReceiveTextInfo::class.java)
            )
}