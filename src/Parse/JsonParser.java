package Parse;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import DotaData.AbilityMapping;
import DotaData.HeroMapping;
import DotaData.ItemMapping;
import GameInfo.Ability;
import GameInfo.ControlledUnits;
import GameInfo.GameData;
import GameInfo.PlayerDataExtended;
import GameTracker.IO;
import Matches.Match;
import Matches.MatchHistory;

public class JsonParser {

	public static AbilityMapping parseAbilities(String json) throws ParseException {
		JSONParser parser   = new JSONParser();
		JSONObject obj      = (JSONObject) parser.parse(json);
		JSONArray abilities = (JSONArray) obj.get("abilities");
		
		Iterator<JSONObject> iter = abilities.iterator();
		AbilityMapping abilityMap = new AbilityMapping();
		while(iter.hasNext()) {
			JSONObject ability = iter.next();
			
			int abilityID = Integer.parseInt((String) ability.get("id"));
			String abilityName = (String) ability.get("name");
			
			abilityMap.addMapping(abilityID, abilityName);
		}
		
		return abilityMap;
	}
	
	public static ItemMapping parseItems(String json) throws ParseException {
		JSONParser parser   = new JSONParser();
		JSONObject obj      = (JSONObject) parser.parse(json);
		JSONArray items = (JSONArray) obj.get("items");
		
		Iterator<JSONObject> iter = items.iterator();
		ItemMapping itemMap = new ItemMapping();
		while(iter.hasNext()) {
			JSONObject item = iter.next();
			
			int itemID      = (int) (long) item.get("id");
			String itemName = (String) item.get("name");
			
			itemMap.addMapping(itemID, itemName);
		}
		
		return itemMap;
	}

	public static HeroMapping parseHeroes(String json) throws ParseException {
		// TODO: Check for failure
		JSONParser parser = new JSONParser();
		JSONObject obj    = (JSONObject) parser.parse(json);
		JSONObject inner  = (JSONObject) obj.get("result");

		JSONArray heroes  = (JSONArray) inner.get("heroes");
		Iterator<JSONObject> iter = heroes.iterator();

		HeroMapping heroMap = new HeroMapping();

		while(iter.hasNext()) {
			JSONObject heroData = iter.next();

			int heroID      = (int) (long) heroData.get("id");
			String heroName = (String) heroData.get("name");

			heroMap.addMapping(heroID, heroName);
		}

		return heroMap;
	}

	public static String parseVanityURL(String json) throws ParseException {
		// TODO: Check for failure
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(json);
		return (String) ((JSONObject) (obj.get("response"))).get("steamid");
	}

	public static MatchHistory parseMatchHistory(String json) throws ParseException {
		// TODO: Check for failure

		JSONParser parser = new JSONParser();
		JSONObject obj    = (JSONObject) parser.parse(json);
		JSONObject inner  = (JSONObject) obj.get("result");

		long numResults       = (long) inner.get("num_results");
		long totalResults     = (long) inner.get("total_results");
		long remainingResults = (long) inner.get("results_remaining");

		JSONArray matches  = (JSONArray) inner.get("matches");
		Iterator<JSONObject> iter = matches.iterator();

		MatchHistory matchHistory = new MatchHistory(numResults, totalResults, remainingResults);

		while(iter.hasNext()) {
			JSONObject match = iter.next();

			long matchID      = (long) match.get("match_id");
			long matchSeqNumb = (long) match.get("match_seq_num");
			long startTime    = (long) match.get("start_time");
			long lobbyType    = (long) match.get("lobby_type");

			Match m = new Match(matchID, matchSeqNumb, startTime, lobbyType);

			JSONArray players = (JSONArray) match.get("players");
			Iterator<JSONObject> iter2 = players.iterator();

			while(iter2.hasNext()) {
				JSONObject player = iter2.next();

				long account32BitId  = (long) player.get("account_id");
				long playerSlot      = (long) player.get("player_slot");
				long heroId          = (long) player.get("hero_id");

				m.addPlayer(account32BitId, playerSlot, heroId);
			}

			matchHistory.addMatch(m);
		}

		return matchHistory;
	}

	public static GameData parseMatch(String json) throws ParseException {
		// TODO: Check for failure
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(json);
		JSONObject info = (JSONObject) obj.get("result");

		String matchID =       info.get("match_id").toString();
		long lobbyType =       (long) info.get("lobby_type");
		long numHumanPlayers = (long) info.get("human_players");
		long positiveVotes =   (long) info.get("positive_votes");
		long negativeVotes =   (long) info.get("negative_votes");
		long gameMode =        (long) info.get("game_mode");

		long radiantTowerStatus =    (long) info.get("tower_status_radiant");
		long radiantBarracksStatus = (long) info.get("barracks_status_radiant");
		long direTowerStatus =       (long) info.get("tower_status_dire");
		long direBarracksStatus =    (long) info.get("barracks_status_dire");

		boolean radiantWin = true;
		long firstBloodTime = (long) info.get("first_blood_time");
		long matchDuration =  (long) info.get("duration");

		GameData data = new GameData(matchID, lobbyType, numHumanPlayers, positiveVotes, negativeVotes, gameMode);

		data.setRadiantTowerStatus(radiantTowerStatus);
		data.setRadiantBarracksStatus(radiantBarracksStatus);
		data.setDireTowerStatus(direTowerStatus);
		data.setDireBarracksStatus(direBarracksStatus);
		data.setRadiantWinner(radiantWin);
		data.setFirstBloodTime(firstBloodTime);
		data.setMatchDuration(matchDuration);

		// Iterate through each player in game
		JSONArray players = (JSONArray) info.get("players");

		if(players != null) {
			Iterator<JSONObject> iter = players.iterator();
			while(iter.hasNext()) {
				// Parse for each player
				JSONObject currentPlayer = iter.next();

				long accountID  = (long) currentPlayer.get("account_id");
				long playerSlot = (long) currentPlayer.get("player_slot");
				long heroID     = (long) currentPlayer.get("hero_id");
				PlayerDataExtended player = new PlayerDataExtended(accountID, playerSlot, heroID);

				long kills = (long) currentPlayer.get("kills");
				long deaths = (long) currentPlayer.get("deaths");
				long assists = (long) currentPlayer.get("assists");
				long gold = (long) currentPlayer.get("gold");
				long lastHits = (long) currentPlayer.get("last_hits");
				long denies = (long) currentPlayer.get("denies");
				long gpm = (long) currentPlayer.get("gold_per_min");
				long xpm = (long) currentPlayer.get("xp_per_min");
				long goldSpent = (long) currentPlayer.get("gold_spent");
				long heroDmg = (long) currentPlayer.get("hero_damage");
				long towerDmg = (long) currentPlayer.get("tower_damage");
				long heroHeal = (long) currentPlayer.get("hero_healing");
				long level = (long) currentPlayer.get("level");

				long[] items = new long[6];
				for(int i = 0; i < items.length; i++) {
					items[i] = (long) currentPlayer.get("item_" + i);
				}

				JSONArray abilitiesJson = (JSONArray) currentPlayer.get("ability_upgrades");
				ArrayList<Ability> abilities = getAbilities(abilitiesJson);

				JSONArray controledUnitsJson = (JSONArray) currentPlayer.get("additional_units");
				ArrayList<ControlledUnits> controlledUnits = getControlledUnits(controledUnitsJson);

				player.update(items, kills, deaths, assists, lastHits, denies, gold, gpm, xpm, goldSpent, heroDmg, towerDmg, heroHeal, level, abilities, controlledUnits);

				data.addPlayer(player);
			}
		}

		return data;
	}

	private static ArrayList<Ability> getAbilities(JSONArray abilities) {
		ArrayList<Ability> ret = new ArrayList<Ability>();

		Iterator<JSONObject> iter = abilities.iterator();
		while(iter.hasNext()) {
			JSONObject ability = iter.next();
			long abilityID    = (long) ability.get("ability");
			long upgradeLevel = (long) ability.get("level");
			ret.add(new Ability(abilityID, upgradeLevel));
		}

		return ret;
	}

	// TODO: Implement this feature
	private static ArrayList<ControlledUnits> getControlledUnits(JSONArray abilities) {
		return null;
	}

}
