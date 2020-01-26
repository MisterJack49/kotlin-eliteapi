package status

import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File
import java.util.Date
import java.util.EnumSet

class GameStatus(
    val timestamp: Date,
    val event: String,
    @JsonProperty("Flags")
    private var bitFlag: Int
) {
    constructor() : this(Date(), "Status", 0)

    @JsonProperty("Pips")
    var pips: List<Long>? = null
    @JsonProperty("FireGroup")
    val fireGroup: Long? = null
    @JsonProperty("GuiFocus")
    val guiFocus: Long? = null
    @JsonProperty("Fuel")
    var fuel: Fuel? = null
    @JsonProperty("LegalState")
    val legalState: String? = null
    @JsonProperty("Cargo")
    val cargo: Long? = null

    @JsonIgnore
    val flags: EnumSet<ShipStatusFlags> = EnumSet.noneOf(ShipStatusFlags::class.java)

    @JsonIgnore
    val docked: Boolean = getFlag(ShipStatusFlags.Docked)

    @JsonIgnore
    val landed: Boolean = getFlag(ShipStatusFlags.Landed)

    @JsonIgnore
    val gear: Boolean = getFlag(ShipStatusFlags.Gear)

    @JsonIgnore
    val shields: Boolean = getFlag(ShipStatusFlags.Shields)

    @JsonIgnore
    val supercruise: Boolean = getFlag(ShipStatusFlags.Supercruise)

    @JsonIgnore
    val flightAssist: Boolean = !getFlag(ShipStatusFlags.FlightAssistOff)

    @JsonIgnore
    val hardpoints: Boolean = getFlag(ShipStatusFlags.Hardpoints)

    @JsonIgnore
    val winging: Boolean = getFlag(ShipStatusFlags.Winging)

    @JsonIgnore
    val lights: Boolean = getFlag(ShipStatusFlags.Lights)

    @JsonIgnore
    val cargoScoop: Boolean = getFlag(ShipStatusFlags.CargoScoop)

    @JsonIgnore
    val silentRunning: Boolean = getFlag(ShipStatusFlags.SilentRunning)

    @JsonIgnore
    val scooping: Boolean = getFlag(ShipStatusFlags.Scooping)

    @JsonIgnore
    val srvHandbreak: Boolean = getFlag(ShipStatusFlags.SrvHandbreak)

    @JsonIgnore
    val srvTurrent: Boolean = getFlag(ShipStatusFlags.SrvTurret)

    @JsonIgnore
    val srvNearShip: Boolean = getFlag(ShipStatusFlags.SrvNearShip)

    @JsonIgnore
    val srvDriveAssist: Boolean = getFlag(ShipStatusFlags.SrvDriveAssist)

    @JsonIgnore
    val massLocked: Boolean = getFlag(ShipStatusFlags.MassLocked)

    @JsonIgnore
    val fsdCharging: Boolean = getFlag(ShipStatusFlags.FsdCharging)

    @JsonIgnore
    val fsdCooldown: Boolean = getFlag(ShipStatusFlags.FsdCooldown)

    @JsonIgnore
    val lowFuel: Boolean = getFlag(ShipStatusFlags.LowFuel)

    @JsonIgnore
    val overheating: Boolean = getFlag(ShipStatusFlags.Overheating)

    @JsonIgnore
    val hasLatlong: Boolean = getFlag(ShipStatusFlags.HasLatlong)

    @JsonIgnore
    val inDanger: Boolean = getFlag(ShipStatusFlags.InDanger)

    @JsonIgnore
    val inInterdiction: Boolean = getFlag(ShipStatusFlags.InInterdiction)

    @JsonIgnore
    val inMothership: Boolean = getFlag(ShipStatusFlags.InMothership)

    @JsonIgnore
    val inFighter: Boolean = getFlag(ShipStatusFlags.InFighter)

    @JsonIgnore
    val inSRV: Boolean = getFlag(ShipStatusFlags.InSrv)

    @JsonIgnore
    val analysisMode: Boolean = getFlag(ShipStatusFlags.AnalysisMode)

    @JsonIgnore
    val nightVision: Boolean = getFlag(ShipStatusFlags.NightVision)

    @JsonIgnore
    lateinit var gameMode: String

    @JsonIgnore
    var InNoFireZone: Boolean? = null

    @JsonIgnore
    var jumpRange: Double? = null

    @JsonIgnore
    val isRunning = !flags.contains(ShipStatusFlags.None)

    @JsonIgnore
    var inMainMenu: Boolean? = null

    @JsonIgnore
    var musicTrack: Boolean? = null

    private fun getFlag(flag: ShipStatusFlags): Boolean = flags.contains(flag)

    init {
        if (bitFlag == 0)
            flags.add(ShipStatusFlags.None)
        else
            ShipStatusFlags.values().forEach {
                if ((bitFlag and it.flag) > 0) {
                    flags.add(it)
                }
            }
    }

    companion object {
        fun process(json: String): GameStatus = jacksonObjectMapper().readValue(json, GameStatus::class.java)
        fun fromFile(file: File, api: EliteDangerousAPI): GameStatus {
            if (!file.exists()) return GameStatus()

            try {
                val gs = process(file.readText())
                if (gs.fuel == null) gs.fuel = Fuel()
                if (gs.pips == null) gs.pips = listOf(0, 0, 0)
                return gs
            } catch (e: Exception) {
                api.logger.warning("Could not update Status.json.");
            }
            return api.status
        }
    }

}