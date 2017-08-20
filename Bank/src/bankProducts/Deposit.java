
package bankProducts;

public class Deposit extends BankProduct {

	/**
	 * @param name
	 * @param interest
	 * @param period
	 */
	private double profit;

	public Deposit(String name, int interest, int period) {
		super(name, interest, period);
		
	}

	public double getProfit() {
		return this.cash*this.interest/100/this.period;
	}
	
	

}
