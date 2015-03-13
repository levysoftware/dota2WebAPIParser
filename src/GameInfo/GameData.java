package GameInfo;

import java.util.ArrayList;

import GameTracker.IO;

/*
 * TODO: 
 * Add leagueid
 * 
 * http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1?key=0396FBE95A969312C389FAA3586ADFF3&match_id=1303423292
 */

/**
 * 
 * Variables to update:
 * 	radiantTowerStatus,
 * 	radiantBarracksStatus,
 * 	direTowerStatus,
 * 	direBarracksStatus,
 * 	radiantWin,
 * 	firstBloodTime
 *
 */
public class GameData {

	/**
	 * Dire    - 0
	 * Radiant - 1
	 */
	public final static int DIRE_TEAM = 0;
	public final static int RADIANT_TEAM = 1;

	private final String MATCH_ID;
	private final long LOBBY_TYPE;
	private final long NUM_HUMAN_PLAYERS;
	private final long POS_VOTES;
	private final long NEG_VOTES;
	private final long GAME_MODE;

	private final boolean TEAM_GAME;

	private ArrayList<PlayerDataExtended> players;
	private int playerCounter;

	private long radiantTowerStatus;
	private long radiantBarracksStatus;
	private long direTowerStatus;
	private long direBarracksStatus;

	private Boolean radiantWin;
	private long firstBloodTime;
	private long matchDuration;

	private TeamInfo[] teamInfo;

	private long[] teamCaptains;
	private PicksAndBans[] picks;
	private boolean picksAndBans;

	/**
	 * 
	 * @param matchID
	 * @param lobbyType
	 * @param numHumanPlayers
	 * @param positiveVotes
	 * @param negativeVotes
	 * @param gameMode
	 * @param teamGame
	 */
	public GameData(String matchID, long lobbyType, long numHumanPlayers, long positiveVotes,
			long negativeVotes, long gameMode, boolean teamGame) {
		MATCH_ID = matchID;
		LOBBY_TYPE = lobbyType;
		NUM_HUMAN_PLAYERS = numHumanPlayers;
		POS_VOTES = positiveVotes;
		NEG_VOTES = negativeVotes;
		GAME_MODE = gameMode;

		TEAM_GAME = teamGame;

		players = new ArrayList<PlayerDataExtended>();
		playerCounter = 0;

		radiantTowerStatus = 0;
		radiantBarracksStatus = 0;
		direTowerStatus = 0;
		direBarracksStatus = 0;

		radiantWin = null;
		firstBloodTime = 0;
		matchDuration = 0;

		teamInfo = new TeamInfo[2];

		teamCaptains = new long[2];
		picks = new PicksAndBans[20];
		picksAndBans = false;
	}

	// GETTERS
	public String getMatchID() { return MATCH_ID; }
	public long getLobbyType() { return LOBBY_TYPE; }
	public long getNumHumanPlayers() { return NUM_HUMAN_PLAYERS; }
	public long getPosVotes() { return POS_VOTES; }
	public long getNegVotes() { return NEG_VOTES; }
	public long getGameMode() { return GAME_MODE; }

	public long getFirstBloodTime() { return firstBloodTime; }
	public long getMatchDuration() { return matchDuration; }
	public String getMatchDurationStr() { return (getMatchDuration() / 60) + ":" + (getMatchDuration() % 60); }

	public long getRadiantTowerStatus() { return radiantTowerStatus; }
	public long getRadiantBarracksStatus() {return radiantBarracksStatus; }
	public long getDireTowerStatus() { return direTowerStatus; }
	public long getDireBarracksStatus() { return direBarracksStatus; }

	public Boolean isRadiantWinner() { return radiantWin; }

	public boolean isTeamGame() { return TEAM_GAME; }

	/**
	 * Dire    - 0
	 * Radiant - 1
	 * 
	 * @param team
	 * @return
	 */
	public TeamInfo getTeamInfo(int team) {
		TeamInfo ret;
		if(team >= 0 && team < 2) { ret = teamInfo[team]; }
		else { ret = null; }

		return ret;
	}

	//Try not to use this (Blackbox)
	//public ArrayList<PlayerData> getPlayers() { return players; }

	public boolean hasNextPlayer() {
		return (playerCounter < players.size());
	}
	public PlayerDataExtended getNextPlayer() {
		PlayerDataExtended ret;
		if(playerCounter < players.size()) {
			ret = players.get(playerCounter++);
		} else {
			ret = null;
		}

		return ret;
	}
	public PlayerData getPreviousPlayer() {
		PlayerData ret;
		if(playerCounter < players.size() && --playerCounter > 0) {
			ret = players.get(playerCounter);
		} else {
			ret = null;
		}

		return ret;
	}
	public void resetNextPlayerCounter() {
		playerCounter = 0;
	}

	public TeamInfo getDireTeamInfo() {
		if(TEAM_GAME) {
			return teamInfo[DIRE_TEAM];
		}
		return null;
	}
	public TeamInfo getRadiantTeamInfo() {
		if(TEAM_GAME) {
			return teamInfo[RADIANT_TEAM];
		}
		return null;
	}

	public long getDireTeamCaptain() {
		if(picksAndBans) {
			return teamCaptains[DIRE_TEAM];
		}
		return 0;
	}
	public long getRadiantTeamCaptain() {
		if(picksAndBans) {
			return teamCaptains[RADIANT_TEAM];
		}
		return 0;
	}
	
	public boolean hasPicksAndBans() { return picksAndBans; }
	
	public PicksAndBans[] getPicksAndBans() {
		if(picksAndBans) {
			return picks;
		}
		return null;
	}


	// SETTERS
	/**
	 * 
	 * @param time
	 */
	public void setFirstBloodTime(long time) { firstBloodTime = time; }
	/**
	 * 
	 * @param duration
	 */
	public void setMatchDuration(long duration) { matchDuration = duration; }
	
	/**
	 * 
	 * @param status
	 */
	public void setRadiantTowerStatus(long status) { radiantTowerStatus = status; }
	/**
	 * 
	 * @param status
	 */
	public void setRadiantBarracksStatus(long status) { radiantBarracksStatus = status; }
	/**
	 * 
	 * @param status
	 */
	public void setDireTowerStatus(long status) { direTowerStatus = status; }
	/**
	 * 
	 * @param status
	 */
	public void setDireBarracksStatus(long status) { direBarracksStatus = status; }
	
	/**
	 * 
	 * @param winner
	 */
	public void setRadiantWinner(boolean winner) { radiantWin = winner; }

	public void addPlayer(PlayerDataExtended player) { players.add(player); }
	
	/**
	 * 
	 * @param teamName
	 * @param teamLogo
	 * @param teamComplete
	 */
	public void addDireTeamInfo(String teamName, long teamLogo, boolean teamComplete) {
		teamInfo[DIRE_TEAM] = new TeamInfo(teamName, teamLogo, teamComplete);
	}
	/**
	 * 
	 * @param teamName
	 * @param teamLogo
	 * @param teamComplete
	 */
	public void addRadiantTeamInfo(String teamName, long teamLogo, boolean teamComplete) {
		teamInfo[RADIANT_TEAM] = new TeamInfo(teamName, teamLogo, teamComplete);
	}
	
	/**
	 * 
	 * @param steamUserId
	 */
	public void addDireTeamCaptain(long steamUserId) {
		teamCaptains[DIRE_TEAM] = steamUserId;
	}
	/**
	 * 
	 * @param steamUserId
	 */
	public void addRadiantTeamCaptain(long steamUserId) {
		teamCaptains[RADIANT_TEAM] = steamUserId;
	}

	// For captains draft / mode
	/**
	 * 
	 * @param isPick
	 * @param heroId
	 * @param teamId
	 * @param order
	 */
	public void addPick(boolean isPick, int heroId, int teamId, int order) {
		if((teamId == DIRE_TEAM || teamId == RADIANT_TEAM) && order < picks.length) {
			picks[order] = new PicksAndBans(isPick, teamId, heroId, order);
			picksAndBans = true;
		} else {
			IO.log("To many picks and bans!");
		}
	}

	// Holds data on a hero whether it was picked or banned
	public class PicksAndBans {

		private final boolean IS_PICK;
		private final int TEAM;
		private final int HERO_ID;
		private final int ORDER;
		
		/**
		 * 
		 * @param isPick
		 * @param team
		 * @param heroId
		 * @param order
		 */
		PicksAndBans(boolean isPick, int team, int heroId, int order) {
			IS_PICK = isPick;
			TEAM = team;
			HERO_ID = heroId;
			ORDER = order;
		}

		public boolean isPick() { return IS_PICK; }
		public int getTeam() { return TEAM; }
		public int getHeroID() { return HERO_ID; }
		public int getPickOrder() { return ORDER; }
	}
}
