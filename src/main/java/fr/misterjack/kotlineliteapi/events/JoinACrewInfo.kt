package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class JoinACrewInfo : Event<JoinACrewInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Captain")
    var captain: String = ""

    override fun process(json: String, api: EliteDangerousAPI): JoinACrewInfo =
            api.events.invokeJoinACrewEvent(
                    injectJackson().readValue(json, JoinACrewInfo::class.java)
            )
}