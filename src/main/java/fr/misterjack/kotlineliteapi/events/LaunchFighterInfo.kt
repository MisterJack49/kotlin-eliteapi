package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class LaunchFighterInfo : Event<LaunchFighterInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Loadout")
    var loadout: String = ""
    @JsonProperty("PlayerControlled")
    var playerControlled: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): LaunchFighterInfo =
            api.events.invokeLaunchFighterEvent(
                    injectJackson().readValue(json, LaunchFighterInfo::class.java)
            )
}