package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class NewCommanderInfo : Event<NewCommanderInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Package")
    var packageName: String = ""


    override fun process(json: String, api: EliteDangerousAPI): NewCommanderInfo =
            api.events.invokeNewCommanderEvent(
                    injectJackson().readValue(json, NewCommanderInfo::class.java)
            )
}