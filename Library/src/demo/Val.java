package demo;
/**
 * 
 */

/**
 * Validators
 *
 */
public class Val {

	public static String validText(String s) {
		if (s != null && !s.isEmpty()) {
			return s;
		}
		return "Unknown";
	}

	public static int validNum(int x) {
		return x < 0 ? 0 : x;
	}

}
