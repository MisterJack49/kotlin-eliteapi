package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class EngineerApplyInfo : Event<EngineerApplyInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Engineer")
    var engineer: String = ""
    @JsonProperty("Blueprint")
    var blueprint: String = ""
    @JsonProperty("Level")
    var level: Long = 0
    @JsonProperty("Override")
    var override: String = ""

    override fun process(json: String, api: EliteDangerousAPI): EngineerApplyInfo =
            api.events.invokeEngineerApplyEvent(
                    injectJackson().readValue(json, EngineerApplyInfo::class.java)
            )
}