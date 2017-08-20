
package post;

import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

import shipment.Shipment;

/**
 * 
 *В пощенската станция работят пощальони и събирачи на писма.
Пощальоните имат име, фамилия и години стаж. Събирачите
на писма са младши пощальони, които имат нужда от стаж, за да
се докажат, че може да им се има доверие.(6 точки)
 */
public class Postman extends PostalWorker {

	private int deliveries;
	private Stack<Shipment> load = new Stack<>();
	
	public Postman() {
		super();
		this.setServYear(new Random().nextInt(50)+1);
	}
	//deliver parcels

	protected void loadTruck(Shipment s){
		load.push(s);
	}
	protected void spread() {

		for (Iterator<Shipment> iterator = load.iterator(); iterator.hasNext();) {
			Shipment shipment = (Shipment) iterator.next();
			System.out.println(shipment+" DELIVERED! "+shipment.deliverTime()+"mins");
			iterator.remove();
			++this.deliveries;
		}
		
	}

	public int getDeliveries() {
		return deliveries;
	}

}
