/**
 * 
 */
package Police;

import java.util.Random;

import country.City;

import immigrants.Immigrant;

/**
 *
 *Полицейските служители биват:
• Полицаи – те залавят около 50% от нелегалните имигранти (радикални и
екстремисти). Не могат да залавят обаче имигранти, които носят бомба в
себе си. Те проверят всички имигранти, независимo от типа им и дали
имат паспорт.
 */
public class PoliceOfficer extends Policemen {

	
// залавят около 50% от нелегалните имигранти (no passport)

	public PoliceOfficer(String name, City city) {
		super(name, city);
		
	}

	@Override
	public boolean securityCheck(Immigrant immi) {
		if(immi.hasBomb()){
			return true;
		}
		if(immi.getPassport()!= null){
			System.out.println("Welcome");
			return true;
		}else{
			return new Random().nextBoolean();
		}
		
	}
	
	
}
