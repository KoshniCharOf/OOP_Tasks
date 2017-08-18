/**
 * 
 */
package shipment;

import java.time.LocalTime;

import Town.Citizen;

/**
 * @author NIE
 *Писмата и колетите имат данни на подателя и данни на получателя
(име, фамилия и адрес).
 */
public abstract class Shipment implements Comparable<Shipment>{
	private Citizen sender;
	private Citizen reciever;
	private LocalTime stamp;
	
	public Shipment(Citizen sender, Citizen reciever) {
		this.sender = sender;
		this.reciever = reciever;
		this.stamp = LocalTime.now();
	}

	//Таксата за пускане на писмо е 0.5 лева.
	public abstract double getFee();
	public abstract int deliverTime();

	@Override
	public String toString() {
		return stamp+" sender: " + sender + ", reciever: " + reciever ;
	}
	@Override
	public int compareTo(Shipment o) {

		return this.stamp.compareTo(o.stamp);
	}

}
