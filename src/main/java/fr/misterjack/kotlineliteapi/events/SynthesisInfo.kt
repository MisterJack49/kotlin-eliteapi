package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class SynthesisInfo : Event<SynthesisInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Materials")
    var materials: List<SynthesisMaterial> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): SynthesisInfo =
            api.events.invokeSynthesisEvent(
                    injectJackson().readValue(json, SynthesisInfo::class.java)
            )
}

class SynthesisMaterial {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
}