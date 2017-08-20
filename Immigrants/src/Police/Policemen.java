
package Police;

import Demo.Val;
import country.City;

import immigrants.Immigrant;

/**
 * 
 * В приложението имаме и полицейски служители. Всеки от тях има следните
данни:
• Име
• Град и държава, в който работи.
 */
public abstract class Policemen {
	private String name;
	private City city;
	

	public Policemen(String name, City city) {

		this.name = Val.validStr(name);
		this.city = city;
	}


	public abstract boolean securityCheck(Immigrant immi);
}
