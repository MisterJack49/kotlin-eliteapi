package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class EngineerCraftInfo : Event<EngineerCraftInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Slot")
    var slot: String = ""
    @JsonProperty("Module")
    var module: String = ""
    @JsonProperty("ApplyExperimentalEffect")
    var applyExperimentalEffect: String = ""
    @JsonProperty("Ingredients")
    var ingredients: List<Ingredient> = listOf()
    @JsonProperty("Engineer")
    var engineer: String = ""
    @JsonProperty("EngineerID")
    var engineerId: Long = 0
    @JsonProperty("BlueprintID")
    var blueprintId: Long = 0
    @JsonProperty("BlueprintName")
    var blueprintName: String = ""
    @JsonProperty("Level")
    var level: Long = 0
    @JsonProperty("Quality")
    var quality: Double = 0.0
    @JsonProperty("ExperimentalEffect")
    var experimentalEffect: String = ""
    @JsonProperty("ExperimentalEffect_Localised")
    var experimentalEffectLocalised: String = ""
    @JsonProperty("Modifiers")
    var modifiers: List<Modifier> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): EngineerCraftInfo =
            api.events.invokeEngineerCraftEvent(
                    injectJackson().readValue(json, EngineerCraftInfo::class.java)
            )
}

class Ingredient {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Count")
    var count: Long = 0
}

class Modifier {
    @JsonProperty("Label")
    var label: String = ""
    @JsonProperty("Value")
    var value: Double = 0.0
    @JsonProperty("OriginalValue")
    var originalValue: Double = 0.0
    @JsonProperty("LessIsGood")
    var lessIsGood: Long = 0
}