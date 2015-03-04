package DotaData;

import java.util.HashMap;

public class HeroMapping {
	
	public final static String UNKNOWN_HERO_ID = "UNKNOWN_HERO_ID";
	public final static String INVALID_HERO_ID = "INVALID_HERO_ID";
	
	private HashMap<Integer, String> heroMap;
	
	private int highestHeroID = 0;

	public HeroMapping() {
		heroMap = new HashMap<Integer, String>();
	}
	
	/**
	 * 
	 * @param heroID
	 * @param heroName
	 * @return
	 */
	public boolean addMapping(Integer heroID, String heroName) {
		boolean ret = false;
		if(heroID != null && heroName != null) {
			if(heroID > highestHeroID) { highestHeroID = heroID; }
			heroMap.put(heroID, heroName);
			ret = true;
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @param heroID - The first hero ID is 1
	 * @return
	 */
	public String getHeroName(Integer heroID) {
		String ret = UNKNOWN_HERO_ID;
		if(heroID > 0 && heroID <= highestHeroID) {
			ret = heroMap.get(heroID);
			if(ret == null) { ret = INVALID_HERO_ID; }
		}
		
		return ret;
	}
	
	public int getHighestHeroID() {
		return highestHeroID;
	}
	
	/**
	 * 
	 * @param heroName
	 * @return
	 */
	public static String getHeroNameShort(String heroName) {
		return heroName.replace("npc_dota_hero_", "");
	}
}
