package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class LoadGameInfo : Event<LoadGameInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("FID")
    var fid: String = ""
    @JsonProperty("Commander")
    var commander: String = ""
    @JsonProperty("Horizons")
    var horizons: Boolean = false
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("Ship_Localised")
    var shipLocalised: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0
    @JsonProperty("ShipName")
    var shipName: String = ""
    @JsonProperty("ShipIdent")
    var shipIdent: String = ""
    @JsonProperty("FuelLevel")
    var fuelLevel: Double = 0.0
    @JsonProperty("FuelCapacity")
    var fuelCapacity: Double = 0.0
    @JsonProperty("GameMode")
    var gameMode: String = ""
    @JsonProperty("Group")
    var group: String = ""
    @JsonProperty("Credits")
    var credits: Long = 0
    @JsonProperty("Loan")
    var loan: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): LoadGameInfo =
            api.events.invokeLoadGameEvent(
                    injectJackson().readValue(json, LoadGameInfo::class.java)
            )
}