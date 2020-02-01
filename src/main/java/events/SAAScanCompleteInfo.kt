package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class SAAScanCompleteInfo : Event<SAAScanCompleteInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("BodyName")
    var bodyName: String = ""
    @JsonProperty("BodyID")
    var bodyId: Long = 0
    @JsonProperty("ProbesUsed")
    var probesUsed: Long = 0
    @JsonProperty("EfficiencyTarget")
    var efficiencyTarget: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): SAAScanCompleteInfo =
            api.events.invokeSAAScanCompleteEvent(
                    injectJackson().readValue(json, SAAScanCompleteInfo::class.java)
            )
}