package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ResurrectInfo : Event<ResurrectInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Option")
    var option: String = ""
    @JsonProperty("Cost")
    var cost: Long = 0
    @JsonProperty("Bankrupt")
    var bankrupt: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): ResurrectInfo =
            api.events.invokeResurrectEvent(
                    injectJackson().readValue(json, ResurrectInfo::class.java)
            )
}