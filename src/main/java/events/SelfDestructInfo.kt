package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class SelfDestructInfo : Event<SelfDestructInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String

    override fun process(json: String, api: EliteDangerousAPI): SelfDestructInfo =
            api.events.invokeSelfDestructEvent(
                    injectJackson().readValue(json, SelfDestructInfo::class.java)
            )
}