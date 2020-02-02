package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MultiSellExplorationDataInfo : Event<MultiSellExplorationDataInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Discovered")
    var discovered: List<Discovered> = listOf()
    @JsonProperty("BaseValue")
    var baseValue: Long = 0
    @JsonProperty("Bonus")
    var bonus: Long = 0
    @JsonProperty("TotalEarnings")
    var totalEarnings: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): MultiSellExplorationDataInfo =
            api.events.invokeMultiSellExplorationDataEvent(
                    injectJackson().readValue(json, MultiSellExplorationDataInfo::class.java)
            )
}

class Discovered {
    @JsonProperty("SystemName")
    var systemName: String = ""
    @JsonProperty("NumBodies")
    var numBodies: Long = 0
}