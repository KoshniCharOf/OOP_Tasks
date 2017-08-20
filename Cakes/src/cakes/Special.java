/**
 * 
 */
package cakes;

import java.util.Random;



/**
 * 3. специална торта (юбилейна, фирмена и рекламна);
 *
 */
public class Special extends Cake {

	private enum Kind {ANNIVERSARY, CORPORATE, ADVERTISING }
	private Kind kind;
	//Специалната торта пази в себе си името на събитието за което е създадена.
	private String event = "Promotion";//Just to be here, if I need it later i will change it
	
	public Special() {
		this.kind = Kind.values()[new Random().nextInt(Kind.values().length)];
		this.price = (piecesCount)*4;
	}

	@Override
	public String getType() {
		
		return "Special";
	}
	@Override
	public String getKind() {
	
		return this.kind+"";
	}
	

	@Override
	public String getSpecialValue() {
		
		return this.event;
	}

}
