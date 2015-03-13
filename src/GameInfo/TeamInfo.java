package GameInfo;


public class TeamInfo {

	private final String TEAM_NAME;
	private final long TEAM_LOGO;
	private final boolean TEAM_COMPLETE;

	/**
	 * 
	 * @param teamName
	 * @param teamLogo
	 * @param teamComplete
	 */
	public TeamInfo(String teamName, long teamLogo, boolean teamComplete) {
		TEAM_NAME = teamName;
		TEAM_LOGO = teamLogo;
		TEAM_COMPLETE = teamComplete;
	}

	public String getTeamName() { return TEAM_NAME; }
	public long getTeamLogo() { return TEAM_LOGO; }
	
	/**
	 * Returns false if any member is a stand-in
	 * 
	 * @return
	 */
	public boolean isTeamComplete() { return TEAM_COMPLETE; }
}
