package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class SellExplorationDataInfo : Event<SellExplorationDataInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Systems")
    var systems: List<String> = listOf()
    @JsonProperty("Discovered")
    var discovered: List<String> = listOf()
    @JsonProperty("BaseValue")
    var baseValue: Long = 0
    @JsonProperty("Bonus")
    var bonus: Long = 0
    @JsonProperty("TotalEarnings")
    var totalEarnings: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): SellExplorationDataInfo =
            api.events.invokeSellExplorationDataEvent(
                    injectJackson().readValue(json, SellExplorationDataInfo::class.java)
            )
}