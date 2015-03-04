package Demos;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import GameInfo.PlayerData;
import GameTracker.IO;
import Matches.Match;
import Matches.MatchHistory;
import WebAPI.API;

public class DemoRecentMatches {
	
	public static void main(String[] args) throws IOException, ParseException {
		String user32BitID = API.get32BitUName("thelevite");
		MatchHistory history = API.getMatches(user32BitID);
		
		// Look at first match only
		Match m = history.getNextMatch();
		IO.log("Match ID: " + m.getMatchID());
		IO.log("Lobby Type: " + m.getLobbyType());
		IO.log("Start Time: " + m.getStartTime());
		IO.log("Match Sequence Number: " + m.getMatchSeqNumber());
		
		while(m.hasNextPlayer()) {
			PlayerData p = m.getNextPlayer();
			IO.log("\n");
			IO.log("Account ID: " + p.getAccountID());
			IO.log("Hero ID: " + p.getHeroID());
			IO.log("Player Slot: " + p.getPlayerSlot());
			IO.log("Team: " + p.getPlayerSide());
		}
	}
	
}
