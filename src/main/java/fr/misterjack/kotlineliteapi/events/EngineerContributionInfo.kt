package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class EngineerContributionInfo : Event<EngineerContributionInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Engineer")
    var engineer: String = ""
    @JsonProperty("Type")
    var type: String = ""
    @JsonProperty("Material")
    var material: String = ""
    @JsonProperty("Quantity")
    var quantity: Long = 0
    @JsonProperty("TotalQuantity")
    var totalQuantity: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): EngineerContributionInfo =
            api.events.invokeEngineerContributionEvent(
                    injectJackson().readValue(json, EngineerContributionInfo::class.java)
            )
}