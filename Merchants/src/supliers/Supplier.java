/**
 * 
 */
package supliers;

/**
 * @author NIE
 *Доставчиците съдържат следните характеристики:
• наименование
• адрес
• работно време

Доставчиците могат да бъдат на дребно и на едро. Доставчиците на стоки на едро
имат отстъпка от 15 процента от цената на всички стоки.
 */
public abstract class Supplier {
	protected String name;
	protected String adress;
	protected String workHors;
	protected double cash;
	
	
	public abstract double getDiscount();


	public void upCash(double cash) {
		if(cash >= 0){
			this.cash += cash;
		}
		
	}
	

}
