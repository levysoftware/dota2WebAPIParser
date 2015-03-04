package GameInfo;

public class PlayerSlotAnalyzer {
	/**
	 * playerSlots from 0-4 are on the Radiant Team
	 * playerSlots from 128-132 are on the Dire Team
	 * 
	 * @param playerSlot
	 * @return
	 */
	public static boolean isRadiant(long playerSlot) {
		if(playerSlot >= 0 && playerSlot <= 4) {
			return true;
		}
		return false;
	}
}
