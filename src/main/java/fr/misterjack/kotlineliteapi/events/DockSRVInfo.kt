package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class DockSRVInfo : Event<DockSRVInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): DockSRVInfo =
            api.events.invokeDockSRVEvent(
                    injectJackson().readValue(json, DockSRVInfo::class.java)
            )
}