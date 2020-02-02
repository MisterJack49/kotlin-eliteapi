package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class DiedInfo : Event<DiedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("KillerName")
    var killerName: String = ""
    @JsonProperty("KillerName_Localised")
    var killerNameLocalised: String = ""
    @JsonProperty("KillerShip")
    var killerShip: String = ""
    @JsonProperty("KillerRank")
    var killerRank: String = ""

    override fun process(json: String, api: EliteDangerousAPI): DiedInfo =
            api.events.invokeDiedEvent(
                    injectJackson().readValue(json, DiedInfo::class.java)
            )
}