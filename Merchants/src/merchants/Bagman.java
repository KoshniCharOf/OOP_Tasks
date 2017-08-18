/**
 * 
 */
package merchants;

import java.util.ArrayList;
import java.util.Random;

import products.Product;
import supliers.Supplier;
import tradeObjects.TradeObject;

/**
 * @author NIE • Амбулантен търговец – той не оперира в определен търговски
 *         обект и работи с един доставчик на дребно.
 */
public class Bagman extends Merchant {

	private ArrayList<Product> pocket = new ArrayList<>();

	public Bagman(double capital, String name) {
		super(capital, name);
		this.tradeObject = null;
	}

	@Override
	public void addTradeObject(TradeObject o) {

	}

	@Override
	public void addSuplier(Supplier supp) {
		if (supp.getDiscount() == 1) {
			
			if(this.supplier.size() < 1){
				this.supplier.add(supp);
			}
			else if( this.supplier.size() == 1){ //change supplier
				this.supplier.set(0, supp);
			}
				
		}
		
		

	}

	public void setPocket(ArrayList<Product> pocket) {
		this.pocket = pocket;
	}

	@Override
	protected void addGoods(TradeObject to, ArrayList<Product> p) {
		System.out.println("Adding in pocket");
		this.pocket.addAll(p);
	}

	@Override
	public double getTurnover(TradeObject to) {

		double turnover = 0;

		if (this.pocket.size() < 1) {
			return turnover;
		}
		for (int i = 0; i < new Random().nextInt(this.pocket.size()); i++) {
			Product sold = this.pocket.remove(new Random().nextInt(this.pocket.size()));
			turnover += sold.getPrice() * 1.3;
			this.trades++;
		}
		this.capital += turnover;
		return turnover;
	}

	@Override
	public void payTaxes(TradeObject t) {
		System.out.println("This is discrimination I have " + (new Random().nextInt(20) + 5) + " children. "
				+ "I have rights. And first of my Ancient rights is:  no taxes for me");
	}

	@Override
	public ArrayList<TradeObject> getTradeObject() {

		return null;
	}

}
