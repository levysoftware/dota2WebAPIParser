package Demos;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import GameInfo.Ability;
import GameInfo.GameData;
import GameInfo.PlayerDataExtended;
import GameTracker.IO;
import WebAPI.API;

public class DemoMatchData {

	public static void main(String[] args) throws IOException, ParseException {
		GameData data = API.getMatchDetails("1280737746");

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
		
		// Player Data
		while(data.hasNextPlayer()) {
			PlayerDataExtended p = data.getNextPlayer();
			IO.log("\n");
			IO.log("Account ID: " + p.getAccountID());
			IO.log("Kills: " + p.getKills());
			IO.log("Deaths: " + p.getDeaths());
			IO.log("Assists: " + p.getAssists());
			IO.log("Last Hits: " + p.getLastHits());
			IO.log("Denies: " + p.getDenies());
			IO.log("Gold: " + p.getGold());
			IO.log("Gold Spent: " + p.getGoldSpent());
			IO.log("GPM: " + p.getGPM());
			IO.log("XPM: " + p.getXPM());
			IO.log("Hero Damage: " + p.getHeroDamage());
			IO.log("Hero Healing: " + p.getHeroHealing());
			IO.log("Tower Damage: " + p.getTowerDamage());
			IO.log("Hero Level: " + p.getLevel());
			IO.log("Player Slot: " + p.getPlayerSlot());
			for(long item : p.getItems()) {
				IO.log("Item ID: " + item);
			}
			for(Ability ability : p.getAbilities()) {
				IO.log("Ability: " + ability.getAbilityID() + " " + ability.getPlayerLevel());
			}
		}
	}

}
