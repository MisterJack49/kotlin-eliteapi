package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson

import java.util.Date

class LoadoutInfo : Event<LoadoutInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Ship")
    var ship: String = ""
    @JsonProperty("ShipID")
    var shipId: Long = 0
    @JsonProperty("ShipName")
    var shipName: String = ""
    @JsonProperty("ShipIdent")
    var shipIdent: String = ""
    @JsonProperty("HullValue")
    var hullValue: Long = 0
    @JsonProperty("ModulesValue")
    var modulesValue: Long = 0
    @JsonProperty("HullHealth")
    var hullHealth: Double = 0.0
    @JsonProperty("Hot")
    var hot: Boolean = false
    @JsonProperty("Rebuy")
    var rebuy: Long = 0
    @JsonProperty("Modules")
    var modules: List<Module> = listOf()

    override fun process(json: String, api: EliteDangerousAPI): LoadoutInfo =
            api.events.invokeLoadoutEvent(
                    injectJackson().readValue(json, LoadoutInfo::class.java)
            )
}

class Module {
    @JsonProperty("Slot")
    var slot: String = ""
    @JsonProperty("Item")
    var item: String = ""
    @JsonProperty("On")
    var on: Boolean = false
    @JsonProperty("Priority")
    var priority: Long = 0
    @JsonProperty("AmmoInClip")
    var ammoInClip: Long = 0
    @JsonProperty("AmmoInHopper")
    var ammoInHopper: Long = 0
    @JsonProperty("Health")
    var health: Double = 0.0
    @JsonProperty("Value")
    var value: Long = 0
    @JsonProperty("Engineering")
    var engineering: Engineering = Engineering()
}

class Engineering {
    @JsonProperty("Engineer")
    var engineer: String = ""
    @ExperimentalUnsignedTypes
    @JsonProperty("EngineerID")
    var engineerId: ULong = 0u
    @ExperimentalUnsignedTypes
    @JsonProperty("BlueprintID")
    var blueprintId: ULong = 0u
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
    var modifiers: List<LoadOutModifier> = listOf()
}

class LoadOutModifier {
    @JsonProperty("Label")
    var label: String = ""
    @JsonProperty("Value")
    var value: Double = 0.0
    @JsonProperty("OriginalValue")
    var originalValue: Double = 0.0
    @JsonProperty("LessIsGood")
    var lessIsGood: Long = 0
}