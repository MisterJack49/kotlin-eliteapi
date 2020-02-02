package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MaterialsInfo : Event<MaterialsInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Raw")
    var raw: List<Raw> = listOf()
    @JsonProperty("Manufactured")
    var manufactured: List<Encoded> = listOf()
    @JsonProperty("Encoded")
    var encoded: List<Encoded> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): MaterialsInfo =
            api.events.invokeMaterialsEvent(
                    injectJackson().readValue(json, MaterialsInfo::class.java)
            )
}

class Encoded {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
}

class Raw {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Count")
    var count: Long = 0
}