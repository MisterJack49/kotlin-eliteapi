package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class MusicInfo : Event<MusicInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("MusicTrack")
    var musicTrack: String = ""

    override fun process(json: String, api: EliteDangerousAPI): MusicInfo =
            api.events.invokeMusicEvent(
                    injectJackson().readValue(json, MusicInfo::class.java)
            )
}