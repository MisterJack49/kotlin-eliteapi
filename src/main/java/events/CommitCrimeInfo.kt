package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CommitCrimeInfo : Event<CommitCrimeInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("CrimeType")
    var crimeType: String = ""
    @JsonProperty("Faction")
    var faction: String = ""
    @JsonProperty("Victim")
    var victim: String = ""
    @JsonProperty("Victim_Localised")
    var victimLocalised: String = ""
    @JsonProperty("Bounty")
    var bounty: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): CommitCrimeInfo =
            api.events.invokeCommitCrimeEvent(
                    injectJackson().readValue(json, CommitCrimeInfo::class.java)
            )
}