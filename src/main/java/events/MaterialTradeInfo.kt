package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class MaterialTradeInfo : Event<MaterialTradeInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("TraderType")
    var traderType: String = ""
    @JsonProperty("Paid")
    var paid: Paid = Paid()
    @JsonProperty("Received")
    var received: Paid = Paid()

    override fun process(json: String, api: EliteDangerousAPI): MaterialTradeInfo =
            api.events.invokeMaterialTradeEvent(
                    injectJackson().readValue(json, MaterialTradeInfo::class.java)
            )
}

class Paid {
    @JsonProperty("Material")
    var material: String = ""
    @JsonProperty("Material_Localised")
    var materialLocalised: String = ""
    @JsonProperty("Category")
    var category: String = ""
    @JsonProperty("Category_Localised")
    var categoryLocalised: String = ""
    @JsonProperty("Quantity")
    var quantity: Long = 0
}