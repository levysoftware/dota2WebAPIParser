package GameInfo;

public class PlayerData {

	private final long ACCOUNT_32BIT_ID;
	private final long PLAYER_SLOT;
	private final long HERO;
	
	public PlayerData(long accountID, long playerSlot, long heroID) {
		ACCOUNT_32BIT_ID = accountID;
		PLAYER_SLOT      = playerSlot;
		HERO             = heroID;
	}
}
