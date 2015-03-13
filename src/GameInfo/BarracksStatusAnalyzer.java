package GameInfo;

public class BarracksStatusAnalyzer {
	
	private final boolean BOTTOM_RANGED;
	private final boolean BOTTOM_MELEE;
	private final boolean MIDDLE_RANGED;
	private final boolean MIDDLE_MELEE;
	private final boolean TOP_RANGED;
	private final boolean TOP_MELEE;
	
	private final long ALL_UP = 63;
	
	/**
	 * 
	 * @param statusCode
	 */
	public BarracksStatusAnalyzer(long statusCode) {
		BOTTOM_RANGED = (statusCode / 32) > 0 ? true : false;
		statusCode %= 32;
		BOTTOM_MELEE = (statusCode / 16) > 0 ? true : false;
		statusCode %= 16;
		MIDDLE_RANGED = (statusCode / 8) > 0 ? true : false;
		statusCode %= 8;
		MIDDLE_MELEE = (statusCode / 4) > 0 ? true : false;
		statusCode %= 4;
		TOP_RANGED = (statusCode / 2) > 0 ? true : false;
		statusCode %= 2;
		TOP_MELEE = (statusCode != 0) ? true : false;
	}
	
	public boolean getBottomRanged() { return BOTTOM_RANGED; }
	public boolean getBottomMeele() { return BOTTOM_MELEE; }
	
	public boolean getMiddleRanged() { return MIDDLE_RANGED; }
	public boolean getMiddleMeele() { return MIDDLE_MELEE; }
	
	public boolean getTopRanged() { return TOP_RANGED; }
	public boolean getTopMeele() { return TOP_MELEE; }
	
}
