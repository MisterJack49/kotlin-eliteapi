package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class AsteroidCrackedInfo : Event<AsteroidCrackedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Body")
    var body: String = ""

    override fun process(json: String, api: EliteDangerousAPI): AsteroidCrackedInfo =
            api.events.invokeAsteroidCrackedEvent(
                    injectJackson().readValue(json, AsteroidCrackedInfo::class.java)
            )
}