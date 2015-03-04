package DotaData;

import java.util.HashMap;

public class AbilityMapping {
	
	public final static String UNKNOWN_ABILITY_ID = "UNKNOWN_ABILITY_ID";
	public final static String INVALID_ABILITY_ID = "INVALID_ABILITY_ID";
	
	public final static int MINIMUM_ABILITY_ID = 5001;
	
	private HashMap<Integer, String> abilityMap;
	
	private int highestAbilityID = 0;
	
	public AbilityMapping() {
		abilityMap = new HashMap<Integer, String>();
	}
	
	public boolean addMapping(Integer abilityID, String abilityName) {
		boolean ret = false;
		if(abilityID != null && abilityName != null) {
			if(abilityID > highestAbilityID) { highestAbilityID = abilityID; }
			abilityMap.put(abilityID, abilityName);
			ret = true;
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @param abilityID
	 * @return
	 */
	public String getAbilityName(Integer abilityID) {
		String ret = UNKNOWN_ABILITY_ID;
		if(abilityID >= MINIMUM_ABILITY_ID && abilityID <= highestAbilityID) {
			ret = abilityMap.get(abilityID);
			if(ret == null) { ret = INVALID_ABILITY_ID; }
		}
		
		return ret;
	}
	
	public int getHighestAbilityID() {
		return highestAbilityID;
	}
	
}
