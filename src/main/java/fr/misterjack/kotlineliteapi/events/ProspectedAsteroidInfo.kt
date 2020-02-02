package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ProspectedAsteroidInfo : Event<ProspectedAsteroidInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Materials")
    var materials: List<ProspectedMaterial> = listOf()
    @JsonProperty("MotherlodeMaterial")
    var motherlodeMaterial: String = ""
    @JsonProperty("MotherlodeMaterial_Localised")
    var motherlodeMaterialLocalised: String = ""
    @JsonProperty("Content")
    var content: String = ""
    @JsonProperty("Content_Localised")
    var contentLocalised: String = ""
    @JsonProperty("Remaining")
    var remaining: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ProspectedAsteroidInfo =
            api.events.invokeProspectedAsteroidEvent(
                    injectJackson().readValue(json, ProspectedAsteroidInfo::class.java)
            )
}

class ProspectedMaterial {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Proportion")
    var proportion: Double = 0.0
}