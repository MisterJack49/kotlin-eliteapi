package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PowerplayVoteInfo : Event<PowerplayVoteInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Power")
    var power: String = ""
    @JsonProperty("Votes")
    var votes: Long = 0
    @JsonProperty("VoteToConsolidate")
    var voteToConsolidate: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): PowerplayVoteInfo =
            api.events.invokePowerplayVoteEvent(
                    injectJackson().readValue(json, PowerplayVoteInfo::class.java)
            )
}