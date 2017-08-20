package country;

import Demo.Val;

/**
 Паспортът на един имигрант съдържа следните данни:
• Име;
• Години.
• Държава и град по рождение.
 */
public class Passport {
	private String name;
	private int age;
	private String city;
	
	public Passport(String name, int age, String city) {

		this.name = Val.validStr(name);
		this.age = Val.validNum(age);
		this.city = Val.validStr(city);
	}
	
	

}
