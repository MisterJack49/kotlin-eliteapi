package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class CodexEntryInfo : Event<CodexEntryInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("EntryID")
    var entryId: Long = 0
    @JsonProperty("Name")
    var name: String = ""
    @JsonProperty("Name_Localised")
    var nameLocalised: String = ""
    @JsonProperty("SubCategory")
    var subCategory: String = ""
    @JsonProperty("SubCategory_Localised")
    var subCategoryLocalised: String = ""
    @JsonProperty("Category")
    var category: String = ""
    @JsonProperty("Category_Localised")
    var categoryLocalised: String = ""
    @JsonProperty("Region")
    var region: String = ""
    @JsonProperty("Region_Localised")
    var regionLocalised: String = ""
    @JsonProperty("System")
    var system: String = ""
    @JsonProperty("SystemAddress")
    var systemAddress: Long = 0
    @JsonProperty("IsNewEntry")
    var isNewEntry: Boolean = false
    @JsonProperty("VoucherAmount")
    var voucherAmount: Long = 0

    override fun process(json: String, api: EliteDangerousAPI): CodexEntryInfo =
            api.events.invokeCodexEntryEvent(
                    injectJackson().readValue(json, CodexEntryInfo::class.java)
            )
}