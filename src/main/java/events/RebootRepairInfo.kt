package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class RebootRepairInfo : Event<RebootRepairInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Modules")
    var modules: List<String> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): RebootRepairInfo =
            api.events.invokeRebootRepairEvent(
                    injectJackson().readValue(json, RebootRepairInfo::class.java)
            )
}