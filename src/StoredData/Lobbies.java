package StoredData;

public class Lobbies {
	
	public final static int INVALID            = -1;
	public final static int PUBLIC_MATCHMAKING = 0;
	public final static int PRACTICE           = 1;
	public final static int TOURNAMENT         = 2;
	public final static int TUTORIAL           = 3;
	public final static int COOP_WITH_BOTS     = 4;
	public final static int TEAM_MATCH         = 5;
	public final static int SOLO_QUEUE         = 6;
	public final static int RANKED             = 7;
	public final static int SOLO_MID_1V1       = 8;
	
	public static String getLobbyName(int lobbyType) {
		String ret;
		if(lobbyType == PUBLIC_MATCHMAKING) { ret = "Public Matchmaking"; }
		else if(lobbyType == PRACTICE) { ret = "Practice"; }
		else if(lobbyType == TOURNAMENT) { ret = "Tournamnet"; }
		else if(lobbyType == TUTORIAL) { ret = "Tutorial"; }
		else if(lobbyType == COOP_WITH_BOTS) { ret = "Co-Op With Bots"; }
		else if(lobbyType == TEAM_MATCH) { ret = "Team Match"; }
		else if(lobbyType == SOLO_QUEUE) { ret = "Solo Queue"; }
		else if(lobbyType == RANKED) { ret = "Ranked"; }
		else if(lobbyType == SOLO_MID_1V1) { ret = "Solo Mid 1v1"; }
		else { ret = "INVALID"; }
		
		return ret;
	}
	
}
