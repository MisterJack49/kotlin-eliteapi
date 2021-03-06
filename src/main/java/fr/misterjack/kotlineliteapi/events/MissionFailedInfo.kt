package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class MissionFailedInfo : Event<MissionFailedInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("MissionID")
    var missionId: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): MissionFailedInfo =
            api.events.invokeMissionFailedEvent(
                    injectJackson().readValue(json, MissionFailedInfo::class.java)
            )
}