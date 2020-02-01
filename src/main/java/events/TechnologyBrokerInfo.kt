package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class TechnologyBrokerInfo : Event<TechnologyBrokerInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("BrokerType")
    var brokerType: String = ""
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("ItemsUnlocked")
    var itemsUnlocked: List<ItemsUnlocked> = listOf()
    @JsonProperty("Commodities")
    var commodities: List<Commodity> = listOf()
    @JsonProperty("Materials")
    var materials: List<Commodity> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): TechnologyBrokerInfo =
            api.events.invokeTechnologyBrokerEvent(
                    injectJackson().readValue(json, TechnologyBrokerInfo::class.java)
            )
}

class Commodity {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("Category")
    var category: String = ""
}

class ItemsUnlocked {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
}