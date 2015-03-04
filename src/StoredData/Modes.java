package StoredData;

public class Modes {
	
	public final static int UNKNOWN                = 0;
	public final static int ALL_PICK               = 1;
	public final static int CAPTAINS_MODE          = 2;
	public final static int RANDOM_DRAFT           = 3;
	public final static int SINGLE_DRAFT           = 4;
	public final static int ALL_RANDOM             = 5;
	public final static int DIRETIDE               = 7;
	public final static int REVERSE_CAPTAINS_DRAFT = 8;
	public final static int GREEVILING             = 9;
	public final static int TUTORIAL               = 10;
	public final static int MID_ONLY               = 11;
	public final static int LEAST_PLAYED           = 12;
	public final static int NEW_PLAYER_POOL        = 13;
	public final static int COMPENDIUM_MATCHMAKING = 14;
	public final static int CUSTOM                 = 15;
	public final static int CAPTAINS_DRAFT         = 16;
	public final static int BALANCED_DRAFT         = 17;
	public final static int ABILITY_DRAFT          = 18;
	public final static int ALL_RANDOM_DEATH_MATCH = 20;
	public final static int SOLO_MID_1V1           = 21;
	
	public static String getGameMode(int gameMode) {
		String ret;
		if(gameMode == ALL_PICK) { ret = "All Pick"; }
		else if(gameMode == CAPTAINS_MODE) { ret = "Captains Mode"; }
		else if(gameMode == RANDOM_DRAFT) { ret = "Random Draft"; }
		else if(gameMode == SINGLE_DRAFT) { ret = "Single Draft"; }
		else if(gameMode == ALL_RANDOM) { ret = "All Random"; }
		else if(gameMode == DIRETIDE) { ret = "Diretide"; }
		else if(gameMode == REVERSE_CAPTAINS_DRAFT) { ret = "Reverse Captains Draft"; }
		else if(gameMode == GREEVILING) { ret = "Greeviling"; }
		else if(gameMode == TUTORIAL) { ret = "Tutorial"; }
		else if(gameMode == MID_ONLY) { ret = "Mid Only"; }
		else if(gameMode == LEAST_PLAYED) { ret = "Least Played"; }
		else if(gameMode == NEW_PLAYER_POOL) { ret = "New Player Pool"; }
		else if(gameMode == COMPENDIUM_MATCHMAKING) { ret = "Compendium Matchmaking"; }
		else if(gameMode == CUSTOM) { ret = "Custom"; }
		else if(gameMode == CAPTAINS_DRAFT) { ret = "Captains Draft"; }
		else if(gameMode == BALANCED_DRAFT) { ret = "Balanced Draft"; }
		else if(gameMode == ABILITY_DRAFT) { ret = "Ability Draft"; }
		else if(gameMode == ALL_RANDOM_DEATH_MATCH) { ret = "All Random Death Match"; }
		else if(gameMode == SOLO_MID_1V1) { ret = "Solo Mid 1v1"; }
		else { ret = "UNKNOWN"; }
		
		return ret;
	}
	
}
