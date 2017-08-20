/**
 * 
 */
package tradeObjects;

import java.util.ArrayList;

import products.Product;

/**
 *  Търговските обекти съдържат следните характеристики:
 *  • адрес 
 *  • работно време
 *  • площ
 *  • данък към държавата.
 * 
 *         Търговски обекти биват: 1. сергия на пазара – площ между 2 и 10
 *         квадратни метра. Годишен данък към държавата в размер на 50 лева. 2.
 *         магазин в мола – площ между 10 и 100 квадратни метра. Годишен данък
 *         към държавата в размер на 150 лева. 3. будка на улицата – площ между
 *         4 и 6 квадратни метра. Годишен данък към държавата в размер на 50
 *         лева.
 */
public abstract class TradeObject {
	protected String name;
	protected String workHours;
	protected int area;
	protected double tax;
	protected ArrayList<Product> goods = new ArrayList<>();
	protected double balance;

	public TradeObject(String name, int area) {
		if(name!= null){
			this.name = name;
		}else{
			this.name = "Trade Object";
		}
		
		this.area = validArea(area);
		this.tax = validTax(tax);
	}

	public abstract int validArea(int area);

	public abstract double validTax(double tax);

	public boolean isETTrObject() {
		return true;
	}

	public boolean isChainTrObject() {
		return true;
	}

	public void addGoods(ArrayList<Product> g) {
		
		this.goods.addAll(g);
	}

	public ArrayList<Product> getGoods() {
		return goods;
	}

	public double getTax() {
		return tax;
	}

	public void setBalance(double balance) {
		if(balance >= 0){
			this.balance += balance;
		}
		
	}

	@Override
	public String toString() {
		return name + " balance: " + balance;
	}

}
