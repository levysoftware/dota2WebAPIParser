package GameInfo;

import java.util.ArrayList;

public class PlayerDataExtended {
	
	private final long ACCOUNT_32BIT_ID;
	private final long PLAYER_SLOT;
	
	private final boolean RADIANT;
	private final long HERO;
	
	private long[] items;
	
	private long kills;
	private long deaths;
	private long assists;
	
	private long lastHits;
	private long denies;
	
	private long gold;
	private long gpm;
	private long xpm;
	private long goldSpent;
	
	private long heroDmg;
	private long towerDmg;
	private long heroHeal;
	
	private long level;
	
	private ArrayList<Ability> abilities;
	
	private ArrayList<ControlledUnits> controlledUnits;
	
	/**
	 * 
	 * @param accountID
	 * @param playerSlot
	 * @param heroID
	 */
	public PlayerDataExtended(long accountID, long playerSlot, long heroID) {
		ACCOUNT_32BIT_ID = accountID;
		PLAYER_SLOT = playerSlot;
		RADIANT = PlayerSlotAnalyzer.isRadiant(playerSlot);
		HERO = heroID;
		
		items = new long[6];
		
		// Set everything to 0
		kills = deaths = assists = lastHits = denies = gold = 0;
		gpm = xpm = goldSpent = heroDmg = towerDmg = heroHeal = level = 0;
		
		abilities = new ArrayList<Ability>();
		controlledUnits = new ArrayList<ControlledUnits>();
	}

	/**
	 * 
	 * @param items2
	 * @param kills2
	 * @param deaths2
	 * @param assists2
	 * @param lastHits2
	 * @param denies2
	 * @param gold2
	 * @param gpm2
	 * @param xpm2
	 * @param goldSpent2
	 * @param heroDmg2
	 * @param towerDmg2
	 * @param heroHeal2
	 * @param level2
	 * @param abilities
	 * @param controlledUnits
	 */
	public void update(long[] items2, long kills2, long deaths2, long assists2, long lastHits2,
			long denies2, long gold2, long gpm2, long xpm2, long goldSpent2, long heroDmg2, long towerDmg2,
			long heroHeal2, long level2, ArrayList<Ability> abilities, ArrayList<ControlledUnits> controlledUnits) {
		this.items = items2;
		this.kills = kills2;
		this.deaths = deaths2;
		this.assists = assists2;
		this.lastHits = lastHits2;
		this.denies = denies2;
		this.gold = gold2;
		this.gpm = gpm2;
		this.xpm = xpm2;
		this.goldSpent = goldSpent2;
		this.heroDmg = heroDmg2;
		this.towerDmg = towerDmg2;
		this.heroHeal = heroHeal2;
		this.level = level2;
		this.abilities = abilities;
		this.controlledUnits = controlledUnits;
	}
	
	/**
	 * 
	 * @return 32-bit id of the player's account
	 */
	public long getAccountID() { return ACCOUNT_32BIT_ID; }
	public long getPlayerSlot() { return PLAYER_SLOT; }
	public boolean isRadiant() { return RADIANT; }
	public long getHeroID() { return HERO; }
	
	public long[] getItems() { return items; }
	
	public long getKills() { return kills; }
	public long getDeaths() { return deaths; }
	public long getAssists() { return assists; }
	
	public long getLastHits() { return lastHits; }
	public long getDenies() { return denies; }
	
	public long getGold() { return gold; }
	public long getGoldSpent() { return goldSpent; }
	public long getGPM() { return gpm; }
	public long getXPM() { return xpm; }
	
	public long getHeroDamage() { return heroDmg; }
	public long getTowerDamage() { return towerDmg; }
	public long getHeroHealing() { return heroHeal; }
	
	public long getLevel() { return level; }
	
	public ArrayList<Ability> getAbilities() { return abilities; }
	public ArrayList<ControlledUnits> getControlledUnits() { return controlledUnits; }
}
