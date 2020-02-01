package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class FriendsInfo : Event<FriendsInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Status")
    var status: String = ""
    @JsonProperty("Name")
    var name: String = ""

    override fun process(json: String, api: EliteDangerousAPI): FriendsInfo =
            api.events.invokeFriendsEvent(
                    injectJackson().readValue(json, FriendsInfo::class.java)
            )
}