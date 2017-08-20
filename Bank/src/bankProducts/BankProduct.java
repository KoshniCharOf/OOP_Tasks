
package bankProducts;

import demo.Val;

/**
 * 
 *Всяка банкова сметка/продукт има:
• Име на сметката
•// Банковата сметка може да бъде кредит или депозит
• Годишен лихвен процент (положително число)
• Период на продукта в месеци (от 1 до 60 месеца)
• //Месечна вноска в случай на кредит
• //Месечна сума изплатена в случай на депозит
• Наличност в левове (може и да е отрицателна в случай на кредит)
 */
public abstract class BankProduct {
	
	protected String name;
	protected int interest;
	protected int period;
	protected double cash;
	
	
	public BankProduct(String name, int interest, int period) {

		this.name = Val.validStr(name);
		this.interest = Val.validNum(interest);
		this.period = Val.validNum(period);
	}


	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return  name + ", interest: " + interest + "  period: " + period + " cash: " + cash +"\n";
	}
	
	
	
	
	

}
