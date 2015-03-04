package GameInfo;

public class PlayerData {

	private final long ACCOUNT_32BIT_ID;
	private final long PLAYER_SLOT;
	private final long HERO_ID;

	private final boolean RADIANT;

	public PlayerData(long accountID, long playerSlot, long heroID) {
		ACCOUNT_32BIT_ID = accountID;
		PLAYER_SLOT      = playerSlot;
		HERO_ID          = heroID;
		
		// Determine if player is on Radiant team or Dire
		RADIANT = PlayerSlotAnalyzer.isRadiant(playerSlot);
	}

	public long getAccountID() { return ACCOUNT_32BIT_ID; }
	public long getPlayerSlot() { return PLAYER_SLOT; }
	public long getHeroID() { return HERO_ID; }
	public boolean isRadiant() { return RADIANT; }
	
	/**
	 * 
	 * @return - Either "Radiant" or "Dire"
	 */
	public String getPlayerSide() { return isRadiant() ? "Radiant" : "Dire"; }
	
}
