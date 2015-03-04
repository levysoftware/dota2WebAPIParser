package Demos;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import DotaData.AbilityMapping;
import DotaData.ItemMapping;
import GameTracker.IO;
import GameTracker.ReadDataFiles;
import Parse.JsonParser;

public class DemoGetAbilitiesAndItems {
	
	public static void main(String[] args) throws ParseException, IOException {
		AbilityMapping abilityMap = JsonParser.parseAbilities(ReadDataFiles.getAbilitiesFileData());
		ItemMapping itemMap       = JsonParser.parseItems(ReadDataFiles.getItemsFileData());
		
		for(int i = ItemMapping.MINIMUM_ITEM_ID; i < itemMap.getHighestItemID(); i++) {
			IO.log("Item ID: " + i + " Item Name: " + itemMap.getItemName(i));
		}
	}
	
	
	
}
