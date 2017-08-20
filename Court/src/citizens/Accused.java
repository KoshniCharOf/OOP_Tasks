
package citizens;

/**
 * Обвиняемия и Обвинителя трябва да имат списък с адвокати. В списъка не може да има повтарящи се адвокати.
 *
 */
public class Accused extends Citizen {

	

	public Accused(String name, int age) {
			super(name, age);
			
	}
	
	@Override
	public String toString() {
		return "Accused [name " + name + "]";
	}
	
	
}
