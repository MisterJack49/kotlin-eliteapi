package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class WingJoinInfo : Event<WingJoinInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Others")
    var others: List<String> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): WingJoinInfo =
            api.events.invokeWingJoinEvent(
                    injectJackson().readValue(json, WingJoinInfo::class.java)
            )
}