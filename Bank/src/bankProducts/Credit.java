
package bankProducts;


public class Credit extends BankProduct {

	/**
	 * @param name
	 * @param interest
	 * @param period
	 */
	
	private double payment;
	

	public Credit(String name, int interest, int period) {
		super(name, interest, period);
		
	}

	public double getPayment() {
		return this.cash * this.interest/100 / this.period;
	}

	

	
	

}
