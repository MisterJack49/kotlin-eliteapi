package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class WingLeaveInfo : Event<WingLeaveInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): WingLeaveInfo =
            api.events.invokeWingLeaveEvent(
                    injectJackson().readValue(json, WingLeaveInfo::class.java)
            )
}