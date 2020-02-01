package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class SearchAndRescueInfo : Event<SearchAndRescueInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("Reward")
    var reward: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): SearchAndRescueInfo =
            api.events.invokeSearchAndRescueEvent(
                    injectJackson().readValue(json, SearchAndRescueInfo::class.java)
            )
}

