
package shipment;

import Town.Citizen;

/**
 * 
 *Таксата за пускане на писмо е 0.5 лева.
 */
public class Letter extends Shipment {

	
	public Letter(Citizen sender, Citizen reciever) {
		super(sender, reciever);
		
	}

	@Override
	public double getFee() {
		
		return 0.5;
	}

	@Override
	public int deliverTime() {
		
		return 10;
	}

	@Override
	public String toString() {
		return "Letter Fee: " + getFee() + ", deliverTime: " + deliverTime() + " " + super.toString();
	}

	
}
