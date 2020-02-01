package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class SetUserShipNameInfo : Event<SetUserShipNameInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0
    @JsonProperty("UserShipName")
    var userShipName: String = ""
    @JsonProperty("UserShipId")
    var userShipId: String = ""

    override fun process(json: String, api: EliteDangerousAPI): SetUserShipNameInfo =
            api.events.invokeSetUserShipNameEvent(
                    injectJackson().readValue(json, SetUserShipNameInfo::class.java)
            )
}