package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class ShipyardNewInfo : Event<ShipyardNewInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("ShipType")
    var shipType: String = ""
    @JsonProperty("ShipType_Localised")
    var shipTypeLocalised: String = ""
    @JsonProperty("NewShipID")
    var newShipId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): ShipyardNewInfo =
            api.events.invokeShipyardNewEvent(
                    injectJackson().readValue(json, ShipyardNewInfo::class.java)
            )
}