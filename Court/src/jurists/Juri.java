package jurists;

import citizens.Citizen;

public class Juri extends Jurist {

	public Juri(String name, int servYears, int cases) {
		super(name, servYears, cases);
		
	}

	@Override
	protected void validExpirience() {

	}

	@Override
	public void ask(Citizen c) {
		System.out.println("Juror asking");
		
	}

	@Override
	public void takeNote() {
		System.out.println("Juror take note");
		
	}

	@Override
	public String toString() {
		return "Juri [" + name + "]";
	}

	

}
