package events


import EliteDangerousAPI
import com.fasterxml.jackson.annotation.JsonProperty
import injectJackson
import java.util.Date

class StatisticsInfo : Event<StatisticsInfo> {

    @JsonProperty
    override lateinit var timestamp: Date
    @JsonProperty("event")
    override lateinit var eventName: String
    @JsonProperty("Bank_Account")
    var bankAccount: Map<String, Long> = mapOf()
    @JsonProperty("Combat")
    var combat: Combat = Combat()
    @JsonProperty("Crime")
    var crime: Crime = Crime()
    @JsonProperty("Smuggling")
    var smuggling: Smuggling = Smuggling()
    @JsonProperty("Trading")
    var trading: Trading = Trading()
    @JsonProperty("Mining")
    var mining: Mining = Mining()
    @JsonProperty("Exploration")
    var exploration: Map<String, Double> = mapOf()
    @JsonProperty("Passengers")
    var passengers: Passengers = Passengers()
    @JsonProperty("Search_And_Rescue")
    var searchAndRescue: SearchAndRescue = SearchAndRescue()
    @JsonProperty("TG_ENCOUNTERS")
    var tgEncounters: TgEncounters = TgEncounters()
    @JsonProperty("Crafting")
    var crafting: Crafting = Crafting()
    @JsonProperty("Crew")
    var crew: Crew = Crew()
    @JsonProperty("Multicrew")
    var multicrew: Multicrew = Multicrew()
    @JsonProperty("Material_Trader_Stats")
    var materialTraderStats: MaterialTraderStats = MaterialTraderStats()
    @JsonProperty("CQC")
    var cqc: Map<String, Double> = mapOf()

    override fun process(json: String, api: EliteDangerousAPI): StatisticsInfo =
            api.events.invokeStatisticsEvent(
                    injectJackson().readValue(json, StatisticsInfo::class.java)
            )
}

class Combat {
    @JsonProperty("Bounties_Claimed")
    var bountiesClaimed: Long = 0
    @JsonProperty("Bounty_Hunting_Profit")
    var bountyHuntingProfit: Double = 0.0
    @JsonProperty("Combat_Bonds")
    var combatBonds: Long = 0
    @JsonProperty("Combat_Bond_Profits")
    var combatBondProfits: Long = 0
    @JsonProperty("Assassinations")
    var assassinations: Long = 0
    @JsonProperty("Assassination_Profits")
    var assassinationProfits: Long = 0
    @JsonProperty("Highest_Single_Reward")
    var highestSingleReward: Long = 0
    @JsonProperty("Skimmers_Killed")
    var skimmersKilled: Long = 0
}

class Crafting {
    @JsonProperty("Count_Of_Used_Engineers")
    var countOfUsedEngineers: Long = 0
    @JsonProperty("Recipes_Generated")
    var recipesGenerated: Long = 0
    @JsonProperty("Recipes_Generated_Rank_1")
    var recipesGeneratedRank1: Long = 0
    @JsonProperty("Recipes_Generated_Rank_2")
    var recipesGeneratedRank2: Long = 0
    @JsonProperty("Recipes_Generated_Rank_3")
    var recipesGeneratedRank3: Long = 0
    @JsonProperty("Recipes_Generated_Rank_4")
    var recipesGeneratedRank4: Long = 0
    @JsonProperty("Recipes_Generated_Rank_5")
    var recipesGeneratedRank5: Long = 0
}

class Crew {
    @JsonProperty("NpcCrew_TotalWages")
    var npcCrewTotalWages: Long = 0
    @JsonProperty("NpcCrew_Hired")
    var npcCrewHired: Long = 0
    @JsonProperty("NpcCrew_Fired")
    var npcCrewFired: Long = 0
    @JsonProperty("NpcCrew_Died")
    var npcCrewDied: Long = 0
}

class Crime {
    @JsonProperty("Notoriety")
    var notoriety: Long = 0
    @JsonProperty("Fines")
    var fines: Long = 0
    @JsonProperty("Total_Fines")
    var totalFines: Long = 0
    @JsonProperty("Bounties_Received")
    var bountiesReceived: Long = 0
    @JsonProperty("Total_Bounties")
    var totalBounties: Long = 0
    @JsonProperty("Highest_Bounty")
    var highestBounty: Long = 0
}

class MaterialTraderStats {
    @JsonProperty("Trades_Completed")
    var tradesCompleted: Long = 0
    @JsonProperty("Materials_Traded")
    var materialsTraded: Long = 0
    @JsonProperty("Encoded_Materials_Traded")
    var encodedMaterialsTraded: Long = 0
    @JsonProperty("Raw_Materials_Traded")
    var rawMaterialsTraded: Long = 0
    @JsonProperty("Grade_1_Materials_Traded")
    var grade1_MaterialsTraded: Long = 0
    @JsonProperty("Grade_2_Materials_Traded")
    var grade2_MaterialsTraded: Long = 0
    @JsonProperty("Grade_3_Materials_Traded")
    var grade3_MaterialsTraded: Long = 0
    @JsonProperty("Grade_4_Materials_Traded")
    var grade4_MaterialsTraded: Long = 0
    @JsonProperty("Grade_5_Materials_Traded")
    var grade5_MaterialsTraded: Long = 0
}

class Mining {
    @JsonProperty("Mining_Profits")
    var miningProfits: Long = 0
    @JsonProperty("Quantity_Mined")
    var quantityMined: Long = 0
    @JsonProperty("Materials_Collected")
    var materialsCollected: Long = 0
}

class Multicrew {
    @JsonProperty("Multicrew_Time_Total")
    var multicrewTimeTotal: Long = 0
    @JsonProperty("Multicrew_Gunner_Time_Total")
    var multicrewGunnerTimeTotal: Long = 0
    @JsonProperty("Multicrew_Fighter_Time_Total")
    var multicrewFighterTimeTotal: Long = 0
    @JsonProperty("Multicrew_Credits_Total")
    var multicrewCreditsTotal: Long = 0
    @JsonProperty("Multicrew_Fines_Total")
    var multicrewFinesTotal: Long = 0
}

class Passengers {
    @JsonProperty("Passengers_Missions_Accepted")
    var passengersMissionsAccepted: Long = 0
    @JsonProperty("Passengers_Missions_Disgruntled")
    var passengersMissionsDisgruntled: Long = 0
    @JsonProperty("Passengers_Missions_Bulk")
    var passengersMissionsBulk: Long = 0
    @JsonProperty("Passengers_Missions_VIP")
    var passengersMissionsVip: Long = 0
    @JsonProperty("Passengers_Missions_Delivered")
    var passengersMissionsDelivered: Long = 0
    @JsonProperty("Passengers_Missions_Ejected")
    var passengersMissionsEjected: Long = 0
}

class SearchAndRescue {
    @JsonProperty("SearchRescue_Traded")
    var searchRescueTraded: Long = 0
    @JsonProperty("SearchRescue_Profit")
    var searchRescueProfit: Long = 0
    @JsonProperty("SearchRescue_Count")
    var searchRescueCount: Long = 0
}

class Smuggling {
    @JsonProperty("Black_Markets_Traded_With")
    var blackMarketsTradedWith: Long = 0
    @JsonProperty("Black_Markets_Profits")
    var blackMarketsProfits: Long = 0
    @JsonProperty("Resources_Smuggled")
    var resourcesSmuggled: Long = 0
    @JsonProperty("Average_Profit")
    var averageProfit: Double = 0.0
    @JsonProperty("Highest_Single_Transaction")
    var highestSingleTransaction: Long = 0
}

class TgEncounters {
    @JsonProperty("TG_ENCOUNTER_TOTAL")
    var tgEncounterTotal: Long = 0
    @JsonProperty("TG_ENCOUNTER_TOTAL_LAST_SYSTEM")
    var tgEncounterTotalLastSystem: String = ""
    @JsonProperty("TG_ENCOUNTER_TOTAL_LAST_TIMESTAMP")
    var tgEncounterTotalLastTimestamp: String = ""
    @JsonProperty("TG_ENCOUNTER_TOTAL_LAST_SHIP")
    var tgEncounterTotalLastShip: String = ""
    @JsonProperty("TG_SCOUT_COUNT")
    var tgScoutCount: Long = 0
}

class Trading {
    @JsonProperty("Markets_Traded_With")
    var marketsTradedWith: Long = 0
    @JsonProperty("Market_Profits")
    var marketProfits: Long = 0
    @JsonProperty("Resources_Traded")
    var resourcesTraded: Long = 0
    @JsonProperty("Average_Profit")
    var averageProfit: Double = 0.0
    @JsonProperty("Highest_Single_Transaction")
    var highestSingleTransaction: Long = 0
}