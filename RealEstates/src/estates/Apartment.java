/**
 * 
 */
package estates;

import java.util.Random;

import client.Client;



/**
 * 1. апартаменти (студио, гарсониера, двустаен, тристаен, мезонет);
 * Апартаментите и къщите разполагат с информация за вид строителство: ЕПК,
 * Тухла, Панел или Кирпич.
 *
 */
public class Apartment extends Estate implements IBuilding {
	
	public Apartment(Client owner) {
		super(owner);
		this.type = "Apartment";
		this.kind = Kind.values()[new Random().nextInt(Kind.values().length)];
		this.construction = Construction.values()[new Random().nextInt(Construction.values().length)];
	}

	private enum Kind {
		STUDIO, GARSONIERA, ONE_BEDROOM, TWO_BEDROOM, MAISONETTE
	}

	private enum Construction {
		EPK, BRICK, PANEL
	}

	private Kind kind;
	private Construction construction;

	@Override
	public String getBiuldingInfo() {

		return "" + this.construction;

	}
	//за апартаментите – межд 70 000 и 150 000 евро;
	@Override
	protected double validPrice() {
		
		return new Random().nextInt(80000)+70000 ;
	}

	@Override
	protected int validArea() {
		
		return new Random().nextInt(200)+50 ;
	}

	public Kind getKind() {
		return kind;
	}
	@Override
	public String toString() {
		return "Apartment  " + construction + "]"+super.toString();
	}


}
