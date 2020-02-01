package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class DockedInfo : Event<DockedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("StationName")
    var stationName: String = ""
    @JsonProperty("StationType")
    var stationType: String = ""
    @JsonProperty("StarSystem")
    var starSystem: String = ""
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("MarketID")
    var marketId: Long = 0
    @JsonProperty("StationFaction")
    var stationFaction: StationFaction = StationFaction()
    @JsonProperty("StationGovernment")
    var stationGovernment: String = ""
    @JsonProperty("StationGovernment_Localised")
    var stationGovernmentLocalised: String = ""
    @JsonProperty("StationAllegiance")
    var stationAllegiance: String = ""
    @JsonProperty("StationServices")
    var stationServices: List<String> = listOf()
    @JsonProperty("StationEconomy")
    var stationEconomy: String = ""
    @JsonProperty("StationEconomy_Localised")
    var stationEconomyLocalised: String = ""
    @JsonProperty("StationEconomies")
    var stationEconomies: List<StationEconomy> = listOf()
    @JsonProperty("DistFromStarLS")
    var distFromStarLs: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): DockedInfo =
            api.events.invokeDockedEvent(
                    injectJackson().readValue(json, DockedInfo::class.java)
            )
}

class StationEconomy {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Proportion")
    var proportion: Double = 0.0
}

class StationFaction {
    @JsonProperty("Name")
    var name: String = ""
}