
package immigrants;

import java.util.ArrayList;
import java.util.Random;
import country.Country;

import country.Passport;

/**
 * 
• Нормални имигранти – те задължително имат паспорт, не притежават
оръжие и имат до 10 роднини.

 */
public class Normal extends Immigrant {

	

	public Normal(Country country, Passport passport, ArrayList<Immigrant> relatives) {
		super(country,passport, relatives );
		this.name = "Mehmed Johnson Kodjabashev "+(new Random().nextInt(10000)+1);
		
	}

	
	@Override
	protected boolean validRelatives(ArrayList<Immigrant> relatives) {
		
		return relatives.size() < 11;
	}


	@Override
	public void shootThem() {
		System.out.println(": I am just walking");
		
	}

}
