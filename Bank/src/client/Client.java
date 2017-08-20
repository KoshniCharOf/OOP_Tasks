
package client;

import java.util.ArrayList;
import java.util.Random;

import bank.Bank;
import bankProducts.BankProduct;
import bankProducts.Credit;
import bankProducts.Deposit;
import demo.Val;

/**
 *
 *В банка може да откриват депозитни или кредитни сметки клиенти на банката. Всеки клиент
има следните характеристики:
• Име
• Адрес
• Парична наличност (пари в брой)
• Месечна заплата в лева
• Списък с Банкови депозити
• Списък с Банкови кредити
 */
public class Client {

	private String name;
	private double cash;
	private double salary;
	private	ArrayList<Deposit> deposits;
	private	ArrayList<Credit> credits;
	
	public Client(double cash, double salary) {

		this.cash = Val.validDouble(cash);
		this.salary = Val.validDouble(salary);
		this.deposits = new ArrayList<>();
		this.credits = new ArrayList<>();
	}
	
	
	//Клиента може да извършва следните операции:
	//• Може да открива депозит за определена сума и определен период
	public void makeDeposit(double аmount, int period, Bank bank){
		
		if(this.cash >= аmount){
			
			Deposit d = null;
			if(period > 3){
				d = new Deposit("Long deposit", 5, period);
			}else{
				d = new Deposit("Short Deposit", 3, period);
			}
			d.setCash(аmount);
			this.deposits.add(d);
			bank.acceptDeposit(d);
			this.cash -= аmount;
		}
		else{
			System.out.println("Not enough money");
		}
		/*Един клиент може да остави парите си на депозит само ако паричната му наличност е
положителна. Когато човек реши да остави парите си на депозит, тогава паричната му
наличност в брой се намалява с парите за депозита, а банковата парична наличност се
увеличава със сумата на депозита.*/
		
	}
	
	//• Може да иска отпускането кредит
	/*Един клиент може да вземе кредит от банка по всяко време само ако общата сума на
месечните вноски по всичките му кредити не е повече от 50% от заплатата му. Банката може
да отпусне кредит на клиента само ако паричната наличност на банката минус сумата на
кредита е по-голяма от 10% от общата сума на депозитите в банката. Когато банката отпусне
кредит на клиент тогава паричната наличност на клиента в брой се увеличава с сумата на
кредита, а паричната наличност на банката се намалява със сумата на кредита.*/
	
	public void askCredit(Bank bank, double amount, int period){
        //Home Credit с лихва 6% и Consumer Credit с лихва 10%. Като
		Credit credit = new Random().nextBoolean()? new Credit("Consumer Credit", 10, 1):
													new Credit("Home Credit", 6, 1);
		credit.setCash(amount);
		credit.setPeriod(period);
		
		if(goodPercentOfSalary(amount) && bank.giveCredit(credit)){
			this.credits.add(credit);
			this.cash+=credit.getCash();	
		}
		
	}
	private boolean goodPercentOfSalary(double amount){
		double sum = amount;
		for (Credit c : this.credits) {
			sum += c.getCash();
		}
		return sum < this.salary/2;
	}
	//• Може да внася пари по кредити.
	public void makePayment(Credit c){
		
	}

	public double getCash() {
		return cash;
	}

	@Override
	public String toString() {
		StringBuilder products = new StringBuilder();
		for (BankProduct p : this.deposits) {
			products.append(" "+p);
		}
		for (BankProduct p : this.credits) {
			products.append(" "+p);
		}
		return "Client cash: " + cash + " salary " + salary +"\n"+ products;
	}
	
}
