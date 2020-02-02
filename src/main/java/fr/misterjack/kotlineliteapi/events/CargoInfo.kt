package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class CargoInfo : Event<CargoInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Vessel")
    var vessel: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("Inventory")
    var inventory: List<Inventory> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): CargoInfo =
            api.events.invokeCargoEvent(
                    injectJackson().readValue(json, CargoInfo::class.java)
            )
}

class Inventory {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localized")
    var nameLocalized: String = ""
    @JsonProperty("Count")
    var count: Long = 0
    @JsonProperty("Stolen")
    var stolen: Long = 0
}