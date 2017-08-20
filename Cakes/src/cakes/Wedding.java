/**
 * 
 */
package cakes;

import java.util.Random;



/**
 * 2. сватбена торта (голяма, малка и средна);
 *
 */
public class Wedding extends Cake  {

	private enum Kind {BIG, NORMAL, SMALL}
	private Kind kind;
	//Сватбената торта съдържа информация за това на колко етажа е.
	private int levels = new Random().nextInt(10)+1;

	public Wedding() {
		//TODO KIND DEPEND ON LEVELS AND PIECES 
		this.kind = Kind.values()[new Random().nextInt(Kind.values().length)];
		this.price = (piecesCount)*levels*3;//3lv/piece
		
	}
	
	@Override
	public String getType() {
		return "Wedding";
	}

	
	
	@Override
	public String getKind() {
		
		return this.kind+"";
	}


	
	@Override
	public int compareTo(Cake o) {
		if(this.getKind().equals(o.getKind())){
			return this.piecesCount - o.piecesCount;
		}
		return this.getKind().compareTo(o.getKind());
		
	}

	@Override
	public String getSpecialValue() {
		
		return "Levels: "+this.levels;
	}

}
