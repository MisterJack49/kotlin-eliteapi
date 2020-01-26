package status

import com.fasterxml.jackson.annotation.JsonProperty

class Fuel {
    @JsonProperty("FuelMain")
    val fuelMain: Double = 0.0
    @JsonProperty("FuelReservoir")
    val fuelReservoir: Double= 0.0
    var maxFuel: Double? = null
}