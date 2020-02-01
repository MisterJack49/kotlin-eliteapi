package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class MaterialCollectedInfo : Event<MaterialCollectedInfo> {

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
    @JsonProperty("Count")
    var count: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): MaterialCollectedInfo =
            api.events.invokeMaterialCollectedEvent(
                    injectJackson().readValue(json, MaterialCollectedInfo::class.java)
            )
}