
package immigrants;

import java.util.ArrayList;
import java.util.Random;


import country.Country;

import country.Passport;
import weapons.Weapon;

/**
 * 
 * 
 *         • Радикални имигранти – не винаги носят паспорт, имат неограничен
 *         брой роднини (може и да нямат), и имат максимум до 5 оръжия в себе
 *         си, но без бомби.
 * 
 */
public class Radical extends Immigrant {

	public Radical(Country country, Passport passport, ArrayList<Immigrant> relatives) {
		super(country, passport, relatives);
		this.name = "Roberto Noris Chan " + (new Random().nextInt(10000) + 10);
	}

	@Override
	protected ArrayList<Weapon> filterWeapon(ArrayList<Weapon> weap) {
		ArrayList<Weapon> filtred = new ArrayList<>();
		for (int i = 0; i < weap.size(); i++) {
			if (weap.get(i).isRadical() && filtred.size() < 5) {
				filtred.add(weap.get(i));
			}
		}
		return filtred;
	}

	/*
	 * • Ако е радикален – да почне да стреля с всичките си оръжия. Стрелянето е
	 * операция характерна за всяко оръжие, която изкарва подходящо съобщение и
	 * връща броя на изстреляните патрони. На произволен принцип да се генерира
	 * брой жертви между до 10 и 70% от изстреляните патрони. Толкова на брой
	 * хора да се махнат като жители на града.
	 */
	@Override
	public void shootThem() {
		int ammo = 0;
		if(this.weapons.size()==0){
			System.out.println("no weapon");
			return;
		}
		for (Weapon weapon : this.weapons) {
			if(weapon.isBomb()){//radical has not passed  Test 2 (bombing, collections), still
				continue;
			}
			ammo += weapon.shoot();
		}
		System.out.println(ammo+" ammo");
		int dead = (ammo * new Random().nextInt(60) + 10) / 100;
		if (this.city != null && this.country.getCities().contains(this.city)) {
			int before = this.city.getCitizens();
			this.city.setCitizens(before - dead);
		}
		System.out.println(dead + " dead  " + (this.city == null ? " in near town" : "" + city));
	}

}
