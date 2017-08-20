
package Police;

import java.util.Random;

import country.City;

import immigrants.Immigrant;

/**
 * 
 * Те проверяват само имигрантите, които са радикални и екстремисти.
 */
public class Swat extends Policemen {

	
public Swat(String name, City city) {
		super(name, city);
		
	}

// Спец-части – залавят около 90% от нелегалните имигранти,
	@Override
	public boolean securityCheck(Immigrant immi) {
		if(immi.getPassport()!= null){
			System.out.println("Not checked");
			return true;
		}else{
			return new Random().nextInt(10) == 0; //90% false
		}
		
	}
}
