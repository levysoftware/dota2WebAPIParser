package GameInfo;

public class ControlledUnits {
	
	private final String UNIT_NAME;
	private int[] items;
	
	public ControlledUnits(String unitName) {
		UNIT_NAME = unitName;
	}
	
	public void changeItems(int[] newItems) {
		items = newItems;
	}
	
	public String getUnitName() { return UNIT_NAME; }
	public int[] getItems() { return items; }
}
