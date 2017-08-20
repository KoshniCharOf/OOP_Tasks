package immigrants;

import java.util.ArrayList;
import java.util.Random;

import country.City;
import country.Country;

import country.Passport;
import weapons.Weapon;


/**
 *  Един имигрант има следните характеристики: • Паспорт; • Начална
 *         сума пари в евро; • Град и държава, в които се намира в момента. •
 *         Списък от роднини, които също са имигранти; • Списък от оръжия с
 *         които разполага.
 */
public abstract class Immigrant {

	protected Passport passport;
	protected int money;
	protected City city;
	protected ArrayList<Immigrant> relatives;
	protected ArrayList<Weapon> weapons;
	protected String name;
	protected Country country;
	protected boolean isDead;

	public Immigrant(Country country, Passport passport, ArrayList<Immigrant> relatives) {//
		super();
		this.passport = passport;
		this.money = new Random().nextInt(10000) + 1000;
		this.country = country;
		this.country.getImmigrantsInCountry().add(this);
		if (validRelatives(relatives)) {
			this.relatives = relatives;
		} else {
			this.relatives = new ArrayList<>();
		}
		this.weapons = new ArrayList<>();
		this.weapons = filterWeapon(weapons);
		this.isDead = false;
	}

	public void addRelatives(ArrayList<Immigrant> relatives) {
		this.relatives.addAll(relatives);

	}

	protected boolean validRelatives(ArrayList<Immigrant> relatives) {
		return true;
	}

	protected ArrayList<Weapon> filterWeapon(ArrayList<Weapon> weap) {
		return weap;
	}

	/*
	 * Всеки имигрант може да изпълнява следните действия: • Да имигрира в друг
	 * град на произволен принцип от списъка с всички градове в държавата –
	 * тогава всички негово роднини имигрират също, съответно и техните роднини
	 * и т.н.
	 */
	public void immigrate(Country c) {
		if(!c.getImmigrantsInCountry().contains(this)){
			c.getImmigrantsInCountry().add(this);
		}
		int randCity = new Random().nextInt(c.getCities().size());

		c.passCityControl(this, c.getCities().get(randCity));
		if (c.getCities().get(randCity).getImmigrants().contains(this)) {
			System.out.println(this.name + ", You are already IN");
			return;
		}
		for (Immigrant immigrant : relatives) {
			c.passCityControl(immigrant, c.getCities().get(randCity));
		}

	}

	/*
	 * • Да си купи определено оръжие, като ако няма достатъчно пари възниква
	 * изключителна ситуация и имигранта умира от яд, и бива премахнат от
	 * списъка с имигранти в държавата.
	 */
	public boolean buyWeapon(Weapon weap) {
		if (this.money < weap.getPrice() && this.weapons.size()<1) {
			System.out.println(this.name + " - Painful Anger Death");
			this.country.getImmigrantsInCountry().remove(this);
			// бива премахнат от списъка с имигранти в държавата.
			
			// throw new IllegalArgumentException("I\'ll KILL MYSELF");
			this.isDead = true;
			return false;
		}
		if (this.money > weap.getPrice()){
			this.money -= weap.getPrice();
			this.weapons.add(weap);
			return true;
		}
		return false;
		
	}

	public abstract void shootThem();

	@Override
	public String toString() {
		String relativeS = "";
		for (Immigrant immigrant : relatives) {
			relativeS += " " + immigrant.getName();
		}

		return this.name + " " + (city == null ? "no City" : "" + city) + (passport != null ? " has" : " doesn't have")
				+ " passport" + ", money: " + money + ", relatives:" + relativeS + "]";
	}

	public Passport getPassport() {
		return this.passport;
	}

	public boolean hasBomb() {
		return false;
	}

	public String getName() {
		return name;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getMoney() {
		return money;
	}

	public boolean isDead() {
		return isDead;
	}
	
}
