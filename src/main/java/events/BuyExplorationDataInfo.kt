package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class BuyExplorationDataInfo : Event<BuyExplorationDataInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("System")
    var system: String = ""
    @JsonProperty("Cost")
    var cost: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): BuyExplorationDataInfo =
            api.events.invokeBuyExplorationDataEvent(
                    injectJackson().readValue(json, BuyExplorationDataInfo::class.java)
            )
}