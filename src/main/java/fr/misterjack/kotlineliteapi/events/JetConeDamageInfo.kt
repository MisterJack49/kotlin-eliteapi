package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class JetConeDamageInfo : Event<JetConeDamageInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Module")
    var module: String = ""
    @JsonProperty("Module_Localised")
    var moduleLocalised: String = ""

    override fun process(json: String, api: EliteDangerousAPI): JetConeDamageInfo =
            api.events.invokeJetConeDamageEvent(
                    injectJackson().readValue(json, JetConeDamageInfo::class.java)
            )
}