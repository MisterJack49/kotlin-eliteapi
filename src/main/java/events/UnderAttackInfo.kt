package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class UnderAttackInfo : Event<UnderAttackInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Target")
    var target: String = ""

    override fun process(json: String, api: EliteDangerousAPI): UnderAttackInfo =
            api.events.invokeUnderAttackEvent(
                    injectJackson().readValue(json, UnderAttackInfo::class.java)
            )
}