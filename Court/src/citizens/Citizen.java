
package citizens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


import court.Case;
import demo.Val;
import jurists.Lawyer;

/**
 * Граждани са обикновените хора, които не работят в съда, но могат да вземат участие в делото. Гражданите имат следните характеристики:
- Три имена;
- Адрес;
- Възраст;
   Възможни са три роли на гражданите в едно дело: Обвиняем, Обвинител и Свидетел.
   Обвиняемия и Обвинителя трябва да имат списък с адвокати. В списъка не може да има повтарящи се адвокати.
 *
 */
public abstract class Citizen {
	protected String name;
	protected String adress;
	protected int age; 
	protected Case casse;
	protected HashSet<Lawyer> lawers;
	
	
	public Citizen(String name, int age) {
		this.name = Val.validStr(name);
		this.age = Val.validNum(age);
		this.lawers = new HashSet<>();
		
	}
	
	public void hireLawers(ArrayList<Lawyer> lawers){
		while(this.lawers.size()<2){
			
			Lawyer law = lawers.get(new Random().nextInt(lawers.size()));
			if(!law.getCurrentCases().contains(this.casse)){
				this.lawers.add(law);
				law.getCurrentCases().add(this.casse);
			}
		}
	}


	public HashSet<Lawyer> getLawers() {
		return lawers;
	}


	public void setCasse(Case casse) {
		this.casse = casse;
	}

	


}
