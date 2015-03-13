package Demos;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import DotaData.AbilityMapping;
import DotaData.HeroMapping;
import DotaData.ItemMapping;
import GameInfo.Ability;
import GameInfo.GameData;
import GameInfo.PlayerDataExtended;
import GameTracker.IO;
import WebAPI.API;

public class DemoPlayerData {
	
	/**
	 * Gets player information for a certain match
	 * 
	 * @param matchId
	 * @throws ParseException
	 * @throws IOException
	 */
	public DemoPlayerData(String matchId) throws ParseException, IOException {
		GameData data = API.getMatchDetails(matchId);
		
		HeroMapping heroMap       = API.getHeroMapping();
		AbilityMapping abilityMap = API.getAbilityMapping();
		ItemMapping itemMap       = API.getItemMapping();

		// Player Data
		while(data.hasNextPlayer()) {
			PlayerDataExtended p = data.getNextPlayer();
			IO.logLineBreak();
			IO.log("Hero Name: " + heroMap.getHeroName((int) p.getHeroID()));
			IO.log("Account ID: " + p.getAccountID());
			IO.log("Kills: " + p.getKills());
			IO.log("Deaths: " + p.getDeaths());
			IO.log("Assists: " + p.getAssists());
			IO.log("Last Hits: " + p.getLastHits());
			IO.log("Denies: " + p.getDenies());
			IO.log("Gold: " + p.getGold());
			IO.log("Gold Spent: " + p.getGoldSpent());
			IO.log("Net Worth: " + p.getTotalGold());
			IO.log("GPM: " + p.getGPM());
			IO.log("XPM: " + p.getXPM());
			IO.log("Hero Damage: " + p.getHeroDamage());
			IO.log("Hero Healing: " + p.getHeroHealing());
			IO.log("Tower Damage: " + p.getTowerDamage());
			IO.log("Hero Level: " + p.getLevel());
			IO.log("Player Slot: " + p.getPlayerSlot());
			IO.log("Team: " + p.getPlayerSide());
			for(long item : p.getItems()) {
				IO.log("Item ID: " + itemMap.getItemName((int) item));
			}
			for(Ability ability : p.getAbilities()) {
				IO.log("Ability: " + abilityMap.getAbilityName((int) ability.getAbilityID()) + " " + ability.getPlayerLevel());
			}
		}
	}

}
