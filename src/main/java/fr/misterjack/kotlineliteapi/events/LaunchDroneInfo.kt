package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class LaunchDroneInfo : Event<LaunchDroneInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Type")
    var Type: String = ""

    override fun process(json: String, api: EliteDangerousAPI): LaunchDroneInfo =
            api.events.invokeLaunchDroneEvent(
                    injectJackson().readValue(json, LaunchDroneInfo::class.java)
            )
}