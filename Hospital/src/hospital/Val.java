package hospital;

/**
 * Validations
 *
 */
public class Val {
	
	public static String validStr(String str){
		if ( str == null || str.trim().equals("")){
			   return "Unnknown";
		}
		return str;
	}
	public static int validNum(int num){
		if(num > 0){
			return num;
		}
		return 1;
	}
	public static double validDouble(double num){
		if(num > 0){
			return num;
		}
		return 1;
	}
	

}
