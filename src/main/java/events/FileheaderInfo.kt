package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class FileheaderInfo : Event<FileheaderInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("part")
    var part: Long = 0
    @JsonProperty("language")
    var language: String = ""
    @JsonProperty("gameversion")
    var gameversion: String = ""
    @JsonProperty("build")
    var build: String = ""

    override fun process(json: String, api: EliteDangerousAPI): FileheaderInfo =
            api.events.invokeFileheaderEvent(
                    injectJackson().readValue(json, FileheaderInfo::class.java)
            )
}