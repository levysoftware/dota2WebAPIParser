package GameInfo;

public class Ability {
	private final long abilityID;
	private final long playerLevel;
	
	/**
	 * 
	 * @param abilityID2
	 * @param upgradeLevel
	 */
	public Ability(long abilityID2, long upgradeLevel) {
		this.abilityID = abilityID2;
		this.playerLevel = upgradeLevel;
	}
	
	public long getAbilityID() { return abilityID; }
	public long getPlayerLevel() { return playerLevel; }
}
