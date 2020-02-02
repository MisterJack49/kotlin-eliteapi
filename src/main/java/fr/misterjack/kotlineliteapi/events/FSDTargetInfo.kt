package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class FSDTargetInfo : Event<FSDTargetInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("RemainingJumpsInRoute")
    var remainingJumpsInRoute: Int = 0

    override fun process(json: String, api: EliteDangerousAPI): FSDTargetInfo =
            api.events.invokeFSDTargetEvent(
                    injectJackson().readValue(json, FSDTargetInfo::class.java)
            )
}