package Demos;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import DotaData.HeroMapping;
import GameInfo.BarracksStatusAnalyzer;
import GameInfo.GameData;
import GameInfo.GameData.PicksAndBans;
import GameInfo.TowerStatusAnalyzer;
import GameTracker.IO;
import WebAPI.API;

public class DemoMatchData {

	/**
	 * 
	 * @param matchId
	 * @throws IOException
	 * @throws ParseException
	 */
	public DemoMatchData(String matchId) throws IOException, ParseException {
		GameData data = API.getMatchDetails(matchId);
		HeroMapping heroMap = API.getHeroMapping();

		// Game Data
		IO.log("Lobby ID: " + data.getMatchID());
		IO.log("Lobby Type: " + data.getLobbyType());
		IO.log("Game Mode: " + data.getGameMode());
		IO.log("Number Of Human Players: " + data.getNumHumanPlayers());
		IO.log("Number of Positive Votes: " + data.getPosVotes());
		IO.log("Number of Negative Votes: " + data.getNegVotes());
		IO.log("Dire Barracks Status: " + data.getDireBarracksStatus());
		IO.log("Dire Tower Status: " + data.getDireTowerStatus());
		IO.log("Radiant Barracks Status: " + data.getRadiantBarracksStatus());
		IO.log("Radiant Tower Status: " + data.getRadiantTowerStatus());
		IO.log("First Blood Time: " + data.getFirstBloodTime());
		IO.log("Did Radiant Win?: " + data.isRadiantWinner());
		IO.log("Match Length: " + data.getMatchDurationStr());

		IO.logLineBreak();
		IO.log("Dire Team");
		BarracksStatusAnalyzer barracks = new BarracksStatusAnalyzer(data.getDireBarracksStatus());
		IO.log("Bot Meele: " + barracks.getBottomMeele());
		IO.log("Bot Ranged: " + barracks.getBottomRanged());
		IO.log("Mid Meele: " + barracks.getMiddleMeele());
		IO.log("Mid Ranged: " + barracks.getMiddleRanged());
		IO.log("Top Meele: " + barracks.getTopMeele());
		IO.log("Top Ranged: " + barracks.getTopRanged());

		IO.logLineBreak();
		TowerStatusAnalyzer towers = new TowerStatusAnalyzer(data.getDireTowerStatus());
		IO.log("Ancient Bot: " + towers.getAncientBot());
		IO.log("Ancient Top: " + towers.getAncientTop());
		IO.log("Bot T1: " + towers.getBotT1Top());
		IO.log("Bot T2: " + towers.getBotT2Top());
		IO.log("Bot T3: " + towers.getBotT3Top());
		IO.log("Mid T1: " + towers.getMidT1Top());
		IO.log("Mid T2: " + towers.getMidT2Top());
		IO.log("Mid T3: " + towers.getMidT3Top());
		IO.log("Top T1: " + towers.getTopT1Top());
		IO.log("Top T2: " + towers.getTopT2Top());
		IO.log("Top T3: " + towers.getTopT3Top());

		IO.logLineBreak();
		IO.log("Radiant Team");
		barracks = new BarracksStatusAnalyzer(data.getRadiantBarracksStatus());
		IO.log("Bot Meele: " + barracks.getBottomMeele());
		IO.log("Bot Ranged: " + barracks.getBottomRanged());
		IO.log("Mid Meele: " + barracks.getMiddleMeele());
		IO.log("Mid Ranged: " + barracks.getMiddleRanged());
		IO.log("Top Meele: " + barracks.getTopMeele());
		IO.log("Top Ranged: " + barracks.getTopRanged());

		IO.logLineBreak();
		towers = new TowerStatusAnalyzer(data.getRadiantTowerStatus());
		IO.log("Ancient Bot: " + towers.getAncientBot());
		IO.log("Ancient Top: " + towers.getAncientTop());
		IO.log("Bot T1: " + towers.getBotT1Top());
		IO.log("Bot T2: " + towers.getBotT2Top());
		IO.log("Bot T3: " + towers.getBotT3Top());
		IO.log("Mid T1: " + towers.getMidT1Top());
		IO.log("Mid T2: " + towers.getMidT2Top());
		IO.log("Mid T3: " + towers.getMidT3Top());
		IO.log("Top T1: " + towers.getTopT1Top());
		IO.log("Top T2: " + towers.getTopT2Top());
		IO.log("Top T3: " + towers.getTopT3Top());

		IO.logLineBreak();
		if(data.hasPicksAndBans()) {
			IO.log("Dire Team Captain:" + data.getDireTeamCaptain());
			IO.log("Radiant Team Captain: " + data.getRadiantTeamCaptain());

			for(PicksAndBans pick : data.getPicksAndBans()) {
				String message = (pick.getTeam() == GameData.DIRE_TEAM ? "Dire" : "Radiant")  +
						"\t" + (pick.isPick() ? "Pick" : "Ban") + "\t" + "Hero: " + heroMap.getHeroName(pick.getHeroID());
				IO.log(message);
			}
		}
	}

}
