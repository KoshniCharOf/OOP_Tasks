
package estates;

import java.util.Random;

import client.Client;

/**
 * 2. къщи (етаж от къща, цяла къща); Апартаментите и къщите разполагат с
 * информация за вид строителство: ЕПК, Тухла, Панел или Кирпич. Къщите
 * разполагат допълнително с брой паркоместа и площ на двора.
 */
public class House extends Estate implements IBuilding {
	
	public House(Client owner) {
		super(owner);
		this.type = "House";
		this.backYardArea = new Random().nextInt(1000);
		this.parkingPlaces = new Random().nextInt(5);
		this.kind = Kind.values()[new Random().nextInt(Kind.values().length)];
		this.construction = Construction.values()[new Random().nextInt(Construction.values().length)];
	}

	private enum Kind {
		HOUSE, FLOOR
	}

	private enum Construction {
		BRICK, KIRPICH
	}

	private Kind kind;
	private int backYardArea;
	private int parkingPlaces;
	private Construction construction;

	@Override
	public String getBiuldingInfo() {

		return "" + this.construction;
	}
	
	//за къщите между 50 000 и 80 000 евро,
	@Override
	protected double validPrice() {
		
		return new Random().nextInt(30000)+50000 ;
	}

	@Override
	protected int validArea() {
		
		return new Random().nextInt(400)+100 ;
	}

	@Override
	public String toString() {
		return "House , construction=" + construction + "]"+super.toString();
	}
}
