package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class FSSDiscoveryScanInfo : Event<FSSDiscoveryScanInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Progress")
    var progress: Double = 0.0
    @JsonProperty("BodyCount")
    var bodyCount: Long = 0
    @JsonProperty("NonBodyCount")
    var nonBodyCount: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): FSSDiscoveryScanInfo =
            api.events.invokeFSSDiscoveryScanEvent(
                    injectJackson().readValue(json, FSSDiscoveryScanInfo::class.java)
            )
}