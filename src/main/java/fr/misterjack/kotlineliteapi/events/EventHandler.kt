package fr.misterjack.kotlineliteapi.events

import kotlinx.event.event
import kotlin.reflect.KClass

class EventHandler {

    val eventMap = mapOf<KClass<*>, (Any) -> Any>(
            StatusEvent::class to { e: Any -> invokeStatusInMainMenu(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusIsRunning(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusInNoFireZone(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusDocked(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusLanded(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusFsdCooldown(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusGear(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusShields(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusSupercruise(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusFlightAssist(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusHardpoints(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusWinging(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusLights(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusCargoScoop(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusSilentRunning(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusScooping(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusSrvHandbreak(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusSrvTurrent(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusSrvNearShip(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusSrvDriveAssist(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusMassLocked(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusFsdCharging(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusFsdCooldow(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusLowFuel(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusOverheating(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusHasLatLong(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusInDanger(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusInInterdiction(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusInMothership(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusInFighter(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusInSRV(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusAnalysisMode(e as StatusEvent) },
            StatusEvent::class to { e: Any -> invokeStatusNightVision(e as StatusEvent) },
            ReservoirReplenishedInfo::class to { e: Any -> invokeReservoirReplenishedEvent(e as ReservoirReplenishedInfo) },
            ProspectedAsteroidInfo::class to { e: Any -> invokeProspectedAsteroidEvent(e as ProspectedAsteroidInfo) },
            LeftSquadronInfo::class to { e: Any -> invokeLeftSquadronEvent(e as LeftSquadronInfo) },
            HeatWarningInfo::class to { e: Any -> invokeHeatWarningEvent(e as HeatWarningInfo) },
            ShieldStateInfo::class to { e: Any -> invokeShieldStateEvent(e as ShieldStateInfo) },
            VehicleSwitchInfo::class to { e: Any -> invokeVehicleSwitchEvent(e as VehicleSwitchInfo) },
            DockFighterInfo::class to { e: Any -> invokeDockFighterEvent(e as DockFighterInfo) },
            LaunchSRVInfo::class to { e: Any -> invokeLaunchSRVEvent(e as LaunchSRVInfo) },
            SelfDestructInfo::class to { e: Any -> invokeSelfDestructEvent(e as SelfDestructInfo) },
            DockSRVInfo::class to { e: Any -> invokeDockSRVEvent(e as DockSRVInfo) },
            HeatDamageInfo::class to { e: Any -> invokeHeatDamageEvent(e as HeatDamageInfo) },
            LaunchFighterInfo::class to { e: Any -> invokeLaunchFighterEvent(e as LaunchFighterInfo) },
            DatalinkScanInfo::class to { e: Any -> invokeDatalinkScanEvent(e as DatalinkScanInfo) },
            CockpitBreachedInfo::class to { e: Any -> invokeCockpitBreachedEvent(e as CockpitBreachedInfo) },
            JetConeBoostInfo::class to { e: Any -> invokeJetConeBoostEvent(e as JetConeBoostInfo) },
            PowerplayLeaveInfo::class to { e: Any -> invokePowerplayLeaveEvent(e as PowerplayLeaveInfo) },
            InterdictionInfo::class to { e: Any -> invokeInterdictionEvent(e as InterdictionInfo) },
            USSDropInfo::class to { e: Any -> invokeUSSDropEvent(e as USSDropInfo) },
            PowerplayCollectInfo::class to { e: Any -> invokePowerplayCollectEvent(e as PowerplayCollectInfo) },
            PowerplayDeliverInfo::class to { e: Any -> invokePowerplayDeliverEvent(e as PowerplayDeliverInfo) },
            PayLegacyFinesInfo::class to { e: Any -> invokePayLegacyFinesEvent(e as PayLegacyFinesInfo) },
            EngineerApplyInfo::class to { e: Any -> invokeEngineerApplyEvent(e as EngineerApplyInfo) },
            WingLeaveInfo::class to { e: Any -> invokeWingLeaveEvent(e as WingLeaveInfo) },
            SystemsShutdownInfo::class to { e: Any -> invokeSystemsShutdownEvent(e as SystemsShutdownInfo) },
            HullDamageInfo::class to { e: Any -> invokeHullDamageEvent(e as HullDamageInfo) },
            BuyDronesInfo::class to { e: Any -> invokeBuyDronesEvent(e as BuyDronesInfo) },
            RestockVehicleInfo::class to { e: Any -> invokeRestockVehicleEvent(e as RestockVehicleInfo) },
            BuyAmmoInfo::class to { e: Any -> invokeBuyAmmoEvent(e as BuyAmmoInfo) },
            MiningRefinedInfo::class to { e: Any -> invokeMiningRefinedEvent(e as MiningRefinedInfo) },
            DatalinkVoucherInfo::class to { e: Any -> invokeDatalinkVoucherEvent(e as DatalinkVoucherInfo) },
            ScannedInfo::class to { e: Any -> invokeScannedEvent(e as ScannedInfo) },
            ChangeCrewRoleInfo::class to { e: Any -> invokeChangeCrewRoleEvent(e as ChangeCrewRoleInfo) },
            TouchdownInfo::class to { e: Any -> invokeTouchdownEvent(e as TouchdownInfo) },
            SendTextInfo::class to { e: Any -> invokeSendTextEvent(e as SendTextInfo) },
            RefuelAllInfo::class to { e: Any -> invokeRefuelAllEvent(e as RefuelAllInfo) },
            EndCrewSessionInfo::class to { e: Any -> invokeEndCrewSessionEvent(e as EndCrewSessionInfo) },
            LiftoffInfo::class to { e: Any -> invokeLiftoffEvent(e as LiftoffInfo) },
            EscapeInterdictionInfo::class to { e: Any -> invokeEscapeInterdictionEvent(e as EscapeInterdictionInfo) },
            WingAddInfo::class to { e: Any -> invokeWingAddEvent(e as WingAddInfo) },
            SellDronesInfo::class to { e: Any -> invokeSellDronesEvent(e as SellDronesInfo) },
            FileheaderInfo::class to { e: Any -> invokeFileheaderEvent(e as FileheaderInfo) },
            InterdictedInfo::class to { e: Any -> invokeInterdictedEvent(e as InterdictedInfo) },
            CrewMemberJoinsInfo::class to { e: Any -> invokeCrewMemberJoinsEvent(e as CrewMemberJoinsInfo) },
            CrewMemberQuitsInfo::class to { e: Any -> invokeCrewMemberQuitsEvent(e as CrewMemberQuitsInfo) },
            CrewMemberRoleChangeInfo::class to { e: Any -> invokeCrewMemberRoleChangeEvent(e as CrewMemberRoleChangeInfo) },
            PVPKillInfo::class to { e: Any -> invokePVPKillEvent(e as PVPKillInfo) },
            JoinACrewInfo::class to { e: Any -> invokeJoinACrewEvent(e as JoinACrewInfo) },
            QuitACrewInfo::class to { e: Any -> invokeQuitACrewEvent(e as QuitACrewInfo) },
            ProgressInfo::class to { e: Any -> invokeProgressEvent(e as ProgressInfo) },
            PromotionInfo::class to { e: Any -> invokePromotionEvent(e as PromotionInfo) },
            RankInfo::class to { e: Any -> invokeRankEvent(e as RankInfo) },
            CommitCrimeInfo::class to { e: Any -> invokeCommitCrimeEvent(e as CommitCrimeInfo) },
            EngineerContributionInfo::class to { e: Any -> invokeEngineerContributionEvent(e as EngineerContributionInfo) },
            MusicInfo::class to { e: Any -> invokeMusicEvent(e as MusicInfo) },
            DiedInfo::class to { e: Any -> invokeDiedEvent(e as DiedInfo) },
            PassengersInfo::class to { e: Any -> invokePassengersEvent(e as PassengersInfo) },
            SearchAndRescueInfo::class to { e: Any -> invokeSearchAndRescueEvent(e as SearchAndRescueInfo) },
            KickCrewMemberInfo::class to { e: Any -> invokeKickCrewMemberEvent(e as KickCrewMemberInfo) },
            RedeemVoucherInfo::class to { e: Any -> invokeRedeemVoucherEvent(e as RedeemVoucherInfo) },
            ResurrectInfo::class to { e: Any -> invokeResurrectEvent(e as ResurrectInfo) },
            CommunityGoalJoinInfo::class to { e: Any -> invokeCommunityGoalJoinEvent(e as CommunityGoalJoinInfo) },
            CommunityGoalInfo::class to { e: Any -> invokeCommunityGoalEvent(e as CommunityGoalInfo) },
            RepairDroneInfo::class to { e: Any -> invokeRepairDroneEvent(e as RepairDroneInfo) },
            RepairInfo::class to { e: Any -> invokeRepairEvent(e as RepairInfo) },
            JetConeDamageInfo::class to { e: Any -> invokeJetConeDamageEvent(e as JetConeDamageInfo) },
            CommunityGoalDiscardInfo::class to { e: Any -> invokeCommunityGoalDiscardEvent(e as CommunityGoalDiscardInfo) },
            MissionAcceptedInfo::class to { e: Any -> invokeMissionAcceptedEvent(e as MissionAcceptedInfo) },
            BuyExplorationDataInfo::class to { e: Any -> invokeBuyExplorationDataEvent(e as BuyExplorationDataInfo) },
            RepairAllInfo::class to { e: Any -> invokeRepairAllEvent(e as RepairAllInfo) },
            CrewLaunchFighterInfo::class to { e: Any -> invokeCrewLaunchFighterEvent(e as CrewLaunchFighterInfo) },
            MaterialDiscardedInfo::class to { e: Any -> invokeMaterialDiscardedEvent(e as MaterialDiscardedInfo) },
            NewCommanderInfo::class to { e: Any -> invokeNewCommanderEvent(e as NewCommanderInfo) },
            CommunityGoalRewardInfo::class to { e: Any -> invokeCommunityGoalRewardEvent(e as CommunityGoalRewardInfo) },
            PowerplayVoteInfo::class to { e: Any -> invokePowerplayVoteEvent(e as PowerplayVoteInfo) },
            PowerplayJoinInfo::class to { e: Any -> invokePowerplayJoinEvent(e as PowerplayJoinInfo) },
            PowerplayDefectInfo::class to { e: Any -> invokePowerplayDefectEvent(e as PowerplayDefectInfo) },
            MissionFailedInfo::class to { e: Any -> invokeMissionFailedEvent(e as MissionFailedInfo) },
            MissionRedirectedInfo::class to { e: Any -> invokeMissionRedirectedEvent(e as MissionRedirectedInfo) },
            ShutdownInfo::class to { e: Any -> invokeShutdownEvent(e as ShutdownInfo) },
            ModuleInfoInfo::class to { e: Any -> invokeModuleInfoEvent(e as ModuleInfoInfo) },
            MarketInfo::class to { e: Any -> invokeMarketEvent(e as MarketInfo) },
            MassModuleStoreInfo::class to { e: Any -> invokeMassModuleStoreEvent(e as MassModuleStoreInfo) },
            MaterialDiscoveredInfo::class to { e: Any -> invokeMaterialDiscoveredEvent(e as MaterialDiscoveredInfo) },
            MaterialCollectedInfo::class to { e: Any -> invokeMaterialCollectedEvent(e as MaterialCollectedInfo) },
            SRVDestroyedInfo::class to { e: Any -> invokeSRVDestroyedEvent(e as SRVDestroyedInfo) },
            DockingDeniedInfo::class to { e: Any -> invokeDockingDeniedEvent(e as DockingDeniedInfo) },
            UnderAttackInfo::class to { e: Any -> invokeUnderAttackEvent(e as UnderAttackInfo) },
            ShipTargetedInfo::class to { e: Any -> invokeShipTargetedEvent(e as ShipTargetedInfo) },
            ShipyardInfo::class to { e: Any -> invokeShipyardEvent(e as ShipyardInfo) },
            OutfittingInfo::class to { e: Any -> invokeOutfittingEvent(e as OutfittingInfo) },
            PowerplayFastTrackInfo::class to { e: Any -> invokePowerplayFastTrackEvent(e as PowerplayFastTrackInfo) },
            PowerplayInfo::class to { e: Any -> invokePowerplayEvent(e as PowerplayInfo) },
            CollectCargoInfo::class to { e: Any -> invokeCollectCargoEvent(e as CollectCargoInfo) },
            FetchRemoteModuleInfo::class to { e: Any -> invokeFetchRemoteModuleEvent(e as FetchRemoteModuleInfo) },
            ModuleStoreInfo::class to { e: Any -> invokeModuleStoreEvent(e as ModuleStoreInfo) },
            ShipyardBuyInfo::class to { e: Any -> invokeShipyardBuyEvent(e as ShipyardBuyInfo) },
            ShipyardNewInfo::class to { e: Any -> invokeShipyardNewEvent(e as ShipyardNewInfo) },
            ModuleBuyInfo::class to { e: Any -> invokeModuleBuyEvent(e as ModuleBuyInfo) },
            ModuleRetrieveInfo::class to { e: Any -> invokeModuleRetrieveEvent(e as ModuleRetrieveInfo) },
            AfmuRepairsInfo::class to { e: Any -> invokeAfmuRepairsEvent(e as AfmuRepairsInfo) },
            LaunchDroneInfo::class to { e: Any -> invokeLaunchDroneEvent(e as LaunchDroneInfo) },
            MarketSellInfo::class to { e: Any -> invokeMarketSellEvent(e as MarketSellInfo) },
            ModuleSellInfo::class to { e: Any -> invokeModuleSellEvent(e as ModuleSellInfo) },
            FuelScoopInfo::class to { e: Any -> invokeFuelScoopEvent(e as FuelScoopInfo) },
            FighterDestroyedInfo::class to { e: Any -> invokeFighterDestroyedEvent(e as FighterDestroyedInfo) },
            DiscoveryScanInfo::class to { e: Any -> invokeDiscoveryScanEvent(e as DiscoveryScanInfo) },
            LeaveBodyInfo::class to { e: Any -> invokeLeaveBodyEvent(e as LeaveBodyInfo) },
            PowerplayVoucherInfo::class to { e: Any -> invokePowerplayVoucherEvent(e as PowerplayVoucherInfo) },
            ReputationInfo::class to { e: Any -> invokeReputationEvent(e as ReputationInfo) },
            NavBeaconScanInfo::class to { e: Any -> invokeNavBeaconScanEvent(e as NavBeaconScanInfo) },
            MissionsInfo::class to { e: Any -> invokeMissionsEvent(e as MissionsInfo) },
            FriendsInfo::class to { e: Any -> invokeFriendsEvent(e as FriendsInfo) },
            ShipyardSellInfo::class to { e: Any -> invokeShipyardSellEvent(e as ShipyardSellInfo) },
            MissionAbandonedInfo::class to { e: Any -> invokeMissionAbandonedEvent(e as MissionAbandonedInfo) },
            ScientificResearchInfo::class to { e: Any -> invokeScientificResearchEvent(e as ScientificResearchInfo) },
            DockingTimeoutInfo::class to { e: Any -> invokeDockingTimeoutEvent(e as DockingTimeoutInfo) },
            DockingCancelledInfo::class to { e: Any -> invokeDockingCancelledEvent(e as DockingCancelledInfo) },
            DockingRequestedInfo::class to { e: Any -> invokeDockingRequestedEvent(e as DockingRequestedInfo) },
            DockingGrantedInfo::class to { e: Any -> invokeDockingGrantedEvent(e as DockingGrantedInfo) },
            UndockedInfo::class to { e: Any -> invokeUndockedEvent(e as UndockedInfo) },
            CrewHireInfo::class to { e: Any -> invokeCrewHireEvent(e as CrewHireInfo) },
            ScreenshotInfo::class to { e: Any -> invokeScreenshotEvent(e as ScreenshotInfo) },
            SynthesisInfo::class to { e: Any -> invokeSynthesisEvent(e as SynthesisInfo) },
            FighterRebuiltInfo::class to { e: Any -> invokeFighterRebuiltEvent(e as FighterRebuiltInfo) },
            SellExplorationDataInfo::class to { e: Any -> invokeSellExplorationDataEvent(e as SellExplorationDataInfo) },
            RebootRepairInfo::class to { e: Any -> invokeRebootRepairEvent(e as RebootRepairInfo) },
            ScanInfo::class to { e: Any -> invokeScanEvent(e as ScanInfo) },
            WingInviteInfo::class to { e: Any -> invokeWingInviteEvent(e as WingInviteInfo) },
            StartJumpInfo::class to { e: Any -> invokeStartJumpEvent(e as StartJumpInfo) },
            SupercruiseExitInfo::class to { e: Any -> invokeSupercruiseExitEvent(e as SupercruiseExitInfo) },
            PayBountiesInfo::class to { e: Any -> invokePayBountiesEvent(e as PayBountiesInfo) },
            PowerplaySalaryInfo::class to { e: Any -> invokePowerplaySalaryEvent(e as PowerplaySalaryInfo) },
            ShipyardTransferInfo::class to { e: Any -> invokeShipyardTransferEvent(e as ShipyardTransferInfo) },
            TechnologyBrokerInfo::class to { e: Any -> invokeTechnologyBrokerEvent(e as TechnologyBrokerInfo) },
            PayFinesInfo::class to { e: Any -> invokePayFinesEvent(e as PayFinesInfo) },
            BountyInfo::class to { e: Any -> invokeBountyEvent(e as BountyInfo) },
            MaterialTradeInfo::class to { e: Any -> invokeMaterialTradeEvent(e as MaterialTradeInfo) },
            ReceiveTextInfo::class to { e: Any -> invokeReceiveTextEvent(e as ReceiveTextInfo) },
            ModuleSellRemoteInfo::class to { e: Any -> invokeModuleSellRemoteEvent(e as ModuleSellRemoteInfo) },
            ShipyardSwapInfo::class to { e: Any -> invokeShipyardSwapEvent(e as ShipyardSwapInfo) },
            MarketBuyInfo::class to { e: Any -> invokeMarketBuyEvent(e as MarketBuyInfo) },
            CargoDepotInfo::class to { e: Any -> invokeCargoDepotEvent(e as CargoDepotInfo) },
            FactionKillBondInfo::class to { e: Any -> invokeFactionKillBondEvent(e as FactionKillBondInfo) },
            StoredModulesInfo::class to { e: Any -> invokeStoredModulesEvent(e as StoredModulesInfo) },
            WingJoinInfo::class to { e: Any -> invokeWingJoinEvent(e as WingJoinInfo) },
            ApproachBodyInfo::class to { e: Any -> invokeApproachBodyEvent(e as ApproachBodyInfo) },
            EngineerProgressInfo::class to { e: Any -> invokeEngineerProgressEvent(e as EngineerProgressInfo) },
            FSSDiscoveryScanInfo::class to { e: Any -> invokeFSSDiscoveryScanEvent(e as FSSDiscoveryScanInfo) },
            SquadronCreatedInfo::class to { e: Any -> invokeSquadronCreatedEvent(e as SquadronCreatedInfo) },
            CommanderInfo::class to { e: Any -> invokeCommanderEvent(e as CommanderInfo) },
            JoinedSquadronInfo::class to { e: Any -> invokeJoinedSquadronEvent(e as JoinedSquadronInfo) },
            EjectCargoInfo::class to { e: Any -> invokeEjectCargoEvent(e as EjectCargoInfo) },
            NpcCrewPaidWageInfo::class to { e: Any -> invokeNpcCrewPaidWageEvent(e as NpcCrewPaidWageInfo) },
            MaterialsInfo::class to { e: Any -> invokeMaterialsEvent(e as MaterialsInfo) },
            LoadGameInfo::class to { e: Any -> invokeLoadGameEvent(e as LoadGameInfo) },
            SupercruiseEntryInfo::class to { e: Any -> invokeSupercruiseEntryEvent(e as SupercruiseEntryInfo) },
            FSDTargetInfo::class to { e: Any -> invokeFSDTargetEvent(e as FSDTargetInfo) },
            FSSAllBodiesFoundInfo::class to { e: Any -> invokeFSSAllBodiesFoundEvent(e as FSSAllBodiesFoundInfo) },
            SAAScanCompleteInfo::class to { e: Any -> invokeSAAScanCompleteEvent(e as SAAScanCompleteInfo) },
            CodexEntryInfo::class to { e: Any -> invokeCodexEntryEvent(e as CodexEntryInfo) },
            CrimeVictimInfo::class to { e: Any -> invokeCrimeVictimEvent(e as CrimeVictimInfo) },
            LoadoutInfo::class to { e: Any -> invokeLoadoutEvent(e as LoadoutInfo) },
            MissionCompletedInfo::class to { e: Any -> invokeMissionCompletedEvent(e as MissionCompletedInfo) },
            BuyTradeDataInfo::class to { e: Any -> invokeBuyTradeDataEvent(e as BuyTradeDataInfo) },
            CrewAssignInfo::class to { e: Any -> invokeCrewAssignEvent(e as CrewAssignInfo) },
            CrewFireInfo::class to { e: Any -> invokeCrewFireEvent(e as CrewFireInfo) },
            MultiSellExplorationDataInfo::class to { e: Any -> invokeMultiSellExplorationDataEvent(e as MultiSellExplorationDataInfo) },
            LocationInfo::class to { e: Any -> invokeLocationEvent(e as LocationInfo) },
            AsteroidCrackedInfo::class to { e: Any -> invokeAsteroidCrackedEvent(e as AsteroidCrackedInfo) },
            ModuleSwapInfo::class to { e: Any -> invokeModuleSwapEvent(e as ModuleSwapInfo) },
            DataScannedInfo::class to { e: Any -> invokeDataScannedEvent(e as DataScannedInfo) },
            DisbandedSquadronInfo::class to { e: Any -> invokeDisbandedSquadronEvent(e as DisbandedSquadronInfo) },
            AppliedToSquadronInfo::class to { e: Any -> invokeAppliedToSquadronEvent(e as AppliedToSquadronInfo) },
            DockedInfo::class to { e: Any -> invokeDockedEvent(e as DockedInfo) },
            StatisticsInfo::class to { e: Any -> invokeStatisticsEvent(e as StatisticsInfo) },
            SetUserShipNameInfo::class to { e: Any -> invokeSetUserShipNameEvent(e as SetUserShipNameInfo) },
            FSDJumpInfo::class to { e: Any -> invokeFSDJumpEvent(e as FSDJumpInfo) },
            CargoInfo::class to { e: Any -> invokeCargoEvent(e as CargoInfo) },
            EngineerCraftInfo::class to { e: Any -> invokeEngineerCraftEvent(e as EngineerCraftInfo) },
            ApproachSettlementInfo::class to { e: Any -> invokeApproachSettlementEvent(e as ApproachSettlementInfo) },
            StoredShipsInfo::class to { e: Any -> invokeStoredShipsEvent(e as StoredShipsInfo) },
            FSSSignalDiscoveredInfo::class to { e: Any -> invokeFSSSignalDiscoveredEvent(e as FSSSignalDiscoveredInfo) },
            SquadronStartupInfo::class to { e: Any -> invokeSquadronStartupEvent(e as SquadronStartupInfo) }
    )

    fun invokeAllEvents(e: Any) {
        eventMap.asSequence()
                .filter { it.key == e::class }
                .forEach { it.value(e) }
    }

    val statusInMainMenu = event<StatusEvent>()
    fun invokeStatusInMainMenu(e: StatusEvent): StatusEvent {
        statusInMainMenu.invoke(e)
        return e
    }

    val statusIsRunning = event<StatusEvent>()
    fun invokeStatusIsRunning(e: StatusEvent): StatusEvent {
        statusIsRunning.invoke(e)
        return e
    }

    val statusInNoFireZoneEvent = event<StatusEvent>()
    fun invokeStatusInNoFireZone(e: StatusEvent): StatusEvent {
        statusInNoFireZoneEvent.invoke(e)
        return e
    }

    val statusDockedEvent = event<StatusEvent>()
    fun invokeStatusDocked(e: StatusEvent): StatusEvent {
        statusDockedEvent.invoke(e)
        return e
    }

    val statusLandedEvent = event<StatusEvent>()
    fun invokeStatusLanded(e: StatusEvent): StatusEvent {
        statusLandedEvent.invoke(e)
        return e
    }

    val statusFsdCooldownEvent = event<StatusEvent>()
    fun invokeStatusFsdCooldown(e: StatusEvent): StatusEvent {
        statusFsdCooldownEvent.invoke(e)
        return e
    }

    val statusGearEvent = event<StatusEvent>()
    fun invokeStatusGear(e: StatusEvent): StatusEvent {
        statusGearEvent.invoke(e)
        return e
    }

    val statusShieldsEvent = event<StatusEvent>()
    fun invokeStatusShields(e: StatusEvent): StatusEvent {
        statusShieldsEvent.invoke(e)
        return e
    }

    val statusSupercruiseEvent = event<StatusEvent>()
    fun invokeStatusSupercruise(e: StatusEvent): StatusEvent {
        statusSupercruiseEvent.invoke(e)
        return e
    }

    val statusFlightAssistEvent = event<StatusEvent>()
    fun invokeStatusFlightAssist(e: StatusEvent): StatusEvent {
        statusFlightAssistEvent.invoke(e)
        return e
    }

    val statusHardpointsEvent = event<StatusEvent>()
    fun invokeStatusHardpoints(e: StatusEvent): StatusEvent {
        statusHardpointsEvent.invoke(e)
        return e
    }

    val statusWingingEvent = event<StatusEvent>()
    fun invokeStatusWinging(e: StatusEvent): StatusEvent {
        statusWingingEvent.invoke(e)
        return e
    }

    val statusLightsEvent = event<StatusEvent>()
    fun invokeStatusLights(e: StatusEvent): StatusEvent {
        statusLightsEvent.invoke(e)
        return e
    }

    val statusCargoScoopEvent = event<StatusEvent>()
    fun invokeStatusCargoScoop(e: StatusEvent): StatusEvent {
        statusCargoScoopEvent.invoke(e)
        return e
    }

    val statusSilentRunningEvent = event<StatusEvent>()
    fun invokeStatusSilentRunning(e: StatusEvent): StatusEvent {
        statusSilentRunningEvent.invoke(e)
        return e
    }

    val statusScoopingEvent = event<StatusEvent>()
    fun invokeStatusScooping(e: StatusEvent): StatusEvent {
        statusScoopingEvent.invoke(e)
        return e
    }

    val statusSrvHandbreakEvent = event<StatusEvent>()
    fun invokeStatusSrvHandbreak(e: StatusEvent): StatusEvent {
        statusSrvHandbreakEvent.invoke(e)
        return e
    }

    val statusSrvTurrentEvent = event<StatusEvent>()
    fun invokeStatusSrvTurrent(e: StatusEvent): StatusEvent {
        statusSrvTurrentEvent.invoke(e)
        return e
    }

    val statusSrvNearShipEvent = event<StatusEvent>()
    fun invokeStatusSrvNearShip(e: StatusEvent): StatusEvent {
        statusSrvNearShipEvent.invoke(e)
        return e
    }

    val statusSrvDriveAssistEvent = event<StatusEvent>()
    fun invokeStatusSrvDriveAssist(e: StatusEvent): StatusEvent {
        statusSrvDriveAssistEvent.invoke(e)
        return e
    }

    val statusMassLockedEvent = event<StatusEvent>()
    fun invokeStatusMassLocked(e: StatusEvent): StatusEvent {
        statusMassLockedEvent.invoke(e)
        return e
    }

    val statusFsdChargingEvent = event<StatusEvent>()
    fun invokeStatusFsdCharging(e: StatusEvent): StatusEvent {
        statusFsdChargingEvent.invoke(e)
        return e
    }

    val statusFsdCooldowEvent = event<StatusEvent>()
    fun invokeStatusFsdCooldow(e: StatusEvent): StatusEvent {
        statusFsdCooldowEvent.invoke(e)
        return e
    }

    val statusLowFuelEvent = event<StatusEvent>()
    fun invokeStatusLowFuel(e: StatusEvent): StatusEvent {
        statusLowFuelEvent.invoke(e)
        return e
    }

    val statusOverheatingEvent = event<StatusEvent>()
    fun invokeStatusOverheating(e: StatusEvent): StatusEvent {
        statusOverheatingEvent.invoke(e)
        return e
    }

    val statusHasLatLongEvent = event<StatusEvent>()
    fun invokeStatusHasLatLong(e: StatusEvent): StatusEvent {
        statusHasLatLongEvent.invoke(e)
        return e
    }

    val statusInDangerEvent = event<StatusEvent>()
    fun invokeStatusInDanger(e: StatusEvent): StatusEvent {
        statusInDangerEvent.invoke(e)
        return e
    }

    val statusInInterdictionEvent = event<StatusEvent>()
    fun invokeStatusInInterdiction(e: StatusEvent): StatusEvent {
        statusInInterdictionEvent.invoke(e)
        return e
    }

    val statusInMothershipEvent = event<StatusEvent>()
    fun invokeStatusInMothership(e: StatusEvent): StatusEvent {
        statusInMothershipEvent.invoke(e)
        return e
    }

    val statusInFighterEvent = event<StatusEvent>()
    fun invokeStatusInFighter(e: StatusEvent): StatusEvent {
        statusInFighterEvent.invoke(e)
        return e
    }

    val statusInSRVEvent = event<StatusEvent>()
    fun invokeStatusInSRV(e: StatusEvent): StatusEvent {
        statusInSRVEvent.invoke(e)
        return e
    }

    val statusAnalysisModeEvent = event<StatusEvent>()
    fun invokeStatusAnalysisMode(e: StatusEvent): StatusEvent {
        statusAnalysisModeEvent.invoke(e)
        return e
    }

    val statusNightVisionEvent = event<StatusEvent>()
    fun invokeStatusNightVision(e: StatusEvent): StatusEvent {
        statusNightVisionEvent.invoke(e)
        return e
    }

    //ReservoirReplenished
    val reservoirReplenishedEvent = event<ReservoirReplenishedInfo>()

    fun invokeReservoirReplenishedEvent(e: ReservoirReplenishedInfo): ReservoirReplenishedInfo {
        reservoirReplenishedEvent.invoke(e)
        return e
    }

    //ProspectedAsteroid
    val prospectedAsteroidEvent = event<ProspectedAsteroidInfo>()

    fun invokeProspectedAsteroidEvent(e: ProspectedAsteroidInfo): ProspectedAsteroidInfo {
        prospectedAsteroidEvent.invoke(e)
        return e
    }

    //LeftSquadron
    val leftSquadronEvent = event<LeftSquadronInfo>()

    fun invokeLeftSquadronEvent(e: LeftSquadronInfo): LeftSquadronInfo {
        leftSquadronEvent.invoke(e)
        return e
    }

    //HeatWarning
    val heatWarningEvent = event<HeatWarningInfo>()

    fun invokeHeatWarningEvent(e: HeatWarningInfo): HeatWarningInfo {
        heatWarningEvent.invoke(e)
        return e
    }

    //ShieldState
    val shieldStateEvent = event<ShieldStateInfo>()

    fun invokeShieldStateEvent(e: ShieldStateInfo): ShieldStateInfo {
        shieldStateEvent.invoke(e)
        return e
    }

    //VehicleSwitch
    val vehicleSwitchEvent = event<VehicleSwitchInfo>()

    fun invokeVehicleSwitchEvent(e: VehicleSwitchInfo): VehicleSwitchInfo {
        vehicleSwitchEvent.invoke(e)
        return e
    }

    //DockFighter
    val dockFighterEvent = event<DockFighterInfo>()

    fun invokeDockFighterEvent(e: DockFighterInfo): DockFighterInfo {
        dockFighterEvent.invoke(e)
        return e
    }

    //LaunchSRV
    val launchSRVEvent = event<LaunchSRVInfo>()

    fun invokeLaunchSRVEvent(e: LaunchSRVInfo): LaunchSRVInfo {
        launchSRVEvent.invoke(e)
        return e
    }

    //SelfDestruct
    val selfDestructEvent = event<SelfDestructInfo>()

    fun invokeSelfDestructEvent(e: SelfDestructInfo): SelfDestructInfo {
        selfDestructEvent.invoke(e)
        return e
    }

    //DockSRV
    val dockSRVEvent = event<DockSRVInfo>()

    fun invokeDockSRVEvent(e: DockSRVInfo): DockSRVInfo {
        dockSRVEvent.invoke(e)
        return e
    }

    //HeatDamage
    val heatDamageEvent = event<HeatDamageInfo>()

    fun invokeHeatDamageEvent(e: HeatDamageInfo): HeatDamageInfo {
        heatDamageEvent.invoke(e)
        return e
    }

    //LaunchFighter
    val launchFighterEvent = event<LaunchFighterInfo>()

    fun invokeLaunchFighterEvent(e: LaunchFighterInfo): LaunchFighterInfo {
        launchFighterEvent.invoke(e)
        return e
    }

    //DatalinkScan
    val datalinkScanEvent = event<DatalinkScanInfo>()

    fun invokeDatalinkScanEvent(e: DatalinkScanInfo): DatalinkScanInfo {
        datalinkScanEvent.invoke(e)
        return e
    }

    //CockpitBreached
    val cockpitBreachedEvent = event<CockpitBreachedInfo>()

    fun invokeCockpitBreachedEvent(e: CockpitBreachedInfo): CockpitBreachedInfo {
        cockpitBreachedEvent.invoke(e)
        return e
    }

    //JetConeBoost
    val jetConeBoostEvent = event<JetConeBoostInfo>()

    fun invokeJetConeBoostEvent(e: JetConeBoostInfo): JetConeBoostInfo {
        jetConeBoostEvent.invoke(e)
        return e
    }

    //PowerplayLeave
    val powerplayLeaveEvent = event<PowerplayLeaveInfo>()

    fun invokePowerplayLeaveEvent(e: PowerplayLeaveInfo): PowerplayLeaveInfo {
        powerplayLeaveEvent.invoke(e)
        return e
    }

    //Interdiction
    val interdictionEvent = event<InterdictionInfo>()

    fun invokeInterdictionEvent(e: InterdictionInfo): InterdictionInfo {
        interdictionEvent.invoke(e)
        return e
    }

    //USSDrop
    val uSSDropEvent = event<USSDropInfo>()

    fun invokeUSSDropEvent(e: USSDropInfo): USSDropInfo {
        uSSDropEvent.invoke(e)
        return e
    }

    //PowerplayCollect
    val powerplayCollectEvent = event<PowerplayCollectInfo>()

    fun invokePowerplayCollectEvent(e: PowerplayCollectInfo): PowerplayCollectInfo {
        powerplayCollectEvent.invoke(e)
        return e
    }

    //PowerplayDeliver
    val powerplayDeliverEvent = event<PowerplayDeliverInfo>()

    fun invokePowerplayDeliverEvent(e: PowerplayDeliverInfo): PowerplayDeliverInfo {
        powerplayDeliverEvent.invoke(e)
        return e
    }

    //PayLegacyFines
    val payLegacyFinesEvent = event<PayLegacyFinesInfo>()

    fun invokePayLegacyFinesEvent(e: PayLegacyFinesInfo): PayLegacyFinesInfo {
        payLegacyFinesEvent.invoke(e)
        return e
    }

    //EngineerApply
    val engineerApplyEvent = event<EngineerApplyInfo>()

    fun invokeEngineerApplyEvent(e: EngineerApplyInfo): EngineerApplyInfo {
        engineerApplyEvent.invoke(e)
        return e
    }

    //WingLeave
    val wingLeaveEvent = event<WingLeaveInfo>()

    fun invokeWingLeaveEvent(e: WingLeaveInfo): WingLeaveInfo {
        wingLeaveEvent.invoke(e)
        return e
    }

    //SystemsShutdown
    val systemsShutdownEvent = event<SystemsShutdownInfo>()

    fun invokeSystemsShutdownEvent(e: SystemsShutdownInfo): SystemsShutdownInfo {
        systemsShutdownEvent.invoke(e)
        return e
    }

    //HullDamage
    val hullDamageEvent = event<HullDamageInfo>()

    fun invokeHullDamageEvent(e: HullDamageInfo): HullDamageInfo {
        hullDamageEvent.invoke(e)
        return e
    }

    //BuyDrones
    val buyDronesEvent = event<BuyDronesInfo>()

    fun invokeBuyDronesEvent(e: BuyDronesInfo): BuyDronesInfo {
        buyDronesEvent.invoke(e)
        return e
    }

    //RestockVehicle
    val restockVehicleEvent = event<RestockVehicleInfo>()

    fun invokeRestockVehicleEvent(e: RestockVehicleInfo): RestockVehicleInfo {
        restockVehicleEvent.invoke(e)
        return e
    }

    //BuyAmmo
    val buyAmmoEvent = event<BuyAmmoInfo>()

    fun invokeBuyAmmoEvent(e: BuyAmmoInfo): BuyAmmoInfo {
        buyAmmoEvent.invoke(e)
        return e
    }

    //MiningRefined
    val miningRefinedEvent = event<MiningRefinedInfo>()

    fun invokeMiningRefinedEvent(e: MiningRefinedInfo): MiningRefinedInfo {
        miningRefinedEvent.invoke(e)
        return e
    }

    //DatalinkVoucher
    val datalinkVoucherEvent = event<DatalinkVoucherInfo>()

    fun invokeDatalinkVoucherEvent(e: DatalinkVoucherInfo): DatalinkVoucherInfo {
        datalinkVoucherEvent.invoke(e)
        return e
    }

    //Scanned
    val scannedEvent = event<ScannedInfo>()

    fun invokeScannedEvent(e: ScannedInfo): ScannedInfo {
        scannedEvent.invoke(e)
        return e
    }

    //ChangeCrewRole
    val changeCrewRoleEvent = event<ChangeCrewRoleInfo>()

    fun invokeChangeCrewRoleEvent(e: ChangeCrewRoleInfo): ChangeCrewRoleInfo {
        changeCrewRoleEvent.invoke(e)
        return e
    }

    //Touchdown
    val touchdownEvent = event<TouchdownInfo>()

    fun invokeTouchdownEvent(e: TouchdownInfo): TouchdownInfo {
        touchdownEvent.invoke(e)
        return e
    }

    //SendText
    val sendTextEvent = event<SendTextInfo>()

    fun invokeSendTextEvent(e: SendTextInfo): SendTextInfo {
        sendTextEvent.invoke(e)
        return e
    }

    //RefuelAll
    val refuelAllEvent = event<RefuelAllInfo>()

    fun invokeRefuelAllEvent(e: RefuelAllInfo): RefuelAllInfo {
        refuelAllEvent.invoke(e)
        return e
    }

    //EndCrewSession
    val endCrewSessionEvent = event<EndCrewSessionInfo>()

    fun invokeEndCrewSessionEvent(e: EndCrewSessionInfo): EndCrewSessionInfo {
        endCrewSessionEvent.invoke(e)
        return e
    }

    //Liftoff
    val liftoffEvent = event<LiftoffInfo>()

    fun invokeLiftoffEvent(e: LiftoffInfo): LiftoffInfo {
        liftoffEvent.invoke(e)
        return e
    }

    //EscapeInterdiction
    val escapeInterdictionEvent = event<EscapeInterdictionInfo>()

    fun invokeEscapeInterdictionEvent(e: EscapeInterdictionInfo): EscapeInterdictionInfo {
        escapeInterdictionEvent.invoke(e)
        return e
    }

    //WingAdd
    val wingAddEvent = event<WingAddInfo>()

    fun invokeWingAddEvent(e: WingAddInfo): WingAddInfo {
        wingAddEvent.invoke(e)
        return e
    }

    //SellDrones
    val sellDronesEvent = event<SellDronesInfo>()

    fun invokeSellDronesEvent(e: SellDronesInfo): SellDronesInfo {
        sellDronesEvent.invoke(e)
        return e
    }

    //Fileheader
    val fileheaderEvent = event<FileheaderInfo>()

    fun invokeFileheaderEvent(e: FileheaderInfo): FileheaderInfo {
        fileheaderEvent.invoke(e)
        return e
    }

    //Interdicted
    val interdictedEvent = event<InterdictedInfo>()

    fun invokeInterdictedEvent(e: InterdictedInfo): InterdictedInfo {
        interdictedEvent.invoke(e)
        return e
    }

    //CrewMemberJoins
    val crewMemberJoinsEvent = event<CrewMemberJoinsInfo>()

    fun invokeCrewMemberJoinsEvent(e: CrewMemberJoinsInfo): CrewMemberJoinsInfo {
        crewMemberJoinsEvent.invoke(e)
        return e
    }

    //CrewMemberQuits
    val crewMemberQuitsEvent = event<CrewMemberQuitsInfo>()

    fun invokeCrewMemberQuitsEvent(e: CrewMemberQuitsInfo): CrewMemberQuitsInfo {
        crewMemberQuitsEvent.invoke(e)
        return e
    }

    //CrewMemberRoleChange
    val crewMemberRoleChangeEvent = event<CrewMemberRoleChangeInfo>()

    fun invokeCrewMemberRoleChangeEvent(e: CrewMemberRoleChangeInfo): CrewMemberRoleChangeInfo {
        crewMemberRoleChangeEvent.invoke(e)
        return e
    }

    //PVPKill
    val pVPKillEvent = event<PVPKillInfo>()

    fun invokePVPKillEvent(e: PVPKillInfo): PVPKillInfo {
        pVPKillEvent.invoke(e)
        return e
    }

    //JoinACrew
    val joinACrewEvent = event<JoinACrewInfo>()

    fun invokeJoinACrewEvent(e: JoinACrewInfo): JoinACrewInfo {
        joinACrewEvent.invoke(e)
        return e
    }

    //QuitACrew
    val quitACrewEvent = event<QuitACrewInfo>()

    fun invokeQuitACrewEvent(e: QuitACrewInfo): QuitACrewInfo {
        quitACrewEvent.invoke(e)
        return e
    }

    //Progress
    val progressEvent = event<ProgressInfo>()

    fun invokeProgressEvent(e: ProgressInfo): ProgressInfo {
        progressEvent.invoke(e)
        return e
    }

    //Promotion
    val promotionEvent = event<PromotionInfo>()

    fun invokePromotionEvent(e: PromotionInfo): PromotionInfo {
        promotionEvent.invoke(e)
        return e
    }

    //Rank
    val rankEvent = event<RankInfo>()

    fun invokeRankEvent(e: RankInfo): RankInfo {
        rankEvent.invoke(e)
        return e
    }

    //CommitCrime
    val commitCrimeEvent = event<CommitCrimeInfo>()

    fun invokeCommitCrimeEvent(e: CommitCrimeInfo): CommitCrimeInfo {
        commitCrimeEvent.invoke(e)
        return e
    }

    //EngineerContribution
    val engineerContributionEvent = event<EngineerContributionInfo>()

    fun invokeEngineerContributionEvent(e: EngineerContributionInfo): EngineerContributionInfo {
        engineerContributionEvent.invoke(e)
        return e
    }

    //Music
    val musicEvent = event<MusicInfo>()

    fun invokeMusicEvent(e: MusicInfo): MusicInfo {
        musicEvent.invoke(e)
        return e
    }

    //Died
    val diedEvent = event<DiedInfo>()

    fun invokeDiedEvent(e: DiedInfo): DiedInfo {
        diedEvent.invoke(e)
        return e
    }

    //Passengers
    val passengersEvent = event<PassengersInfo>()

    fun invokePassengersEvent(e: PassengersInfo): PassengersInfo {
        passengersEvent.invoke(e)
        return e
    }

    //SearchAndRescue
    val searchAndRescueEvent = event<SearchAndRescueInfo>()

    fun invokeSearchAndRescueEvent(e: SearchAndRescueInfo): SearchAndRescueInfo {
        searchAndRescueEvent.invoke(e)
        return e
    }

    //KickCrewMember
    val kickCrewMemberEvent = event<KickCrewMemberInfo>()

    fun invokeKickCrewMemberEvent(e: KickCrewMemberInfo): KickCrewMemberInfo {
        kickCrewMemberEvent.invoke(e)
        return e
    }

    //RedeemVoucher
    val redeemVoucherEvent = event<RedeemVoucherInfo>()

    fun invokeRedeemVoucherEvent(e: RedeemVoucherInfo): RedeemVoucherInfo {
        redeemVoucherEvent.invoke(e)
        return e
    }

    //Resurrect
    val resurrectEvent = event<ResurrectInfo>()

    fun invokeResurrectEvent(e: ResurrectInfo): ResurrectInfo {
        resurrectEvent.invoke(e)
        return e
    }

    //CommunityGoalJoin
    val communityGoalJoinEvent = event<CommunityGoalJoinInfo>()

    fun invokeCommunityGoalJoinEvent(e: CommunityGoalJoinInfo): CommunityGoalJoinInfo {
        communityGoalJoinEvent.invoke(e)
        return e
    }

    //CommunityGoal
    val communityGoalEvent = event<CommunityGoalInfo>()

    fun invokeCommunityGoalEvent(e: CommunityGoalInfo): CommunityGoalInfo {
        communityGoalEvent.invoke(e)
        return e
    }

    //RepairDrone
    val repairDroneEvent = event<RepairDroneInfo>()

    fun invokeRepairDroneEvent(e: RepairDroneInfo): RepairDroneInfo {
        repairDroneEvent.invoke(e)
        return e
    }

    //Repair
    val repairEvent = event<RepairInfo>()

    fun invokeRepairEvent(e: RepairInfo): RepairInfo {
        repairEvent.invoke(e)
        return e
    }

    //JetConeDamage
    val jetConeDamageEvent = event<JetConeDamageInfo>()

    fun invokeJetConeDamageEvent(e: JetConeDamageInfo): JetConeDamageInfo {
        jetConeDamageEvent.invoke(e)
        return e
    }

    //CommunityGoalDiscard
    val communityGoalDiscardEvent = event<CommunityGoalDiscardInfo>()

    fun invokeCommunityGoalDiscardEvent(e: CommunityGoalDiscardInfo): CommunityGoalDiscardInfo {
        communityGoalDiscardEvent.invoke(e)
        return e
    }

    //MissionAccepted
    val missionAcceptedEvent = event<MissionAcceptedInfo>()

    fun invokeMissionAcceptedEvent(e: MissionAcceptedInfo): MissionAcceptedInfo {
        missionAcceptedEvent.invoke(e)
        return e
    }

    //BuyExplorationData
    val buyExplorationDataEvent = event<BuyExplorationDataInfo>()

    fun invokeBuyExplorationDataEvent(e: BuyExplorationDataInfo): BuyExplorationDataInfo {
        buyExplorationDataEvent.invoke(e)
        return e
    }

    //RepairAll
    val repairAllEvent = event<RepairAllInfo>()

    fun invokeRepairAllEvent(e: RepairAllInfo): RepairAllInfo {
        repairAllEvent.invoke(e)
        return e
    }

    //CrewLaunchFighter
    val crewLaunchFighterEvent = event<CrewLaunchFighterInfo>()

    fun invokeCrewLaunchFighterEvent(e: CrewLaunchFighterInfo): CrewLaunchFighterInfo {
        crewLaunchFighterEvent.invoke(e)
        return e
    }

    //MaterialDiscarded
    val materialDiscardedEvent = event<MaterialDiscardedInfo>()

    fun invokeMaterialDiscardedEvent(e: MaterialDiscardedInfo): MaterialDiscardedInfo {
        materialDiscardedEvent.invoke(e)
        return e
    }

    //NewCommander
    val newCommanderEvent = event<NewCommanderInfo>()

    fun invokeNewCommanderEvent(e: NewCommanderInfo): NewCommanderInfo {
        newCommanderEvent.invoke(e)
        return e
    }

    //CommunityGoalReward
    val communityGoalRewardEvent = event<CommunityGoalRewardInfo>()

    fun invokeCommunityGoalRewardEvent(e: CommunityGoalRewardInfo): CommunityGoalRewardInfo {
        communityGoalRewardEvent.invoke(e)
        return e
    }

    //PowerplayVote
    val powerplayVoteEvent = event<PowerplayVoteInfo>()

    fun invokePowerplayVoteEvent(e: PowerplayVoteInfo): PowerplayVoteInfo {
        powerplayVoteEvent.invoke(e)
        return e
    }

    //PowerplayJoin
    val powerplayJoinEvent = event<PowerplayJoinInfo>()

    fun invokePowerplayJoinEvent(e: PowerplayJoinInfo): PowerplayJoinInfo {
        powerplayJoinEvent.invoke(e)
        return e
    }

    //PowerplayDefect
    val powerplayDefectEvent = event<PowerplayDefectInfo>()

    fun invokePowerplayDefectEvent(e: PowerplayDefectInfo): PowerplayDefectInfo {
        powerplayDefectEvent.invoke(e)
        return e
    }

    //MissionFailed
    val missionFailedEvent = event<MissionFailedInfo>()

    fun invokeMissionFailedEvent(e: MissionFailedInfo): MissionFailedInfo {
        missionFailedEvent.invoke(e)
        return e
    }

    //MissionRedirected
    val missionRedirectedEvent = event<MissionRedirectedInfo>()

    fun invokeMissionRedirectedEvent(e: MissionRedirectedInfo): MissionRedirectedInfo {
        missionRedirectedEvent.invoke(e)
        return e
    }

    //Shutdown
    val shutdownEvent = event<ShutdownInfo>()

    fun invokeShutdownEvent(e: ShutdownInfo): ShutdownInfo {
        shutdownEvent.invoke(e)
        return e
    }

    //ModuleInfo
    val moduleInfoEvent = event<ModuleInfoInfo>()

    fun invokeModuleInfoEvent(e: ModuleInfoInfo): ModuleInfoInfo {
        moduleInfoEvent.invoke(e)
        return e
    }

    //Market
    val marketEvent = event<MarketInfo>()

    fun invokeMarketEvent(e: MarketInfo): MarketInfo {
        marketEvent.invoke(e)
        return e
    }

    //MassModuleStore
    val massModuleStoreEvent = event<MassModuleStoreInfo>()

    fun invokeMassModuleStoreEvent(e: MassModuleStoreInfo): MassModuleStoreInfo {
        massModuleStoreEvent.invoke(e)
        return e
    }

    //MaterialDiscovered
    val materialDiscoveredEvent = event<MaterialDiscoveredInfo>()

    fun invokeMaterialDiscoveredEvent(e: MaterialDiscoveredInfo): MaterialDiscoveredInfo {
        materialDiscoveredEvent.invoke(e)
        return e
    }

    //MaterialCollected
    val materialCollectedEvent = event<MaterialCollectedInfo>()

    fun invokeMaterialCollectedEvent(e: MaterialCollectedInfo): MaterialCollectedInfo {
        materialCollectedEvent.invoke(e)
        return e
    }

    //SRVDestroyed
    val sRVDestroyedEvent = event<SRVDestroyedInfo>()

    fun invokeSRVDestroyedEvent(e: SRVDestroyedInfo): SRVDestroyedInfo {
        sRVDestroyedEvent.invoke(e)
        return e
    }

    //DockingDenied
    val dockingDeniedEvent = event<DockingDeniedInfo>()

    fun invokeDockingDeniedEvent(e: DockingDeniedInfo): DockingDeniedInfo {
        dockingDeniedEvent.invoke(e)
        return e
    }

    //UnderAttack
    val underAttackEvent = event<UnderAttackInfo>()

    fun invokeUnderAttackEvent(e: UnderAttackInfo): UnderAttackInfo {
        underAttackEvent.invoke(e)
        return e
    }

    //ShipTargeted
    val shipTargetedEvent = event<ShipTargetedInfo>()

    fun invokeShipTargetedEvent(e: ShipTargetedInfo): ShipTargetedInfo {
        shipTargetedEvent.invoke(e)
        return e
    }

    //Shipyard
    val shipyardEvent = event<ShipyardInfo>()

    fun invokeShipyardEvent(e: ShipyardInfo): ShipyardInfo {
        shipyardEvent.invoke(e)
        return e
    }

    //Outfitting
    val outfittingEvent = event<OutfittingInfo>()

    fun invokeOutfittingEvent(e: OutfittingInfo): OutfittingInfo {
        outfittingEvent.invoke(e)
        return e
    }

    //PowerplayFastTrack
    val powerplayFastTrackEvent = event<PowerplayFastTrackInfo>()

    fun invokePowerplayFastTrackEvent(e: PowerplayFastTrackInfo): PowerplayFastTrackInfo {
        powerplayFastTrackEvent.invoke(e)
        return e
    }

    //Powerplay
    val powerplayEvent = event<PowerplayInfo>()

    fun invokePowerplayEvent(e: PowerplayInfo): PowerplayInfo {
        powerplayEvent.invoke(e)
        return e
    }

    //CollectCargo
    val collectCargoEvent = event<CollectCargoInfo>()

    fun invokeCollectCargoEvent(e: CollectCargoInfo): CollectCargoInfo {
        collectCargoEvent.invoke(e)
        return e
    }

    //FetchRemoteModule
    val fetchRemoteModuleEvent = event<FetchRemoteModuleInfo>()

    fun invokeFetchRemoteModuleEvent(e: FetchRemoteModuleInfo): FetchRemoteModuleInfo {
        fetchRemoteModuleEvent.invoke(e)
        return e
    }

    //ModuleStore
    val moduleStoreEvent = event<ModuleStoreInfo>()

    fun invokeModuleStoreEvent(e: ModuleStoreInfo): ModuleStoreInfo {
        moduleStoreEvent.invoke(e)
        return e
    }

    //ShipyardBuy
    val shipyardBuyEvent = event<ShipyardBuyInfo>()

    fun invokeShipyardBuyEvent(e: ShipyardBuyInfo): ShipyardBuyInfo {
        shipyardBuyEvent.invoke(e)
        return e
    }

    //ShipyardNew
    val shipyardNewEvent = event<ShipyardNewInfo>()

    fun invokeShipyardNewEvent(e: ShipyardNewInfo): ShipyardNewInfo {
        shipyardNewEvent.invoke(e)
        return e
    }

    //ModuleBuy
    val moduleBuyEvent = event<ModuleBuyInfo>()

    fun invokeModuleBuyEvent(e: ModuleBuyInfo): ModuleBuyInfo {
        moduleBuyEvent.invoke(e)
        return e
    }

    //ModuleRetrieve
    val moduleRetrieveEvent = event<ModuleRetrieveInfo>()

    fun invokeModuleRetrieveEvent(e: ModuleRetrieveInfo): ModuleRetrieveInfo {
        moduleRetrieveEvent.invoke(e)
        return e
    }

    //AfmuRepairs
    val afmuRepairsEvent = event<AfmuRepairsInfo>()

    fun invokeAfmuRepairsEvent(e: AfmuRepairsInfo): AfmuRepairsInfo {
        afmuRepairsEvent.invoke(e)
        return e
    }

    //LaunchDrone
    val launchDroneEvent = event<LaunchDroneInfo>()

    fun invokeLaunchDroneEvent(e: LaunchDroneInfo): LaunchDroneInfo {
        launchDroneEvent.invoke(e)
        return e
    }

    //MarketSell
    val marketSellEvent = event<MarketSellInfo>()

    fun invokeMarketSellEvent(e: MarketSellInfo): MarketSellInfo {
        marketSellEvent.invoke(e)
        return e
    }

    //ModuleSell
    val moduleSellEvent = event<ModuleSellInfo>()

    fun invokeModuleSellEvent(e: ModuleSellInfo): ModuleSellInfo {
        moduleSellEvent.invoke(e)
        return e
    }

    //FuelScoop
    val fuelScoopEvent = event<FuelScoopInfo>()

    fun invokeFuelScoopEvent(e: FuelScoopInfo): FuelScoopInfo {
        fuelScoopEvent.invoke(e)
        return e
    }

    //FighterDestroyed
    val fighterDestroyedEvent = event<FighterDestroyedInfo>()

    fun invokeFighterDestroyedEvent(e: FighterDestroyedInfo): FighterDestroyedInfo {
        fighterDestroyedEvent.invoke(e)
        return e
    }

    //DiscoveryScan
    val discoveryScanEvent = event<DiscoveryScanInfo>()

    fun invokeDiscoveryScanEvent(e: DiscoveryScanInfo): DiscoveryScanInfo {
        discoveryScanEvent.invoke(e)
        return e
    }

    //LeaveBody
    val leaveBodyEvent = event<LeaveBodyInfo>()

    fun invokeLeaveBodyEvent(e: LeaveBodyInfo): LeaveBodyInfo {
        leaveBodyEvent.invoke(e)
        return e
    }

    //PowerplayVoucher
    val powerplayVoucherEvent = event<PowerplayVoucherInfo>()

    fun invokePowerplayVoucherEvent(e: PowerplayVoucherInfo): PowerplayVoucherInfo {
        powerplayVoucherEvent.invoke(e)
        return e
    }

    //Reputation
    val reputationEvent = event<ReputationInfo>()

    fun invokeReputationEvent(e: ReputationInfo): ReputationInfo {
        reputationEvent.invoke(e)
        return e
    }

    //NavBeaconScan
    val navBeaconScanEvent = event<NavBeaconScanInfo>()

    fun invokeNavBeaconScanEvent(e: NavBeaconScanInfo): NavBeaconScanInfo {
        navBeaconScanEvent.invoke(e)
        return e
    }

    //Missions
    val missionsEvent = event<MissionsInfo>()

    fun invokeMissionsEvent(e: MissionsInfo): MissionsInfo {
        missionsEvent.invoke(e)
        return e
    }

    //Friends
    val friendsEvent = event<FriendsInfo>()

    fun invokeFriendsEvent(e: FriendsInfo): FriendsInfo {
        friendsEvent.invoke(e)
        return e
    }

    //ShipyardSell
    val shipyardSellEvent = event<ShipyardSellInfo>()

    fun invokeShipyardSellEvent(e: ShipyardSellInfo): ShipyardSellInfo {
        shipyardSellEvent.invoke(e)
        return e
    }

    //MissionAbandoned
    val missionAbandonedEvent = event<MissionAbandonedInfo>()

    fun invokeMissionAbandonedEvent(e: MissionAbandonedInfo): MissionAbandonedInfo {
        missionAbandonedEvent.invoke(e)
        return e
    }

    //ScientificResearch
    val scientificResearchEvent = event<ScientificResearchInfo>()

    fun invokeScientificResearchEvent(e: ScientificResearchInfo): ScientificResearchInfo {
        scientificResearchEvent.invoke(e)
        return e
    }

    //DockingTimeout
    val dockingTimeoutEvent = event<DockingTimeoutInfo>()

    fun invokeDockingTimeoutEvent(e: DockingTimeoutInfo): DockingTimeoutInfo {
        dockingTimeoutEvent.invoke(e)
        return e
    }

    //DockingCancelled
    val dockingCancelledEvent = event<DockingCancelledInfo>()

    fun invokeDockingCancelledEvent(e: DockingCancelledInfo): DockingCancelledInfo {
        dockingCancelledEvent.invoke(e)
        return e
    }

    //DockingRequested
    val dockingRequestedEvent = event<DockingRequestedInfo>()

    fun invokeDockingRequestedEvent(e: DockingRequestedInfo): DockingRequestedInfo {
        dockingRequestedEvent.invoke(e)
        return e
    }

    //DockingGranted
    val dockingGrantedEvent = event<DockingGrantedInfo>()

    fun invokeDockingGrantedEvent(e: DockingGrantedInfo): DockingGrantedInfo {
        dockingGrantedEvent.invoke(e)
        return e
    }

    //Undocked
    val undockedEvent = event<UndockedInfo>()

    fun invokeUndockedEvent(e: UndockedInfo): UndockedInfo {
        undockedEvent.invoke(e)
        return e
    }

    //CrewHire
    val crewHireEvent = event<CrewHireInfo>()

    fun invokeCrewHireEvent(e: CrewHireInfo): CrewHireInfo {
        crewHireEvent.invoke(e)
        return e
    }

    //Screenshot
    val screenshotEvent = event<ScreenshotInfo>()

    fun invokeScreenshotEvent(e: ScreenshotInfo): ScreenshotInfo {
        screenshotEvent.invoke(e)
        return e
    }

    //Synthesis
    val synthesisEvent = event<SynthesisInfo>()

    fun invokeSynthesisEvent(e: SynthesisInfo): SynthesisInfo {
        synthesisEvent.invoke(e)
        return e
    }

    //FighterRebuilt
    val fighterRebuiltEvent = event<FighterRebuiltInfo>()

    fun invokeFighterRebuiltEvent(e: FighterRebuiltInfo): FighterRebuiltInfo {
        fighterRebuiltEvent.invoke(e)
        return e
    }

    //SellExplorationData
    val sellExplorationDataEvent = event<SellExplorationDataInfo>()

    fun invokeSellExplorationDataEvent(e: SellExplorationDataInfo): SellExplorationDataInfo {
        sellExplorationDataEvent.invoke(e)
        return e
    }

    //RebootRepair
    val rebootRepairEvent = event<RebootRepairInfo>()

    fun invokeRebootRepairEvent(e: RebootRepairInfo): RebootRepairInfo {
        rebootRepairEvent.invoke(e)
        return e
    }

    //Scan
    val scanEvent = event<ScanInfo>()

    fun invokeScanEvent(e: ScanInfo): ScanInfo {
        scanEvent.invoke(e)
        return e
    }

    //WingInvite
    val wingInviteEvent = event<WingInviteInfo>()

    fun invokeWingInviteEvent(e: WingInviteInfo): WingInviteInfo {
        wingInviteEvent.invoke(e)
        return e
    }

    //StartJump
    val startJumpEvent = event<StartJumpInfo>()

    fun invokeStartJumpEvent(e: StartJumpInfo): StartJumpInfo {
        startJumpEvent.invoke(e)
        return e
    }

    //SupercruiseExit
    val supercruiseExitEvent = event<SupercruiseExitInfo>()

    fun invokeSupercruiseExitEvent(e: SupercruiseExitInfo): SupercruiseExitInfo {
        supercruiseExitEvent.invoke(e)
        return e
    }

    //PayBounties
    val payBountiesEvent = event<PayBountiesInfo>()

    fun invokePayBountiesEvent(e: PayBountiesInfo): PayBountiesInfo {
        payBountiesEvent.invoke(e)
        return e
    }

    //PowerplaySalary
    val powerplaySalaryEvent = event<PowerplaySalaryInfo>()

    fun invokePowerplaySalaryEvent(e: PowerplaySalaryInfo): PowerplaySalaryInfo {
        powerplaySalaryEvent.invoke(e)
        return e
    }

    //ShipyardTransfer
    val shipyardTransferEvent = event<ShipyardTransferInfo>()

    fun invokeShipyardTransferEvent(e: ShipyardTransferInfo): ShipyardTransferInfo {
        shipyardTransferEvent.invoke(e)
        return e
    }

    //TechnologyBroker
    val technologyBrokerEvent = event<TechnologyBrokerInfo>()

    fun invokeTechnologyBrokerEvent(e: TechnologyBrokerInfo): TechnologyBrokerInfo {
        technologyBrokerEvent.invoke(e)
        return e
    }

    //PayFines
    val payFinesEvent = event<PayFinesInfo>()

    fun invokePayFinesEvent(e: PayFinesInfo): PayFinesInfo {
        payFinesEvent.invoke(e)
        return e
    }

    //Bounty
    val bountyEvent = event<BountyInfo>()

    fun invokeBountyEvent(e: BountyInfo): BountyInfo {
        bountyEvent.invoke(e)
        return e
    }

    //MaterialTrade
    val materialTradeEvent = event<MaterialTradeInfo>()

    fun invokeMaterialTradeEvent(e: MaterialTradeInfo): MaterialTradeInfo {
        materialTradeEvent.invoke(e)
        return e
    }

    //ReceiveText
    val receiveTextEvent = event<ReceiveTextInfo>()

    fun invokeReceiveTextEvent(e: ReceiveTextInfo): ReceiveTextInfo {
        receiveTextEvent.invoke(e)
        return e
    }

    //ModuleSellRemote
    val moduleSellRemoteEvent = event<ModuleSellRemoteInfo>()

    fun invokeModuleSellRemoteEvent(e: ModuleSellRemoteInfo): ModuleSellRemoteInfo {
        moduleSellRemoteEvent.invoke(e)
        return e
    }

    //ShipyardSwap
    val shipyardSwapEvent = event<ShipyardSwapInfo>()

    fun invokeShipyardSwapEvent(e: ShipyardSwapInfo): ShipyardSwapInfo {
        shipyardSwapEvent.invoke(e)
        return e
    }

    //MarketBuy
    val marketBuyEvent = event<MarketBuyInfo>()

    fun invokeMarketBuyEvent(e: MarketBuyInfo): MarketBuyInfo {
        marketBuyEvent.invoke(e)
        return e
    }

    //CargoDepot
    val cargoDepotEvent = event<CargoDepotInfo>()

    fun invokeCargoDepotEvent(e: CargoDepotInfo): CargoDepotInfo {
        cargoDepotEvent.invoke(e)
        return e
    }

    //KillBond
    val factionKillBondEvent = event<FactionKillBondInfo>()

    fun invokeFactionKillBondEvent(e: FactionKillBondInfo): FactionKillBondInfo {
        factionKillBondEvent.invoke(e)
        return e
    }

    //StoredModules
    val storedModulesEvent = event<StoredModulesInfo>()

    fun invokeStoredModulesEvent(e: StoredModulesInfo): StoredModulesInfo {
        storedModulesEvent.invoke(e)
        return e
    }

    //WingJoin
    val wingJoinEvent = event<WingJoinInfo>()

    fun invokeWingJoinEvent(e: WingJoinInfo): WingJoinInfo {
        wingJoinEvent.invoke(e)
        return e
    }

    //ApproachBody
    val approachBodyEvent = event<ApproachBodyInfo>()

    fun invokeApproachBodyEvent(e: ApproachBodyInfo): ApproachBodyInfo {
        approachBodyEvent.invoke(e)
        return e
    }

    //EngineerProgress
    val engineerProgressEvent = event<EngineerProgressInfo>()

    fun invokeEngineerProgressEvent(e: EngineerProgressInfo): EngineerProgressInfo {
        engineerProgressEvent.invoke(e)
        return e
    }

    //FSSDiscoveryScan
    val fSSDiscoveryScanEvent = event<FSSDiscoveryScanInfo>()

    fun invokeFSSDiscoveryScanEvent(e: FSSDiscoveryScanInfo): FSSDiscoveryScanInfo {
        fSSDiscoveryScanEvent.invoke(e)
        return e
    }

    //SquadronCreated
    val squadronCreatedEvent = event<SquadronCreatedInfo>()

    fun invokeSquadronCreatedEvent(e: SquadronCreatedInfo): SquadronCreatedInfo {
        squadronCreatedEvent.invoke(e)
        return e
    }

    //Commander
    val commanderEvent = event<CommanderInfo>()

    fun invokeCommanderEvent(e: CommanderInfo): CommanderInfo {
        commanderEvent.invoke(e)
        return e
    }

    //JoinedSquadron
    val joinedSquadronEvent = event<JoinedSquadronInfo>()

    fun invokeJoinedSquadronEvent(e: JoinedSquadronInfo): JoinedSquadronInfo {
        joinedSquadronEvent.invoke(e)
        return e
    }

    //EjectCargo
    val ejectCargoEvent = event<EjectCargoInfo>()

    fun invokeEjectCargoEvent(e: EjectCargoInfo): EjectCargoInfo {
        ejectCargoEvent.invoke(e)
        return e
    }

    //NpcCrewPaidWage
    val npcCrewPaidWageEvent = event<NpcCrewPaidWageInfo>()

    fun invokeNpcCrewPaidWageEvent(e: NpcCrewPaidWageInfo): NpcCrewPaidWageInfo {
        npcCrewPaidWageEvent.invoke(e)
        return e
    }

    //Materials
    val materialsEvent = event<MaterialsInfo>()

    fun invokeMaterialsEvent(e: MaterialsInfo): MaterialsInfo {
        materialsEvent.invoke(e)
        return e
    }

    //LoadGame
    val loadGameEvent = event<LoadGameInfo>()

    fun invokeLoadGameEvent(e: LoadGameInfo): LoadGameInfo {
        loadGameEvent.invoke(e)
        return e
    }

    //SupercruiseEntry
    val supercruiseEntryEvent = event<SupercruiseEntryInfo>()

    fun invokeSupercruiseEntryEvent(e: SupercruiseEntryInfo): SupercruiseEntryInfo {
        supercruiseEntryEvent.invoke(e)
        return e
    }

    //FSDTarget
    val fSDTargetEvent = event<FSDTargetInfo>()

    fun invokeFSDTargetEvent(e: FSDTargetInfo): FSDTargetInfo {
        fSDTargetEvent.invoke(e)
        return e
    }

    //FSSAllBodiesFound
    val fSSAllBodiesFoundEvent = event<FSSAllBodiesFoundInfo>()

    fun invokeFSSAllBodiesFoundEvent(e: FSSAllBodiesFoundInfo): FSSAllBodiesFoundInfo {
        fSSAllBodiesFoundEvent.invoke(e)
        return e
    }

    //SAAScanComplete
    val sAAScanCompleteEvent = event<SAAScanCompleteInfo>()

    fun invokeSAAScanCompleteEvent(e: SAAScanCompleteInfo): SAAScanCompleteInfo {
        sAAScanCompleteEvent.invoke(e)
        return e
    }

    //CodexEntry
    val codexEntryEvent = event<CodexEntryInfo>()

    fun invokeCodexEntryEvent(e: CodexEntryInfo): CodexEntryInfo {
        codexEntryEvent.invoke(e)
        return e
    }

    //CrimeVictim
    val crimeVictimEvent = event<CrimeVictimInfo>()

    fun invokeCrimeVictimEvent(e: CrimeVictimInfo): CrimeVictimInfo {
        crimeVictimEvent.invoke(e)
        return e
    }

    //Loadout
    val loadoutEvent = event<LoadoutInfo>()

    fun invokeLoadoutEvent(e: LoadoutInfo): LoadoutInfo {
        loadoutEvent.invoke(e)
        return e
    }

    //MissionCompleted
    val missionCompletedEvent = event<MissionCompletedInfo>()

    fun invokeMissionCompletedEvent(e: MissionCompletedInfo): MissionCompletedInfo {
        missionCompletedEvent.invoke(e)
        return e
    }

    //BuyTradeData
    val buyTradeDataEvent = event<BuyTradeDataInfo>()

    fun invokeBuyTradeDataEvent(e: BuyTradeDataInfo): BuyTradeDataInfo {
        buyTradeDataEvent.invoke(e)
        return e
    }

    //CrewAssign
    val crewAssignEvent = event<CrewAssignInfo>()

    fun invokeCrewAssignEvent(e: CrewAssignInfo): CrewAssignInfo {
        crewAssignEvent.invoke(e)
        return e
    }

    //CrewFire
    val crewFireEvent = event<CrewFireInfo>()

    fun invokeCrewFireEvent(e: CrewFireInfo): CrewFireInfo {
        crewFireEvent.invoke(e)
        return e
    }

    //MultiSellExplorationData
    val multiSellExplorationDataEvent = event<MultiSellExplorationDataInfo>()

    fun invokeMultiSellExplorationDataEvent(e: MultiSellExplorationDataInfo): MultiSellExplorationDataInfo {
        multiSellExplorationDataEvent.invoke(e)
        return e
    }

    //Location
    val locationEvent = event<LocationInfo>()

    fun invokeLocationEvent(e: LocationInfo): LocationInfo {
        locationEvent.invoke(e)
        return e
    }

    //AsteroidCracked
    val asteroidCrackedEvent = event<AsteroidCrackedInfo>()

    fun invokeAsteroidCrackedEvent(e: AsteroidCrackedInfo): AsteroidCrackedInfo {
        asteroidCrackedEvent.invoke(e)
        return e
    }

    //ModuleSwap
    val moduleSwapEvent = event<ModuleSwapInfo>()

    fun invokeModuleSwapEvent(e: ModuleSwapInfo): ModuleSwapInfo {
        moduleSwapEvent.invoke(e)
        return e
    }

    //DataScanned
    val dataScannedEvent = event<DataScannedInfo>()

    fun invokeDataScannedEvent(e: DataScannedInfo): DataScannedInfo {
        dataScannedEvent.invoke(e)
        return e
    }

    //DisbandedSquadron
    val disbandedSquadronEvent = event<DisbandedSquadronInfo>()

    fun invokeDisbandedSquadronEvent(e: DisbandedSquadronInfo): DisbandedSquadronInfo {
        disbandedSquadronEvent.invoke(e)
        return e
    }

    //AppliedToSquadron
    val appliedToSquadronEvent = event<AppliedToSquadronInfo>()

    fun invokeAppliedToSquadronEvent(e: AppliedToSquadronInfo): AppliedToSquadronInfo {
        appliedToSquadronEvent.invoke(e)
        return e
    }

    //Docked
    val dockedEvent = event<DockedInfo>()

    fun invokeDockedEvent(e: DockedInfo): DockedInfo {
        dockedEvent.invoke(e)
        return e
    }

    //Statistics
    val statisticsEvent = event<StatisticsInfo>()

    fun invokeStatisticsEvent(e: StatisticsInfo): StatisticsInfo {
        statisticsEvent.invoke(e)
        return e
    }

    //SetUserShipName
    val setUserShipNameEvent = event<SetUserShipNameInfo>()

    fun invokeSetUserShipNameEvent(e: SetUserShipNameInfo): SetUserShipNameInfo {
        setUserShipNameEvent.invoke(e)
        return e
    }

    //FSDJump
    val fSDJumpEvent = event<FSDJumpInfo>()

    fun invokeFSDJumpEvent(e: FSDJumpInfo): FSDJumpInfo {
        fSDJumpEvent.invoke(e)
        return e
    }

    //Cargo
    val cargoEvent = event<CargoInfo>()

    fun invokeCargoEvent(e: CargoInfo): CargoInfo {
        cargoEvent.invoke(e)
        return e
    }

    //EngineerCraft
    val engineerCraftEvent = event<EngineerCraftInfo>()

    fun invokeEngineerCraftEvent(e: EngineerCraftInfo): EngineerCraftInfo {
        engineerCraftEvent.invoke(e)
        return e
    }

    //ApproachSettlement
    val approachSettlementEvent = event<ApproachSettlementInfo>()

    fun invokeApproachSettlementEvent(e: ApproachSettlementInfo): ApproachSettlementInfo {
        approachSettlementEvent.invoke(e)
        return e
    }

    //StoredShips
    val storedShipsEvent = event<StoredShipsInfo>()

    fun invokeStoredShipsEvent(e: StoredShipsInfo): StoredShipsInfo {
        storedShipsEvent.invoke(e)
        return e
    }

    //FSSSignalDiscovered
    val fSSSignalDiscoveredEvent = event<FSSSignalDiscoveredInfo>()

    fun invokeFSSSignalDiscoveredEvent(e: FSSSignalDiscoveredInfo): FSSSignalDiscoveredInfo {
        fSSSignalDiscoveredEvent.invoke(e)
        return e
    }

    //SquadronStartup
    val squadronStartupEvent = event<SquadronStartupInfo>()

    fun invokeSquadronStartupEvent(e: SquadronStartupInfo): SquadronStartupInfo {
        squadronStartupEvent.invoke(e)
        return e
    }

}