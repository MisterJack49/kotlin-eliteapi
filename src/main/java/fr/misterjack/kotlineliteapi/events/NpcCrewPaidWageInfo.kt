package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class NpcCrewPaidWageInfo : Event<NpcCrewPaidWageInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("NpcCrewName")
    var npcCrewName: String = ""
    @JsonProperty("NpcCrewId")
    var npcCrewId: Long = 0
    @JsonProperty("Amount")
    var amount: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): NpcCrewPaidWageInfo =
            api.events.invokeNpcCrewPaidWageEvent(
                    injectJackson().readValue(json, NpcCrewPaidWageInfo::class.java)
            )
}