package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class EngineerProgressInfo : Event<EngineerProgressInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Engineers")
    var engineers: List<Engineer> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): EngineerProgressInfo =
            api.events.invokeEngineerProgressEvent(
                    injectJackson().readValue(json, EngineerProgressInfo::class.java)
            )
}

class Engineer {
    @JsonProperty("Engineer")
    var engineerEngineer: String = ""
    @JsonProperty("EngineerID")
    var engineerId: Long = 0
    @JsonProperty("Progress")
    var progress: String = ""
    @JsonProperty("RankProgress")
    var rankProgress: Long = 0
    @JsonProperty("Rank")
    var rank: Long = 0
}