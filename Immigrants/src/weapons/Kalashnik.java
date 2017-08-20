
package weapons;

import java.util.Random;

public class Kalashnik extends Weapon {

	
	public Kalashnik(int price) {
		super(price);
		
	}

	@Override
	public int shoot() {
		System.out.println("Kalashikov... Kalashnikov...");
		return new Random().nextInt(300)+200;
	}

	@Override
	public String toString() {
		return "Kalashnikov";
	}

	
}
