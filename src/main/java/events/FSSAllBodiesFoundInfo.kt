package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class FSSAllBodiesFoundInfo : Event<FSSAllBodiesFoundInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("SystemName")
    var systemName: String = ""
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("Count")
    var count: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): FSSAllBodiesFoundInfo =
            api.events.invokeFSSAllBodiesFoundEvent(
                    injectJackson().readValue(json, FSSAllBodiesFoundInfo::class.java)
            )
}