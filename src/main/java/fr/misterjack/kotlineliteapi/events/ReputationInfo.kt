package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ReputationInfo : Event<ReputationInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Empire")
    var empire: Double = 0.0
    @JsonProperty("Federation")
    var federation: Double = 0.0
    @JsonProperty("Independent")
    var independent: Double = 0.0
    @JsonProperty("Alliance")
    var alliance: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): ReputationInfo =
            api.events.invokeReputationEvent(
                    injectJackson().readValue(json, ReputationInfo::class.java)
            )
}

