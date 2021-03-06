package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class RepairInfo : Event<RepairInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Item")
    var item: String = ""
    @JsonProperty("Cost")
    var cost: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): RepairInfo =
            api.events.invokeRepairEvent(
                    injectJackson().readValue(json, RepairInfo::class.java)
            )
}