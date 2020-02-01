package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class EscapeInterdictionInfo : Event<EscapeInterdictionInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Interdictor")
    var interdictor: String = ""
    @JsonProperty("Interdictor_Localised")
    var interdictorLocalised: String = ""
    @JsonProperty("IsPlayer")
    var isPlayer: Boolean = false

    override fun process(json: String, api: EliteDangerousAPI): EscapeInterdictionInfo =
            api.events.invokeEscapeInterdictionEvent(
                    injectJackson().readValue(json, EscapeInterdictionInfo::class.java)
            )
}