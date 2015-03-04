package GameInfo;

import java.util.ArrayList;

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

	private final String MATCH_ID;
	private final long LOBBY_TYPE;
	private final long NUM_HUMAN_PLAYERS;
	private final long POS_VOTES;
	private final long NEG_VOTES;
	private final long GAME_MODE;

	private ArrayList<PlayerDataExtended> players;
	private int playerCounter;

	private long radiantTowerStatus;
	private long radiantBarracksStatus;
	private long direTowerStatus;
	private long direBarracksStatus;

	private Boolean radiantWin;
	private long firstBloodTime;
	private long matchDuration;

	/**
	 * 
	 * @param matchID
	 * @param lobbyType
	 * @param numHumanPlayers
	 * @param positiveVotes
	 * @param negativeVotes
	 * @param gameMode
	 */
	public GameData(String matchID, long lobbyType, long numHumanPlayers, long positiveVotes,
			long negativeVotes, long gameMode) {
		MATCH_ID = matchID;
		LOBBY_TYPE = lobbyType;
		NUM_HUMAN_PLAYERS = numHumanPlayers;
		POS_VOTES = positiveVotes;
		NEG_VOTES = negativeVotes;
		GAME_MODE = gameMode;

		players = new ArrayList<PlayerDataExtended>();
		playerCounter = 0;

		radiantTowerStatus = 0;
		radiantBarracksStatus = 0;
		direTowerStatus = 0;
		direBarracksStatus = 0;

		radiantWin = null;
		firstBloodTime = 0;
		matchDuration = 0;
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
	public void resetNextPlayerCounter() {
		playerCounter = 0;
	}

	// SETTERS
	public void setFirstBloodTime(long time) { firstBloodTime = time; }
	public void setMatchDuration(long duration) { matchDuration = duration; }

	public void setRadiantTowerStatus(long status) { radiantTowerStatus = status; }
	public void setRadiantBarracksStatus(long status) { radiantBarracksStatus = status; }
	public void setDireTowerStatus(long status) { direTowerStatus = status; }
	public void setDireBarracksStatus(long status) { direBarracksStatus = status; }

	public void setRadiantWinner(boolean winner) { radiantWin = winner; }

	public void addPlayer(PlayerDataExtended player) { players.add(player); }

}
