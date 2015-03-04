package DotaData;

import java.util.HashMap;

public class ItemMapping {
	
	public final static String UNKNOWN_ITEM_ID = "UNKNOWN_ITEM_ID";
	public final static String INVALID_ITEM_ID = "INVALID_ITEM_ID";
	
	public final static int MINIMUM_ITEM_ID = 0;
	
	private HashMap<Integer, String> itemMap;
	
	private int highestItemID = 0;
	
	public ItemMapping() {
		itemMap = new HashMap<Integer, String>();
	}
	
	public boolean addMapping(Integer itemID, String itemName) {
		boolean ret = false;
		if(itemID != null && itemName != null) {
			if(itemID > highestItemID) { highestItemID = itemID; }
			itemMap.put(itemID, itemName);
			ret = true;
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @param itemID
	 * @return
	 */
	public String getItemName(Integer itemID) {
		String ret = UNKNOWN_ITEM_ID;
		if(itemID >= MINIMUM_ITEM_ID && itemID <= highestItemID) {
			ret = itemMap.get(itemID);
			if(ret == null) { ret = INVALID_ITEM_ID; }
		}
		
		return ret;
	}
	
	public int getHighestItemID() {
		return highestItemID;
	}
	
}
