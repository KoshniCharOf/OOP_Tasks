
package estates;

import java.util.Random;

import client.Client;


/**
 *  За парцелите има информация дали са в регулация или не.
 *
 */
public class Terrane extends Estate {
	
	public Terrane(Client owner) {
		super(owner);
		this.type="Terrane";
		this.kind = Kind.values()[new Random().nextInt(Kind.values().length)];
		this.isReguleted = new Random().nextBoolean();
	}
	
	private enum Kind {
		FIELD, MEADOW, FOREST
	}

	private Kind kind;
	private boolean isReguleted;
	
	//за парцелите – между 30 000 и 85 000 евро.
	@Override
	protected double validPrice() {
		
		return new Random().nextInt(55000)+30000 ;
	}

	@Override
	protected int validArea() {
		
		return new Random().nextInt(10000)+500 ;
	}

	@Override
	public String toString() {
		
		return "Terrane " + kind +( isReguleted?" ":" not ") + "Reguleted "+super.toString();
	}
	
}
