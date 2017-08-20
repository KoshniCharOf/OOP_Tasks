/**
 * 
 */
package jurists;

import citizens.Citizen;

/**
 * Съдиите в съда имат поне 5 години стаж.
 *
 */
public class Judje extends Jurist {

	public Judje(String name, int servYears, int cases) {
		super(name, servYears, cases);
		
	}

	@Override
	protected void validExpirience() {
		if(this.servYears < 5){
			this.servYears=5;
		}
	}

	@Override
	public void ask(Citizen c) {
		System.out.println("Judje asking");
		
	}

	@Override
	public void takeNote() {
		System.out.println("Judje take note");
		
	}

	@Override
	public String toString() {
		return "Judje [name " + name + "]";
	}

}
