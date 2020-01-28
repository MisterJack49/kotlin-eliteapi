package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CrimeVictimInfo : Event<CrimeVictimInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Offender")
    var offender: String = ""
    @JsonProperty("CrimeType")
    var crimeType: String = ""
    @JsonProperty("Bounty")
    var bounty: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): CrimeVictimInfo =
            api.events.invokeCrimeVictimEvent(
                    injectJackson().readValue(json, CrimeVictimInfo::class.java)
            )
}