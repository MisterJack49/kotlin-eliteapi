package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class PowerplayJoinInfo : Event<PowerplayJoinInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Power")
    var power: String = ""

    override fun process(json: String, api: EliteDangerousAPI): PowerplayJoinInfo =
            api.events.invokePowerplayJoinEvent(
                    injectJackson().readValue(json, PowerplayJoinInfo::class.java)
            )
}