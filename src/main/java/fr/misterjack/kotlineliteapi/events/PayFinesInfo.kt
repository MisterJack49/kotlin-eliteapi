package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class PayFinesInfo : Event<PayFinesInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Amount")
    var amount: Long = 0
    @JsonProperty("AllFines")
    var allFines: Boolean = false
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): PayFinesInfo =
            api.events.invokePayFinesEvent(
                    injectJackson().readValue(json, PayFinesInfo::class.java)
            )
}