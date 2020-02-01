package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PowerplayVoucherInfo : Event<PowerplayVoucherInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Power")
    var power: String = ""
    @JsonProperty("Systems")
    var systems: List<String> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): PowerplayVoucherInfo =
            api.events.invokePowerplayVoucherEvent(
                    injectJackson().readValue(json, PowerplayVoucherInfo::class.java)
            )
}