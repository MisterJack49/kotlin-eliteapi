package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class PromotionInfo : Event<PromotionInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Federation")
    var federation :Long = 0

    override fun process(json: String, api: EliteDangerousAPI): PromotionInfo =
            api.events.invokePromotionEvent(
                    injectJackson().readValue(json, PromotionInfo::class.java)
            )
}