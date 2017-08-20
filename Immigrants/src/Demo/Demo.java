package Demo;

import java.util.ArrayList;

import java.util.Random;
import country.Country;
import country.Passport;
import immigrants.Extremist;
import immigrants.Immigrant;
import immigrants.Normal;
import immigrants.Radical;
import weapons.Bomb;
import weapons.Gun;
import weapons.Kalashnik;
import weapons.Weapon;

public class Demo {
	public static Random random = new Random();

	public static void main(String[] args) {

		// 1. Създава държава с 5 града в нея. Нека на произволен принцип да се
		// зададат броя жители, да се генерират на произволен принцип и
		// полицейски служители, които да се разпределят по равно в градовете.

		Country bg = new Country("BG");

		/*
		 * 2. Създава 100 имигранта, като на произволен принцип трябва да бъдат
		 * нормални, екстремисти или радикални. Вероятността да се създаде
		 * радикалист трябва да е 25%, екстремист – 35% , а нормален имигрант –
		 * 40%. Да им се зададат произволни имена и произволна сума пари в евро,
		 * както и паспорт където е възможно. Радикалните имигранти трябва да
		 * имат 35% шанс да имат паспорт. Нека всеки да има по 2 роднини от
		 * останалите имигранти зачислен на произволен принцип.
		 */
		ArrayList<Immigrant> immigrants = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			int chance = random.nextInt(100);
			Passport p = new Passport("Osman Dimitrov Atkinson", 105, "Manila");

			if (chance < 40) {
				immigrants.add(new Normal(bg, p, new ArrayList<>()));// relatives
																		
			}
			if (chance >= 40 && chance < 65) {
				immigrants.add(new Radical(bg, random.nextInt(100) < 35 ? p : null, new ArrayList<>()));
			} else {
				immigrants.add(new Extremist(bg, new ArrayList<>()));
			}
		}
		// add 2 relatives
		for (Immigrant immi : immigrants) {
			ArrayList<Immigrant> relatives = new ArrayList<>();
			for (int i = 0; i < 2; i++) {
				relatives.add(immigrants.get
						(random.nextInt(immigrants.size())));
			}
			immi.addRelatives(relatives);
		}
		/*
		 * 3. Да се създадат 200 оръжия на произволен принцип. Нека всеки
		 * имигрант да пробва да купи произволни 5 от тях, като ако 1 оръжие е
		 * продадено, не се продава пак.
		 */
		ArrayList<Weapon> weapons = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			switch (random.nextInt(3)) {
			case 0:
				weapons.add(new Bomb(2000));
				break;
			case 1:
				weapons.add(new Gun(500));
				break;
			case 2:
				weapons.add(new Kalashnik(1111));
				break;
			}
		}
		
		// всеки имигрант да пробва да купи произволни 5 от тях
		for (Immigrant immi : immigrants) {
			for (int i = 0; i < 5; i++) {
				if (weapons.size() > 0) {
					Weapon w = weapons.get(random.nextInt(weapons.size()));
					if (!immi.buyWeapon(w)) {
						break;
					}
					weapons.remove(w);
				}
			}
		}
		/*
		 * 4. Нека всички имигранти на произволен принцип да имигрират в някой
		 * град. Когато имигрант мигрира на произволен принцип се зачислява
		 * полицейски служител, който проверява паспорта му.
		 */

		for (Immigrant immi : immigrants) {
			immi.immigrate(bg);
		}

		/*
		 * 5. Да се изведе за всеки имигрант, града в който пребивава в момента,
		 * дали притежава паспорт, парите с които разполага и имената на
		 * роднините му.
		 */
		// for (Immigrant immi : immigrants) {
		// System.out.println(immi);
		// }
		/*
		 * 6. На произволен принцип да се изберат 20 имигранти, които да стрелят
		 * или да се взривят ако притежават бомба.
		 */
		System.out.println("   TERROR START  "+bg.getImmigrantsInCountry().size());
		for (int i = 0; i < 20; i++) {
			Immigrant ivancho = bg.getImmigrantsInCountry().get(random.nextInt(bg.getImmigrantsInCountry().size()));
			System.out.println(ivancho.getName());
			ivancho.shootThem();
		}
		/*
		 * 7. Да се изведат градовете сортирани по брой оцелели жители в тях,
		 * имигрантите - по брой пари, както и всички имигранти, които са имали
		 * бомба, но вече са я взривили.
		 */
		bg.printCities();
		//bg.printImmigrants();
		bg.printDeadBombers();
	}

}
