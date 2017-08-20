
package citizens;

/**
 * Обвиняемия и Обвинителя трябва да имат списък с адвокати. В списъка не може да има повтарящи се адвокати.
 *
 */
public class Accuser extends Citizen  {

	
	
	public Accuser(String name, int age) {
		super(name, age);
	}


	@Override
	public String toString() {
		return "Accuser [name=" + name + "]";
	}
	
}
