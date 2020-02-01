package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PowerplayCollectInfo : Event<PowerplayCollectInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Power")
    var power: String = ""
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Type_Localised")
    var typeLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): PowerplayCollectInfo =
            api.events.invokePowerplayCollectEvent(
                    injectJackson().readValue(json, PowerplayCollectInfo::class.java)
            )
}