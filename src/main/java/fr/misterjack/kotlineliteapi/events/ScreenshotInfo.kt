package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ScreenshotInfo : Event<ScreenshotInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Filename")
    var filename: String = ""
    @JsonProperty("Width")
    var width: Long = 0
    @JsonProperty("Height")
    var height: Long = 0
    @JsonProperty("System")
    var system: String = ""
    @JsonProperty("Body")
    var body: String = ""
    @JsonProperty("Latitude")
    var latitude: Double = 0.0
    @JsonProperty("Longitude")
    var longitude: Double = 0.0
    @JsonProperty("Heading")
    var heading: Long = 0
    @JsonProperty("Altitude")
    var altitude: Double = 0.0

    override fun process(json: String, api: EliteDangerousAPI): ScreenshotInfo =
            api.events.invokeScreenshotEvent(
                    injectJackson().readValue(json, ScreenshotInfo::class.java)
            )
}