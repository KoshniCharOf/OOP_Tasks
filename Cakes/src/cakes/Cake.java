package cakes;

import java.util.Random;

/**
 *Всяка торта съдържа следните характеристики:
• наименование;
• описание;
• цена;
• брой парчета;
• тип торта (описани по-долу);
• вид торта (описани по-долу).
 *
 */
public abstract class Cake implements Comparable<Cake>{
	protected String name;
	protected String description;
	protected double price;
	protected int piecesCount;
	protected String type;
	protected String kind;
	
	
	public Cake() {
		super();
		this.piecesCount = new Random().nextInt(32)+1;
	}
	
	public abstract String getType();
	public abstract String getKind();
	
	@Override
	public int compareTo(Cake o) {
		if(this.getKind().equals(o.getKind())){
			return this.getPrice()-o.getPrice()>0?-1:1;
		}
		return this.getKind().compareTo(o.getKind());
		
	}
	public double getPrice() {
		return this.price;
	}
	public int getPiecesCount() {
		return piecesCount;
	}
	
//		Стандартната торта може да бъде сиропирана или не.
//		Сватбената торта съдържа информация за това на колко етажа е.
//		Специалната торта пази в себе си името на събитието за което е създадена.
//		Детската торта пази името на детето, за което е правена.
	public abstract String getSpecialValue();
	
	@Override
	public String toString() {
		return "Cake [price " + price + ", piecesCount=" + piecesCount + ", type " + getType() +
				" kind " + getKind()
				+ " SpecialValue " + getSpecialValue() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + piecesCount;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cake other = (Cake) obj;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (piecesCount != other.piecesCount)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	

	
}
