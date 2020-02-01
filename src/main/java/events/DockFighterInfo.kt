package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class DockFighterInfo : Event<DockFighterInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): DockFighterInfo =
            api.events.invokeDockFighterEvent(
                    injectJackson().readValue(json, DockFighterInfo::class.java)
            )
}