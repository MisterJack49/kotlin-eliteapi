package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class SupercruiseEntryInfo : Event<SupercruiseEntryInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("StarSystem")
    var starSystem: String = ""
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): SupercruiseEntryInfo =
            api.events.invokeSupercruiseEntryEvent(
                    injectJackson().readValue(json, SupercruiseEntryInfo::class.java)
            )
}