package Matches;

import java.util.ArrayList;

import GameInfo.PlayerData;

public class MatchHistory {
	
	private final long NUMBER_RESULTS;
	private final long TOTAL_RESULTS;
	private final long RESULTS_REMAINING;
	
	private ArrayList<Match> matches;
	private int matchCounter;
	
	public MatchHistory(long numberOfResults, long totalResults, long resultsRemaining) {
		NUMBER_RESULTS    = numberOfResults;
		TOTAL_RESULTS     = totalResults;
		RESULTS_REMAINING = resultsRemaining;
		
		matches = new ArrayList<Match>();
		matchCounter = 0;
	}
	
	public long getNuberOfResults() { return NUMBER_RESULTS; }
	public long getTotalResults() { return TOTAL_RESULTS; }
	public long getResultsRemaining() { return RESULTS_REMAINING; }
	
	public boolean hasNextMatch() {
		return (matchCounter < matches.size());
	}
	public Match getNextMatch() {
		Match ret;
		if(matchCounter < matches.size()) {
			ret = matches.get(matchCounter++);
		} else {
			ret = null;
		}
		
		return ret;
	}
	public Match getPreviousPlayerMatch() {
		Match ret;
		if(matchCounter < matches.size() && --matchCounter > 0) {
			ret = matches.get(matchCounter);
		} else {
			ret = null;
		}
		
		return ret;
	}
	public void resetMatchCounter() { matchCounter = 0; }
	
	public void addMatch(long matchID, long matchSeqNumb, long startTime, long lobbyType) {
		matches.add(new Match(matchID, matchSeqNumb, startTime, lobbyType));
	}
	
}
