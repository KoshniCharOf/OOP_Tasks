
package jurists;

import citizens.Citizen;


/**
 * Прокурорите имат поне 10 години стаж.
 *
 */
public class Prosecutor extends Jurist {

	
	public Prosecutor(String name, int servYears, int cases) {
		super(name, servYears, cases);
		
	}

	@Override
	protected void validExpirience() {
		if(this.servYears < 10){
			this.servYears = 10;
		}
	}

	@Override
	public void ask(Citizen c) {
		System.out.println(this+" asking "+c);
		
	}

	@Override
	public void takeNote() {
		System.out.println("Prosecutor take note");
		
	}

	@Override
	public String toString() {
		return "Prosecutor [" + name + "]";
	}
	
}
