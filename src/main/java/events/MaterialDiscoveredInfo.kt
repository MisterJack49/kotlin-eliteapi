package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class MaterialDiscoveredInfo : Event<MaterialDiscoveredInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Category")
    var category: String = ""
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("DiscoveryNumber")
    var discoveryNumber: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): MaterialDiscoveredInfo =
            api.events.invokeMaterialDiscoveredEvent(
                    injectJackson().readValue(json, MaterialDiscoveredInfo::class.java)
            )
}