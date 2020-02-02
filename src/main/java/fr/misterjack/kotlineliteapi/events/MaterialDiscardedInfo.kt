package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MaterialDiscardedInfo : Event<MaterialDiscardedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Category")
    var category: String = ""
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Count")
    var count: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): MaterialDiscardedInfo =
            api.events.invokeMaterialDiscardedEvent(
                    injectJackson().readValue(json, MaterialDiscardedInfo::class.java)
            )
}