
package immigrants;
import java.util.ArrayList;
import java.util.Random;

import country.Country;
import weapons.Weapon;

/**
 *  Имигрантите биват:
 * 
 *         • Имигранти-екстремисти – не притежават паспорт, имат неограничен
 *         брой роднини (може и да нямат) и може да притежават неограничен брой
 *         оръжия в себе си от всякакъв тип.
 */
public class Extremist extends Immigrant {

	public Extremist(Country country, ArrayList<Immigrant> relatives) {
		super(country, null, relatives);
		this.name = "Alosha Sanches Gandi " + (new Random().nextInt(10000) + 10);

	}

	/*
	 * Ако е екстремист - да взриви бомба – тогава в програмата възниква
	 * изключителна ситуация, изкарва се подходящо съобщение и целия град се
	 * премахва от списъка с градове на дадена държава.
	 */

	@Override
	public void shootThem() {
		if (this.isDead) {
			System.out.println("I am dead the Terorist, spoko. no victims");
			return;
		} 
		if (this.hasBomb()) {
			                 // and is not already blowed up
			if (this.city != null && this.country.getCities().contains(this.city)) {
				this.country.getCities().remove(this.city);
				System.out.println("TeroreNeN LIVE: BREAKING NEWS " + this.city + "  BLOWED UP");
			} else {
				System.out.println("TeroreNeN LIVE: BREAKING NEWS MEADOW WAS BLOWED UP");
			}
			this.isDead = true;  
			return;
			// throw new IllegalPathStateException("TerorNN LIVE: BREAKING NEWS
			// "+this.city+" BLOWED UP");
		}
		if (this.weapons.size() > 0) {
			String weapons = "";
			for (Weapon weapon : this.weapons) {
				weapons += " " + weapon;
			}
			System.out.println("I still wonder why I bought: " + weapons);
		} else {
			System.out.println("no weapon");
		}

	}

	@Override
	public boolean hasBomb() {
		for (Weapon w : weapons) {
			if (w.isBomb()) {
				return true;
			}
		}
		return false;
	}

}
