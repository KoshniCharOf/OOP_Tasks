
package library;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

import library.readings.Reading;

import java.util.TreeMap;
import java.util.TreeSet;

import demo.Val;

/**
 * 
 *	Човек може да разгледа каталогът на библиотеката,
 *	Човек може да си вземе четиво под наем от библиотеката. 
 *		Тогава на четивото му се попълва дата на взимане под наем в историята на взимания.
 *
 *	Ако човек поиска да си вземе списание за вкъщи, системата трябва да му върне прилично съобщение, че
операцията не е позволена. 

Таксата за книга под наем е 2 лева, за учебник – 3 лева, а за списание съответно няма такса,
понеже те могат да се четат само в читалнята на библиотеката.

Когато човек върне четиво в библиотеката, библиотекарят изисква да се
заплати сумата за наема плюс начислената лихва според закъснението
(ако има такова). След това системата трябва да прекъсне процеса по
проверка за закъснение, за да не се начислява повече лихва. Накрая на
четивото се записва дата на връщане в историята за последния запис, за
който е въведена дата на взимане.
 */
public class Person {
	
	private String name;
	private Queue<Reading> readings = new LinkedList<>();
	
	public Person(String name) {
		this.name = Val.validText(name);
	}
	
	//Човек може да разгледа каталогът на библиотеката,
	public void previewCatalog(Library lib){
		
			System.out.println("previewCatalog");
			for (Entry<String, TreeMap<String, TreeSet<Reading>>> it : lib.getCatalog().entrySet()) {
				System.out.println("             ="+it.getKey()+"=");
				for (Entry<String, TreeSet<Reading>> it2 : it.getValue().entrySet()) {
					System.out.println("===="+it2.getKey()+"====");
					for (Reading r : lib.getCatalog().get(it.getKey()).get(it2.getKey())) {
						System.out.println(r);
					}
				}
				System.out.println("=====================================");
			}
	}
	
/*		При избор на списания, каталогът трябва да се представя подреден по категории, като за
		всяка категория списанията са подредени по наименования и номера на броевете.
		При избор на учебници, те трябва да са подредени по теми и имена в азбучен ред.*/
	public void previewSection(Library lib, String section){
		System.out.println("preview Section");
		if(lib.getCatalog().containsKey(section)){
			System.out.println("             ="+section+"=");
			for (Entry<String, TreeSet<Reading>> it2 : lib.getCatalog().get(section).entrySet()) {
				System.out.println("===="+it2.getKey()+"====");
				for (Reading r : lib.getCatalog().get(section).get(it2.getKey())) {
					System.out.println(r);
				}
				System.out.println("=====================================");
			}
		}else{
			System.out.println("this section doesn\'t exist");
			System.out.println("Existing sections: ");
			for (String sec : lib.getCatalog().keySet()) {
				System.out.print(sec+"  ");
			}
		}
	}
	
	
/*	*Човек може да си вземе четиво под наем от библиотеката. 
	 *	Тогава на четивото му се попълва дата на взимане под наем в историята на взимания.
	 *
	 *Ако човек поиска да си вземе списание за вкъщи, системата трябва да му върне прилично съобщение, че
	операцията не е позволена. */

	public void takeReading(LocalDateTime date, Library lib, String type, String name){
		type = type.toUpperCase();
		if(!lib.getCatalog().containsKey(type)){
			System.out.println("No such type: "+type);
			return;
		}
		for (Entry<String, TreeSet<Reading>> entry : lib.getCatalog().get(type).entrySet()) {
			for (Reading r : entry.getValue()) {
				if(r.getName().equals(name) && r.isAvailable()){
					if(r.getFee()<0){
						System.out.println("You can not take this reading. Read it here only, if you want.");
						return;
					}
					System.out.println("You must return \""+r.getName()+"\" in "+r.getPeriod()+" seconds");
					this.readings.offer(r);
					r.upCountRead();
					r.getReaders().add(this);
					r.setHistory(date);
					r.setTakeDate(date);
					r.setAvailable(false);
					lib.getArchive().put(r, new HashMap<>());
					lib.getArchive().get(r).put(date, date.plusSeconds(r.getPeriod()));// date taken / due date
					
					return;
				}
			}
		}
		
		System.out.println("Not found such reading here, BE "+this.name);
	}
	
/*	Когато човек върне четиво в библиотеката, библиотекарят изисква да се
	заплати сумата за наема плюс начислената лихва според закъснението
	(ако има такова). След това системата трябва да прекъсне процеса по
	проверка за закъснение, за да не се начислява повече лихва. Накрая на
	четивото се записва дата на връщане в историята за последния запис, за
	който е въведена дата на взимане.*/
	
	//return date has to be .now but for testing I use this parameter
	public void returnReading(Library lib){
		
		double fee = lib.calculateFee(this);
		System.out.println(this.name+" pays "+fee+"lv");
		
		
	}


	public Queue<Reading> getReadings() {
		return readings;
	}

	@Override
	public String toString() {
		return name ;
	}

}
