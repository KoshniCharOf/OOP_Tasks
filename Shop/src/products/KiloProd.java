package products;
/**
 * 
 */

/**
 * @author NIE
 *sold by kilogram
 */
public class KiloProd extends Product{

	
	public enum  Type {MEAT, FISH, CHEESE}
	private Type  type;
	public KiloProd(String name, double price, int quantity, Type type) {
		super(name, price, quantity);
		this.type = type;
	}
	

	@Override
	public String toString() {
		
		return " kg "+type+" "+super.toString();
	}


}
