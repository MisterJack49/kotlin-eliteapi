package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ModuleInfoInfo : Event<ModuleInfoInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): ModuleInfoInfo =
            api.events.invokeModuleInfoEvent(
                    injectJackson().readValue(json, ModuleInfoInfo::class.java)
            )
}