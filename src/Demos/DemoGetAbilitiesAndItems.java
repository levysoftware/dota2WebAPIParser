package Demos;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import DotaData.AbilityMapping;
import DotaData.ItemMapping;
import GameTracker.IO;
import WebAPI.API;

public class DemoGetAbilitiesAndItems {
	
	/**
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public DemoGetAbilitiesAndItems() throws ParseException, IOException {
		AbilityMapping abilityMap = API.getAbilityMapping();
		ItemMapping itemMap       = API.getItemMapping();
		
		for(int i = ItemMapping.MINIMUM_ITEM_ID; i < itemMap.getHighestItemID(); i++) {
			IO.log("Item ID: " + i + " Item Name: " + itemMap.getItemName(i));
		}
	}
}
