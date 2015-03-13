package GameTracker;

public class IO {
	
	/**
	 * All messages converted into a format to be handled by this function
	 * 
	 * @param msg
	 */
	public static void log(String msg) {
		System.out.println(msg);
	}
	
	public static void log(long msg) {
		log("" + msg);
	}
	
	/**
	 * Outputs "true" for true and "false" for false
	 * 
	 * @param msg
	 */
	public static void log(boolean msg) {
		if(msg) { log("true"); }
		else { log("false"); }
	}
	
	/**
	 * Display a line in the log file for separations (No "\n"'s
	 */
	public static void logLineSeperator() {
		// 60 * "-"
		log("------------------------------------------------------------");
	}
	
	/**
	 * A simple line break ("\r\n")
	 */
	public static void logLineBreak() {
		log("\r\n");
	}
}
