package status


enum class ShipStatusFlags (val flag: Int) {
    None(0),
    Docked(1),
    Landed  (1 shl 1),
    Gear ( 1 shl 2),
    Shields ( 1 shl 3),
    Supercruise ( 1 shl 4),
    FlightAssistOff ( 1 shl 5),
    Hardpoints ( 1 shl 6),
    Winging ( 1 shl 7),
    Lights ( 1 shl 8),
    CargoScoop ( 1 shl 9),
    SilentRunning ( 1 shl 10),
    Scooping ( 1 shl 11),
    SrvHandbreak ( 1 shl 12),
    SrvTurret ( 1 shl 13),
    SrvNearShip ( 1 shl 14),
    SrvDriveAssist ( 1 shl 15),
    MassLocked ( 1 shl 16),
    FsdCharging ( 1 shl 17),
    FsdCooldown ( 1 shl 18),
    LowFuel ( 1 shl 19),
    Overheating ( 1 shl 20),
    HasLatlong ( 1 shl 21),
    InDanger ( 1 shl 22),
    InInterdiction ( 1 shl 23),
    InMothership ( 1 shl 24),
    InFighter ( 1 shl 25),
    InSrv ( 1 shl 26),
    AnalysisMode ( 1 shl 27),
    NightVision ( 1 shl 28);
}

