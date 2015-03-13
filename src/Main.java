import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import DotaData.AbilityMapping;
import DotaData.HeroMapping;
import DotaData.ItemMapping;
import GameInfo.Ability;
import GameInfo.BarracksStatusAnalyzer;
import GameInfo.GameData;
import GameInfo.PlayerDataExtended;
import GameInfo.TowerStatusAnalyzer;
import GameTracker.IO;
import Matches.Match;
import Matches.MatchHistory;
import WebAPI.API;


public class Main {
	
	private static ItemMapping itemMap;
	private static AbilityMapping abilityMap;
	
	/**
	 * 
	 * Takes the last 30 matches of a user -> parses them -> outputs data on the game, tower/barracks status, player info
	 * ~20 seconds on a slow-ish computer
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException {
		// This will test the efficiency of the program
		long startTime = System.nanoTime();
		
		// Get Hero Mapping
		HeroMapping heroMap = API.getHeroMapping();
		itemMap = API.getItemMapping();
		abilityMap = API.getAbilityMapping();
		
		// Get last 30 matches
		String user32BitID = API.get32BitUName("thelevite");
		MatchHistory history = API.getMatchesByUser(user32BitID, 30);
		
		// Parse each match
		while(history.hasNextMatch()) {
			Match m = history.getNextMatch();
			
			// Get the match ID
			long matchID = m.getMatchID();
			
			// Retrieve that match and parse it
			GameData data = API.getMatchDetails(matchID);
			
			// Get ALL game data
			IO.logLineBreak();
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
			
			while(data.hasNextPlayer()) {
				PlayerDataExtended p = data.getNextPlayer();
				IO.log(p.getKills() + "/" + p.getDeaths() + "/" + p.getAssists());
				IO.log(heroMap.getHeroName((int) p.getHeroID()) + " " + p.getLevel());
				IO.log(p.getLastHits() + " : " + p.getDenies());
				IO.log(itemsToString(p.getItems()));
				IO.log(abilitiesToString(p.getAbilities()));
			}
		}
		
		IO.logLineBreak();
		IO.logLineSeperator();
		IO.logLineBreak();
		IO.log("Contacted the Steam WebAPI " + API.getTimesWebAPIhit() + " times.");
		
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		IO.log("Elapsed Time (seconds): " + ((double)elapsedTime / 1000000000.0));
	}
	
	private static String itemsToString(long[] items) {
		String ret = "";
		
		for(long i : items) {
			ret += itemMap.getItemName((int) i) + " ";
		}
		
		return ret;
	}
	
	private static String abilitiesToString(ArrayList<Ability> abilities) {
		String ret = "";
		
		for(Ability ability : abilities) {
			ret += abilityMap.getAbilityName((int) ability.getAbilityID()) + " ";
		}
		
		return ret;
	}
}
