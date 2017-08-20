
package country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Demo.Val;
import Police.Policemen;
import immigrants.Immigrant;

/**
 *  Държавите има следните характеристики:
 * 
 *  • Име. 
 *  • Списък с градове в тази държава.
 *         
 */
public class Country {
	
	private String name;
	private ArrayList<City> cities;
	private ArrayList<Immigrant> immigrantsInCountry;

	public Country(String name) {
		
		this.name = Val.validStr(name);
		
		this.cities = new ArrayList<>();
		String[] c = { "Sofia", "Plovdiv", "Varna", "Burgas", "Polski Trambej" };
		
		for (int i = 0; i < c.length; i++) {
			this.cities.add(new City(c[i], this));
		}
		this.immigrantsInCountry = new ArrayList<>();

	}

	/*
	 * В дадена държава и определен неин град могат да навлизат имигранти, като
	 * за всеки имигрант, който иска да влезе се зачислява на произволен принцип
	 * полицейски служител, който го проверя. Ако имигрантът е нормален, той се
	 * пропуска и се добавя към списъка с имигранти в съответния град. Ако не е
	 * (т.е. е радикален или екстремист) и ако няма паспорт, съответния
	 * полицейски служител от града (определен на произволен принцип) с
	 * определената за него вероятност го залавя и се изкарва съобщение. В този
	 * случай имигрантът не влиза в града.
	 */
	public void passCityControl(Immigrant immi, City city) {
		
		if (!this.cities.contains(city)) {
			System.out.println("Wrong city turn over");
			return;
		}
		Policemen p = city.police.get(new Random().nextInt(city.police.size()));
		int idx = this.cities.indexOf(city);

		if (p.securityCheck(immi)) {
			System.out.println(immi.getName() + ", You can pass border");
			this.cities.get(idx).getImmigrants().add(immi);
			immi.setCity(city);
		} else {
			System.out.println("Come to me, my son! " + immi.getName());
		}
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	public ArrayList<Immigrant> getImmigrantsInCountry() {
		return immigrantsInCountry;
	}

/*	 7. Да се изведат градовете сортирани по брой оцелели жители в тях,
	 имигрантите - по брой пари, както и всички имигранти, които са имали
	 бомба, но вече са я взривили.*/
	public void printCities() {
		Collections.sort(cities, (c1 , c2) -> c1.getCitizens() - c2.getCitizens());
			
		for (City city : cities) {
			System.out.println(city + " survivors " + city.getCitizens());
		}
	}

	public void printImmigrants() {
		
		Collections.sort(immigrantsInCountry, (i1, i2) ->i1.getMoney()-i2.getMoney());
		int count = 0;
		for (Immigrant immigrant : immigrantsInCountry) {
			System.out.println(++count + " " + immigrant);
		}
	}

	public void printDeadBombers() {
		System.out.println("Dead bombers:");
		int count = 0;
		for (Immigrant immigrant : immigrantsInCountry) {
			if (immigrant.isDead()&&immigrant.hasBomb()) {
				System.out.println(++count + " " + immigrant);
			}
		}
	}

}
