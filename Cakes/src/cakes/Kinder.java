/**
 * 
 */
package cakes;

import java.util.Random;


/**
 * 4. детска торта (за рожден ден, за кръщене и за прощапулник).
 *
 */
public class Kinder extends Cake { //in german sounds better in this case
	private enum Kind {BIRTHDAY,CHRISTENING,CHANTING}
	private Kind kind;
	private String childName = "Iren";//not used for now
	
	public Kinder() {
		this.kind = Kind.values()[new Random().nextInt(Kind.values().length)];
		this.price = (piecesCount)*2;
	}

	@Override
	public String getType() {
		
		return "Kinder";
	}

	@Override
	public String getKind() {
		
		return this.kind+"";
	}
	

	@Override
	public String getSpecialValue() {
		return this.childName;
		
	}

	@Override
	public int compareTo(Cake o) {
		if(this.getKind().equals(o.getKind())){
			return this.piecesCount - o.piecesCount;
		}
		return this.getKind().compareTo(o.getKind());
		
	}
}
