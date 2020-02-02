package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class PowerplaySalaryInfo : Event<PowerplaySalaryInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Power")
    var power: String = ""
    @JsonProperty("Amount")
    var amount: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): PowerplaySalaryInfo =
            api.events.invokePowerplaySalaryEvent(
                    injectJackson().readValue(json, PowerplaySalaryInfo::class.java)
            )
}