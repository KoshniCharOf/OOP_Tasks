
package jurists;

import java.util.ArrayList;

import citizens.Citizen;
import court.Case;

/**
 * Адвокатите трябва да са участвали поне в 10 дела.
 *
 */
public class Lawyer extends Jurist {

	private ArrayList<Case> currentCases;

	public Lawyer(String name, int servYears, int cases) {
		super(name, servYears, cases);
		this.currentCases = new ArrayList<>();
	}

	@Override
	protected void validExpirience() {
		if(this.cases < 10){
			this.cases = 10;
		}
	}

	@Override
	public void ask(Citizen c) {
		System.out.println(this+" asking "+c);
		
	}

	@Override
	public void takeNote() {
		System.out.println("Lawer take note");
		
	}

	@Override
	public int compareTo(Jurist o) {
		
		return this.name.compareTo(o.name);
	}

	public ArrayList<Case> getCurrentCases() {
		return currentCases;
	}

	@Override
	public String toString() {
		return "Lawyer [" + name + "]";
	}

	
}
