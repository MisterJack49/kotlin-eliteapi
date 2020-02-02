package fr.misterjack.kotlineliteapi.status

import fr.misterjack.kotlineliteapi.EliteDangerousAPI
import dev.vishna.watchservice.KWatchChannel
import dev.vishna.watchservice.asWatchChannel
import fr.misterjack.kotlineliteapi.events.EventHandler
import fr.misterjack.kotlineliteapi.events.FSDJumpInfo
import fr.misterjack.kotlineliteapi.events.LoadGameInfo
import fr.misterjack.kotlineliteapi.events.MusicInfo
import fr.misterjack.kotlineliteapi.events.ReceiveTextInfo
import fr.misterjack.kotlineliteapi.events.StartJumpInfo
import fr.misterjack.kotlineliteapi.events.StatusEvent
import fr.misterjack.kotlineliteapi.events.SupercruiseEntryInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import org.javers.core.JaversBuilder
import org.javers.core.diff.changetype.ValueChange
import java.io.File


class StatusWatcher(private val api: EliteDangerousAPI) {
    private var inNoFireZone: Boolean = false
    private var jumpRange = -1.0
    private var maxFuel = -1.0
    private var gameMode: String = ""
    private var inMainMenu: Boolean = false
    private var musicTrack: String = ""
    private val statusFile: File = File("${api.journalDirectory}/Status.json")

    init {
        api.events.receiveTextEvent += { e -> events_ReceiveTextEvent(e) }
        api.events.fSDJumpEvent += { e -> events_FSDJumpEvent(e) }
        api.events.loadGameEvent += { e -> events_LoadGameEvent(e) }
        api.events.musicEvent += { e -> events_MusicEvent(e) }
        api.events.supercruiseEntryEvent += { e -> events_SupercruiseEntryEvent(e) }
        api.events.startJumpEvent += { e -> events_StartJumpEvent(e) }

        val watcher = statusFile.asWatchChannel(KWatchChannel.Mode.SingleFile)
        GlobalScope.launch {
            watcher.consumeEach {
                update()
            }
        }
        update()
    }

    fun events_StartJumpEvent(e: StartJumpInfo) {
        inNoFireZone = false;
        update();
    }

    fun events_SupercruiseEntryEvent(e: SupercruiseEntryInfo) {
        inNoFireZone = false;
        update();
    }

    fun events_MusicEvent(e: MusicInfo) {
        musicTrack = e.musicTrack;
        inMainMenu = e.musicTrack == "MainMenu";
        update();
    }

    fun events_LoadGameEvent(e: LoadGameInfo) {
        maxFuel = e.fuelCapacity;
        gameMode = e.gameMode;
        update();
    }

    fun events_FSDJumpEvent(e: FSDJumpInfo) {
        inNoFireZone = false;
        if (jumpRange < e.jumpDist) {
            jumpRange = e.jumpDist; }
        update();
    }

    fun events_ReceiveTextEvent(e: ReceiveTextInfo) {
        if (e.message.contains("NoFireZone_entered")) {
            inNoFireZone = true; } else if (e.message.contains("NoFireZone_exited")) {
            inNoFireZone = false; }
        update();
    }

    fun update() {
        //Save the old status.
        val oldStatus = api.status
        val newStatus = GameStatus.fromFile(statusFile, api);
        if (!statusFile.exists()) {
            return; }
        newStatus.inNoFireZone = inNoFireZone;
        newStatus.jumpRange = jumpRange;
        newStatus.fuel?.maxFuel = maxFuel;
        newStatus.gameMode = gameMode;
        newStatus.inMainMenu = inMainMenu;
        newStatus.musicTrack = musicTrack;
        if (newStatus.docked) {
            newStatus.inNoFireZone = true; }
        //Set the new status.
        api.status = newStatus;
        triggerIfDifferent(oldStatus, newStatus);
    }

    fun triggerIfDifferent(oldStatus: GameStatus, newStatus: GameStatus) {
        val javers = JaversBuilder.javers().build()

        javers.compare(oldStatus, newStatus)
                .changes
                .filterIsInstance<ValueChange>()
                .forEach {
                    val e = StatusEvent("Status.${it.propertyName}", it.right.toString())
                    api.logger.info("Setting status '${it.propertyName}' to ${it.right}.")
                    try {
                        val eventMethod = EventHandler::class.java.getMethod("invokeStatus${it.propertyName.capitalize()}", StatusEvent::class.java)
                        eventMethod.invoke(api.events, e)
                    } catch (ex: Exception) {
                        api.logger.info("Could not invoke status event '${it.propertyName}' (invokeStatus${it.propertyName.capitalize()}).")
                    }
                }
    }
}