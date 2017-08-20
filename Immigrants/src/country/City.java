
package country;

import java.util.ArrayList;
import java.util.Random;

import Demo.Val;
import Police.PoliceOfficer;
import Police.Policemen;
import Police.Swat;
import immigrants.Immigrant;

/**
 *
 *		 Градовете имат следните характеристики: • Име • Списък с
 *       полицейски служители. • Брой жители (което включва всички, които
 *       населяват определен град). • Списък с имигранти. 
 */
public class City {
	
	private String name;
	protected ArrayList<Policemen> police;
	private int citizens;
	private ArrayList<Immigrant> immigrants;
	private Country country;

	// Във всеки град има определен брой жители и имигранти, като няма градове
	// без жители.
	public City(String name, Country country) {
		
		this.name = Val.validStr(name);
		this.country = country;
		// Нека на произволен принцип да се зададат броя жители
		this.citizens = new Random().nextInt(30000) + 10;
		this.citizens = 10000;// test dead

		// да се генерират на произволен принцип и
		// полицейски служители, които да се разпределят по равно в градовете.
		this.police = new ArrayList<Policemen>();
		for (int i = 0; i < 100; i++) {
			if (new Random().nextBoolean()) {
				this.police.add(new PoliceOfficer("Officer " + i, this));
			} else {
				this.police.add(new Swat("Swat " + i, this));
			}
		}
		this.immigrants = new ArrayList<Immigrant>();

	}

	public int getCitizens() {
		return citizens;
	}

	public void setCitizens(int citizens) {
		this.citizens = citizens;
	}

	public Country getCountry() {
		return country;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Immigrant> getImmigrants() {
		return immigrants;
	}
	
	public void printImigrants() {
		for (Immigrant immi : immigrants) {
			System.out.println(this.name + " " + immi);
		}
	}

	@Override
	public String toString() {
		return "City [" + name + "]";
	}

}
