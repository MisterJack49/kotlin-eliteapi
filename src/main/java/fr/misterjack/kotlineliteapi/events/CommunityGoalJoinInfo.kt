package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class CommunityGoalJoinInfo : Event<CommunityGoalJoinInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("System")
    var system: String = ""

    override fun process(json: String, api: EliteDangerousAPI): CommunityGoalJoinInfo =
            api.events.invokeCommunityGoalJoinEvent(
                    injectJackson().readValue(json, CommunityGoalJoinInfo::class.java)
            )
}