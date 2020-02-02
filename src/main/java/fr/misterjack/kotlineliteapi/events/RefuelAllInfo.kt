package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class RefuelAllInfo : Event<RefuelAllInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Cost")
    var cost: Long = 0
    @JsonProperty("Amount")
    var amount: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): RefuelAllInfo =
            api.events.invokeRefuelAllEvent(
                    injectJackson().readValue(json, RefuelAllInfo::class.java)
            )
}