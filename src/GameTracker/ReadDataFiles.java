package GameTracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadDataFiles {

	public static String getAbilitiesFileData() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(ReadDataFiles.class.getResourceAsStream("..\\StoredData\\abilities.json")));
		return readFromInputStream(in);
	}
	
	public static String getItemsFileData() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(ReadDataFiles.class.getResourceAsStream("..\\StoredData\\items.json")));
		return readFromInputStream(in);
	}
	
	private static String readFromInputStream(BufferedReader in) throws IOException {
		String ret = "";
		
		String temp;
		while((temp = in.readLine()) != null) {
			ret += temp;
		}
		
		return ret;
	}
}
