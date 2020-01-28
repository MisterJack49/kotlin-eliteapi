package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class BuyAmmoInfo : Event<BuyAmmoInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Cost")
    var cost: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): BuyAmmoInfo =
            api.events.invokeBuyAmmoEvent(
                    injectJackson().readValue(json, BuyAmmoInfo::class.java)
            )
}