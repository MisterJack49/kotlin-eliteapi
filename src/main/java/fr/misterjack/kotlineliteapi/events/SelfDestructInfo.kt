package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class SelfDestructInfo : Event<SelfDestructInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): SelfDestructInfo =
            api.events.invokeSelfDestructEvent(
                    injectJackson().readValue(json, SelfDestructInfo::class.java)
            )
}