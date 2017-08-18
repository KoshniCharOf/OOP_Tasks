package products;
/**
 * 
 */

/**
 * @author NIE
 * sold by number
 */
public class NumProd extends Product{
	public enum TypoNum{BEER, BOOK, STOOL}
	private TypoNum type;
	
	public NumProd(String name, double price, int quantity, TypoNum type) {
		super(name, price, quantity);
		this.type = type;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " num "+type+" "+ super.toString();
	}




	
	
	
}
