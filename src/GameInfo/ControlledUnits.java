package GameInfo;

public class ControlledUnits {
	
	private final String UNIT_NAME;
	private int[] items;
	
	/**
	 * 
	 * @param unitName
	 */
	public ControlledUnits(String unitName) {
		UNIT_NAME = unitName;
	}
	
	/**
	 * 
	 * @param newItems
	 */
	public void changeItems(int[] newItems) {
		items = newItems;
	}
	
	public String getUnitName() { return UNIT_NAME; }
	public int[] getItems() { return items; }
}
