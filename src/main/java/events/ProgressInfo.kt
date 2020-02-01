package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ProgressInfo : Event<ProgressInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Combat")
    var combat: Long = 0
    @JsonProperty("Trade")
    var trade: Long = 0
    @JsonProperty("Explore")
    var explore: Long = 0
    @JsonProperty("Empire")
    var empire: Long = 0
    @JsonProperty("Federation")
    var federation: Long = 0
    @JsonProperty("CQC")
    var cqc: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ProgressInfo =
            api.events.invokeProgressEvent(
                    injectJackson().readValue(json, ProgressInfo::class.java)
            )
}