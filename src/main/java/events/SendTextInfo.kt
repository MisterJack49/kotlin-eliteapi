package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class SendTextInfo : Event<SendTextInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("To")
    var to: String = ""
    @JsonProperty("To_Localised")
    var toLocalised: String = ""
    @JsonProperty("Message")
    var message: String = ""

    override fun process(json: String, api: EliteDangerousAPI): SendTextInfo =
            api.events.invokeSendTextEvent(
                    injectJackson().readValue(json, SendTextInfo::class.java)
            )
}