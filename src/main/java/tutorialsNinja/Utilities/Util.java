package tutorialsNinja.Utilities;

import java.util.Date;

public class Util {

	public static final int IMPLICIT_WAIT = 10;
	public static final int PAGELOAD_TIME = 10;
	public static final int SCRIPT_TIME = 10;
	
	public static String emailDateTimeStamp() {
		Date date = new Date();
	    String timeStamp =	date.toString().replace(" ", "_").replace(":", "_");
	    return "mimichenait" + timeStamp + "@gmail.com";
		
		
	}
}
