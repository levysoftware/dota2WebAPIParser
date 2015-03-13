package Matches;

import java.util.ArrayList;

import GameInfo.PlayerData;

public class Match {
	
	private final long MATCH_ID;
	private final long MATCH_SEQ_NUMBER;
	private final long START_TIME;
	private final long LOBBY_TYPE;
	
	private ArrayList<PlayerData> players;
	private int playerCounter;
	
	/**
	 * 
	 * @param matchID
	 * @param matchSeqNumb
	 * @param startTime
	 * @param lobbyType
	 */
	public Match(long matchID, long matchSeqNumb, long startTime, long lobbyType) {
		MATCH_ID         = matchID;
		MATCH_SEQ_NUMBER = matchSeqNumb;
		START_TIME       = startTime;
		LOBBY_TYPE       = lobbyType;
		
		players = new ArrayList<PlayerData>();
		playerCounter = 0;
	}
	
	public long getMatchID() { return MATCH_ID; }
	public long getMatchSeqNumber() { return MATCH_SEQ_NUMBER; }
	public long getStartTime() { return START_TIME; }
	public long getLobbyType() { return LOBBY_TYPE; }
	
	public boolean hasNextPlayer() {
		return (playerCounter < players.size());
	}
	public PlayerData getNextPlayer() {
		PlayerData ret;
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
	public void resetPlayerCounter() { playerCounter = 0; }
	
	/**
	 * 
	 * @param account32BitId
	 * @param playerSlot
	 * @param heroId
	 */
	public void addPlayer(long account32BitId, long playerSlot, long heroId) {
		players.add(new PlayerData(account32BitId, playerSlot, heroId));
	}
	
}
