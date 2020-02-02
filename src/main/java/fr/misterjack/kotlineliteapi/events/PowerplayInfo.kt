package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class PowerplayInfo : Event<PowerplayInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Power")
    var power: String = ""
    @JsonProperty("Rank")
    var rank: Long = 0
    @JsonProperty("Merits")
    var merits: Long = 0
    @JsonProperty("Votes")
    var votes: Long = 0
    @JsonProperty("TimePledged")
    var timePledged: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): PowerplayInfo =
            api.events.invokePowerplayEvent(
                    injectJackson().readValue(json, PowerplayInfo::class.java)
            )
}