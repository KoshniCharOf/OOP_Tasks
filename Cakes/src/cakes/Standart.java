/**
 * 
 */
package cakes;

import java.util.Random;

/**
 * Тортите биват:
1. стандартна торта (бисквитена, еклерова, плодова и шоколадова);

 *
 */
public class Standart extends Cake {

	private enum Kind {BISQUIT, ECLER, FRUIT, CHOCOLATE}
	private Kind kind;
	//Стандартната торта може да бъде сиропирана или не.
	private boolean isSyrupy;

	public Standart() {
		super();
		this.kind = Kind.values()[new Random().nextInt(Kind.values().length)];
		this.price = (piecesCount)*3;//3lv for a piece
	}



	@Override
	public String getType() {
		return "Standart";
	}

	
	@Override
	public String getKind() {
		return this.kind+"";
	}

	@Override
	public String getSpecialValue() {
		
		return (this.isSyrupy?" ":"not ")+"syrupied";
	}

}
