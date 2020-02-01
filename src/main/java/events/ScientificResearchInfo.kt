package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ScientificResearchInfo : Event<ScientificResearchInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Category")
    var category: String = ""
    @JsonProperty("Count")
    var count: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ScientificResearchInfo =
            api.events.invokeScientificResearchEvent(
                    injectJackson().readValue(json, ScientificResearchInfo::class.java)
            )
}