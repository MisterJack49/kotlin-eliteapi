package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class CommanderInfo : Event<CommanderInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("FID")
    var fid: String = ""
    @JsonProperty("Name")
    var name: String = ""

    override fun process(json: String, api: EliteDangerousAPI): CommanderInfo =
            api.events.invokeCommanderEvent(
                    injectJackson().readValue(json, CommanderInfo::class.java)
            )
}