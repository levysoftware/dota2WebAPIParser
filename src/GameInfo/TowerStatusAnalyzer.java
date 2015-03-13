package GameInfo;

public class TowerStatusAnalyzer {
	
	//https://wiki.teamfortress.com/wiki/WebAPI/GetMatchDetails
	private final long STATUS_CODE;
	
	private final boolean ANCIENT_TOP;
	private final boolean ANCIENT_BOT;
	private final boolean BOT_T3;
	private final boolean BOT_T2;
	private final boolean BOT_T1;
	private final boolean MID_T3;
	private final boolean MID_T2;
	private final boolean MID_T1;
	private final boolean TOP_T3;
	private final boolean TOP_T2;
	private final boolean TOP_T1;
	
	private final long ALL_UP = 2047;
	
	/**
	 * 
	 * @param statusCode
	 */
	public TowerStatusAnalyzer(long statusCode) {
		STATUS_CODE = statusCode;
		
		ANCIENT_TOP = (statusCode / 1024) > 0 ? true : false;
		statusCode %= 1024;
		ANCIENT_BOT = (statusCode / 512) > 0 ? true : false;
		statusCode %= 512;
		BOT_T3 = (statusCode / 256) > 0 ? true : false;
		statusCode %= 256;
		BOT_T2 = (statusCode / 128) > 0 ? true : false;
		statusCode %= 128;
		BOT_T1 = (statusCode / 64) > 0 ? true : false;
		statusCode %= 64;
		MID_T3 = (statusCode / 32) > 0 ? true : false;
		statusCode %= 32;
		MID_T2 = (statusCode / 16) > 0 ? true : false;
		statusCode %= 16;
		MID_T1 = (statusCode / 8) > 0 ? true : false;
		statusCode %= 8;
		TOP_T3 = (statusCode / 4) > 0 ? true : false;
		statusCode %= 4;
		TOP_T2 = (statusCode / 2) > 0 ? true : false;
		statusCode %= 3;
		TOP_T1 = (statusCode != 0) ? true : false;
	}
	
	public long getStatusCode() { return STATUS_CODE; }
	
	public boolean getAncientTop() { return ANCIENT_TOP; }
	public boolean getAncientBot() { return ANCIENT_BOT; }
	
	public boolean getBotT3Top() { return BOT_T3; }
	public boolean getBotT2Top() { return BOT_T2; }
	public boolean getBotT1Top() { return BOT_T1; }
	
	public boolean getMidT3Top() { return MID_T3; }
	public boolean getMidT2Top() { return MID_T2; }
	public boolean getMidT1Top() { return MID_T1; }
	
	public boolean getTopT3Top() { return TOP_T3; }
	public boolean getTopT2Top() { return TOP_T2; }
	public boolean getTopT1Top() { return TOP_T1; }
	
}
