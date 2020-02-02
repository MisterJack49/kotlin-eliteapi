package fr.misterjack.kotlineliteapi.events


import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import fr.misterjack.kotlineliteapi.injectJackson
import java.util.Date

class ScanInfo : Event<ScanInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("ScanType")
    var scanType: String = ""
    @JsonProperty("BodyName")
    var bodyName: String = ""
    @JsonProperty("BodyID")
    var bodyId: Long = 0
    @JsonProperty("Parents")
    var parents: List<Parent> = listOf()
    @JsonProperty("DistanceFromArrivalLS")
    var distanceFromArrivalLs: Double = 0.0
    @JsonProperty("TidalLock")
    var tidalLock: Boolean = false
    @JsonProperty("TerraformState")
    var terraformState: String = ""
    @JsonProperty("PlanetClass")
    var planetClass: String = ""
    @JsonProperty("Atmosphere")
    var atmosphere: String = ""
    @JsonProperty("AtmosphereType")
    var atmosphereType: String = ""
    @JsonProperty("Volcanism")
    var volcanism: String = ""
    @JsonProperty("MassEM")
    var massEm: Double = 0.0
    @JsonProperty("Radius")
    var radius: Double = 0.0
    @JsonProperty("SurfaceGravity")
    var surfaceGravity: Double = 0.0
    @JsonProperty("SurfaceTemperature")
    var surfaceTemperature: Double = 0.0
    @JsonProperty("SurfacePressure")
    var surfacePressure: Double = 0.0
    @JsonProperty("Landable")
    var landable: Boolean = false
    @JsonProperty("Materials")
    var materials: List<Material> = listOf()
    @JsonProperty("Composition")
    var composition: Composition = Composition()
    @JsonProperty("SemiMajorAxis")
    var semiMajorAxis: Double = 0.0
    @JsonProperty("Eccentricity")
    var eccentricity: Double = 0.0
    @JsonProperty("OrbitalInclination")
    var orbitalInclination: Double = 0.0
    @JsonProperty("Periapsis")
    var periapsis: Double = 0.0
    @JsonProperty("OrbitalPeriod")
    var orbitalPeriod: Double = 0.0
    @JsonProperty("RotationPeriod")
    var rotationPeriod: Double = 0.0
    @JsonProperty("AxialTilt")
    var axialTilt: Double = 0.0
    @JsonProperty("Rings")
    var rings: List<Ring> = listOf()
    @JsonProperty("ReserveLevel")
    var reserveLevel: String = ""

    override fun process(json: String, api: EliteDangerousAPI): ScanInfo =
            api.events.invokeScanEvent(
                    injectJackson().readValue(json, ScanInfo::class.java)
            )
}

class Composition {
    @JsonProperty("Ice")
    var ice: Double = 0.0
    @JsonProperty("Rock")
    var rock: Double = 0.0
    @JsonProperty("Metal")
    var metal: Double = 0.0
}

class Material {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("Percent")
    var percent: Double = 0.0
}

class Parent {
    @JsonProperty("Null")
    var nil: Long = 0
}

class Ring {
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("RingClass")
    var ringClass: String = ""
    @JsonProperty("MassMT")
    var massMt: Double = 0.0
    @JsonProperty("InnerRad")
    var innerRad: Double = 0.0
    @JsonProperty("OuterRad")
    var outerRad: Double = 0.0
}