package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ChangeCrewRoleInfo : Event<ChangeCrewRoleInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Role")
    var role: String = ""

    override fun process(json: String, api: EliteDangerousAPI): ChangeCrewRoleInfo =
            api.events.invokeChangeCrewRoleEvent(
                    injectJackson().readValue(json, ChangeCrewRoleInfo::class.java)
            )
}