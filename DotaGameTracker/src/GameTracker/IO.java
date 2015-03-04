package GameTracker;

public class IO {
	
	public static void log(String msg) {
		System.out.println(msg);
	}
	
	public static void log(long msg) {
		log("" + msg);
	}
	
	public static void log(boolean msg) {
		if(msg) { log("true"); }
		else { log("false"); }
	}
}
