package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class KickCrewMemberInfo : Event<KickCrewMemberInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Crew")
    var crew: String = ""
    @JsonProperty("OnCrime")
    var onCrime: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): KickCrewMemberInfo =
            api.events.invokeKickCrewMemberEvent(
                    injectJackson().readValue(json, KickCrewMemberInfo::class.java)
            )
}