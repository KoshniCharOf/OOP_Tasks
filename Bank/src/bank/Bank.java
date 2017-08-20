package bank;
/*Банката има следните характеристики:
• Име
• Адрес
• Банкови продукти (депозити и кредити)
• Парична наличност (ще приемем, че банката оперира само в левове). Паричната
наличност не може да бъде по-малка от 10% от всички депозити в банката. Това се
нарича банков резерв.*/

import java.util.ArrayList;

import bankProducts.BankProduct;
import bankProducts.Credit;
import bankProducts.Deposit;
import demo.Val;

public class Bank {
	private String name;
	private String adress;
	
	private ArrayList<BankProduct> products;

	private double cash;//min 10% of all Deposits
	private double reserve ;//
	
	public Bank(String name, String adress) {
		
		this.name = Val.validStr(name);
		this.adress = Val.validStr(adress);
		this.products = new ArrayList<>();
		

	}
	
	/*Банката може да извършва следните операции:
	 * Банката може да отпуска кредити и да приема депозити на клиенти. Съответно да открива
депозитни сметка или кредитни сметки.

		• Приемане на депозит от определена сума. В такъв случай паричната наличност на
		банката се увеличава с сумата на депозита и резерва се увеличава с 90% от сумата на
		депозита*/
	public void acceptDeposit(Deposit d){
		this.cash += d.getCash();
		this.reserve+=d.getCash()*9/10;
		this.products.add(d);
	}
	
	
	/*• Изплащане на лихвите по всички депозити в банката. Банката добавя към всички
депозити сума равна на лихвата по депозита умножена по сумата на депозита. За
целта ви трябва метод, който да изчислява лихвата по депозита.*/
	
	/*• Отпускане на кредит за определена сума и за определен период в месеци. Лихвата по
кредита е фиксирана. Банката трябва да провери дали общата вноска по кредитите на
клиента не надхвърля 50% от месечната му заплата. Ако не надхвърля, банката
отпуска кредит на клиента, ако надхвърля кредита се отпуска. Ако исканата сума за
кредит надхвърля банковия резерв, банката не може да отпусне кредита. За
целта ви трябва метод, който да изчислява вноската по депозита.

ако паричната наличност на банката минус сумата на
кредита е по-голяма от 10% от общата сума на депозитите в банката.
*/
	public boolean giveCredit(Credit cred){
		if(goodReserve(cred.getCash())){
			this.cash -= cred.getCash();
			this.products.add(cred);
			return true;
		}
		
		return false;
	}


	private boolean goodReserve(double amount){
		return this.cash - amount > this.reserve;
	}
	
	public void printCash_Reserve(){
		System.out.println("Cash: "+this.cash+" Reserve:"+this.reserve);
	}
	@Override
	public String toString() {
		StringBuilder products = new StringBuilder();
		for (BankProduct p : this.products) {
			products.append(" "+p);
		}
		return "Bank :" + name + ", adress=" + adress + " products: " + "\n"+ products ;
	}
	

}
