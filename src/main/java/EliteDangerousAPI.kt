import events.EventHandler
import kotlinx.event.event
import status.GameStatus
import java.io.File
import java.io.IOException
import java.util.logging.Logger


class EliteDangerousAPI {
    var isReady: Boolean = false
        private set

    val standardDirectory =
            File(System.getProperty("user.home") + "\\Saved Games\\Frontier Developments\\Elite Dangerous")

    var isRunning: Boolean = false

    var journalDirectory: File
        private set
    val skipCatchUp: Boolean
    var logger: Logger

    var status: GameStatus = GameStatus()
    var journalParser = JournalParser(this)

    val events = EventHandler()

    val onError = event<Pair<String, Exception>>()
    val onReady = event<Unit>()
    val onQuit = event<Unit>()
    val onLoad = event < Pair<String, Float>>()


    constructor() {
        journalDirectory = standardDirectory
        skipCatchUp = false
        logger = Logger.getLogger(EliteDangerousAPI::class.java.name)
    }

    constructor(skipCatchUp: Boolean) {
        journalDirectory = standardDirectory
        this.skipCatchUp = skipCatchUp
        logger = Logger.getLogger(EliteDangerousAPI::class.java.name)
    }

    constructor(journalDirectory: File, skipCatchUp: Boolean) {
        this.journalDirectory = journalDirectory
        this.skipCatchUp = skipCatchUp
        logger = Logger.getLogger(EliteDangerousAPI::class.java.name)
    }

    fun reset() { //Reset services.
//        try {
//            Events = EventHandler()
//        } catch (ex: Exception) {
//            Logger.Log(Severity.Warning, "Couldn't instantiate service 'Events'.", ex)
//        }
//        try {
//            Commander = CommanderStatus(this)
//        } catch (ex: Exception) {
//            Logger.Log(Severity.Warning, "Couldn't instantiate service 'Commander'.", ex)
//        }
//        try {
//            Location = LocationStatus(this)
//        } catch (ex: Exception) {
//            Logger.Log(Severity.Warning, "Couldn't instantiate service 'Location'.", ex)
//        }
//
//        try {
//            StatusWatcher = StatusWatcher(this)
//        } catch (ex: Exception) {
//            Logger.Log(Severity.Warning, "Couldn't instantiate service 'StatusWatcher'.", ex)
//        }
//        try {
//            CargoWatcher = CargoWatcher(this)
//        } catch (ex: Exception) {
//            Logger.Log(Severity.Warning, "Couldn't instantiate service 'CargoWatcher'.", ex)
//        }
        try {
            status = GameStatus.fromFile(File("${journalDirectory.absolutePath}\\Status.json"), this)
        } catch (ex: Exception) {
            logger.warning("Couldn't instantiate service 'Status'.")
        }
        try {
            journalParser = JournalParser(this)
        } catch (ex: Exception) {
            logger.warning("Couldn't instantiate service 'JournalParser'.")
        }
//        try {
//            MaterialWatcher = MaterialWatcher(this)
//        } catch (ex: Exception) {
//            Logger.Log(Severity.Warning, "Couldn't instantiate service 'MaterialWatcher'.", ex)
//        }
        journalParser.processedLogs.clear()
    }

    fun start() {
        logger.info("Starting EliteAPI.")
        logger.info("Kotlin EliteAPI by CMDR MisterJack.")

        logger.info("Checking journal directory.");
        if (!journalDirectory.exists()) {
            if (journalDirectory.path != standardDirectory.path) {
                logger.warning("${journalDirectory.name} does not exist.")
                logger.info("Trying standard journal directory instead.");
            }

            if (!standardDirectory.exists()) {
                onError.invoke(
                        Pair(
                                "The default journal directory does not exist on this machine. This error usually occurs when Elite: Dangerous hasn't been run on this machine yet.",
                                IOException("'${standardDirectory.absolutePath}' could not be found.")
                        )
                )
                return;
            }

            journalDirectory = standardDirectory;
        }

        logger.info("Journal directory set to '$journalDirectory'.");

        isRunning = true

        val journalFile: File

        try {
            logger.info("Searching for 'Journal.*.log' files.")
            journalFile = journalDirectory.listFiles()!!.asSequence()
                    .filter { it.name.startsWith("Journal.") }
                    .sortedByDescending { it.lastModified() }
                    .first()
            logger.info("Found '${journalFile}'.")
        } catch (ex: Exception) {
            isRunning = false
            onError.invoke(
                    Pair("Could not find Journal files in '$journalDirectory'.", ex)
            )
            return
        }

        //Check for the support JSON files.
        var foundStatus = false;

        try {
            //Status.json.
            foundStatus =
                    if (File(journalDirectory.absolutePath + "\\Status.json").exists()) {
                        logger.info("Found 'Status.json'."); true; } else {
                        logger.warning("Could not find 'Status.json' file."); false
                    }

            //Cargo.json.
            if (File(journalDirectory.absolutePath + "\\Cargo.json").exists()) {
                logger.info("Found 'Cargo.json'."); } else {
                logger.warning("Could not find 'Cargo.json' file.")
            }

            //Shipyard.json.
            logger.info(
                    if (File(journalDirectory.absolutePath + "\\Shipyard.json").exists())
                        "Found 'Shipyard.json'."
                    else "Could not find 'Shipyard.json' file."
            )

            //Outfitting.json.
            logger.info(
                    if (File(journalDirectory.absolutePath + "\\Outfitting.json").exists())
                        "Found 'Outfitting.json'."
                    else "Could not find 'Outfitting.json' file."
            )

            //Market.json.
            logger.info(
                    if (File(journalDirectory.absolutePath + "\\Market.json").exists())
                        "Found 'Market.json'."
                    else "Could not find 'Market.json' file."
            );

            //ModulesInfo.json.
            if (File(journalDirectory.absolutePath + "\\ModulesInfo.json").exists()) {
                logger.info("Found 'ModulesInfo.json'."); } else {
                logger.info("Could not find 'ModulesInfo.json' file.");
            }
        } catch (e: Exception) {
        }

        if (foundStatus) {
            logger.info("Found Journal and Status files."); } else {
            logger.severe("Could not find Status.json.")

            logger.info("Live updates, such as the landing gear & hardpoints, are not supported without access to 'Status.json'. The Status file is only created after the first run of Elite: Dangerous. If this is not the first time you're running Elite: Dangerous on this machine, change the journal directory.")
            logger.warning("A critical part of EliteAPI will be offline.")
            logger.info("Proceeding in 20 seconds ...")
            Thread.sleep(20000)
        }

        reset()

        //Check if Elite: Dangerous is running.
        if (!status.isRunning) {
            logger.warning("Elite: Dangerous is not in-game.")
        }

        //Process the journal file.
        if (!skipCatchUp) {
            logger.info("Catching up with past events from this session."); }
        journalParser.processJournal(journalFile, skipCatchUp, false, true);
        if (!skipCatchUp) {
            logger.info("Catchup on past events completed."); }

//        //Go async.
//        Task.Run(() =>
//        {
//            //Run for as long as we're running.
//            while (IsRunning)
//            {
//                //Select the last edited Journal file.
//                FileInfo newJournalFile = JournalDirectory.GetFiles("Journal.*").OrderByDescending(x => x.LastWriteTime).First();
//                if (journalFile.FullName != newJournalFile.FullName) { Logger.Log(Severity.Info, $"Switched to '{newJournalFile}'."); JournalParser.processedLogs.Clear(); }
//                journalFile = newJournalFile;
//
//                //Process the journal file.
//                JournalParser.ProcessJournal(journalFile, false);
//
//                //Wait half a second to avoid overusing the CPU.
//                Thread.Sleep(500);
//            }
//        });
//
//        s.Stop();
//
//        Logger.Log(Severity.Debug, $"Finished in {s.ElapsedMilliseconds}ms.");
//        IsReady = true;
//        OnReady?.Invoke(this, EventArgs.Empty);
    }
}