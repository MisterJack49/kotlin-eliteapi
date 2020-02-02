package fr.misterjack.kotlineliteapi
import fr.misterjack.kotlineliteapi.events.DefaultEvent
import java.io.File

class JournalParser(private val api: EliteDangerousAPI) {

    val processedLogs = mutableListOf<String>()
    private var totalLines = 0

    fun processJournal(logFile: File, doNotTrigger: Boolean = true, printJson: Boolean = true, triggerOnLoad: Boolean = false) {

        if (triggerOnLoad) totalLines = logFile.readLines().count()

        var i = 0

        logFile.forEachLine {
            var eventName = ""
            if (processedLogs.contains(it)) return@forEachLine
            if (!doNotTrigger) {
                eventName = processJson(it, printJson)
            }
            processedLogs.add(it)
            if (!triggerOnLoad) return@forEachLine
            i++
            api.onLoad.invoke(eventName to i.toFloat() / totalLines)
        }

    }

    private fun processJson(json: String, printJson: Boolean): String {
        var eventName = ""
        try {
            val defaultEvent = injectJackson().readValue(json, DefaultEvent::class.java)

            eventName = defaultEvent.eventName
            if (printJson) {
                api.logger.info("Processing event '${defaultEvent.eventName}'.")
            } else {
                api.logger.info("Processing event '${defaultEvent.eventName}'.")
            }
        } catch (e: Exception) {
            api.logger.warning("Couldn't process '${eventName}' : ${e.message}")
        }

        try {

            val eventClass = Class.forName("events.${eventName}Info")
            val eventMethod = eventClass.getMethod("process", String::class.java, EliteDangerousAPI::class.java)
            val parsedEvent = eventMethod.invoke(eventClass.constructors.first().newInstance(), json, api)

        } catch (e: Exception) {
            api.logger.warning("Issue while processing event '$eventName': ${e.message}")
        }

        return eventName
    }
}