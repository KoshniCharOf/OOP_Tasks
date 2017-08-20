package demo;


import java.util.ArrayList;
import java.util.Random;

import bank.Bank;
import bankProducts.Credit;
import bankProducts.Deposit;
import client.Client;

public class Demo {

	public static void main(String[] args) {
		
		//3. Да се създадат 2 депозита – Short Deposit с период от 3 месеца и лихва 3% и
		//LongDeposit с период от 12 месеца и лихва 5%.
		Deposit shortDeposit = new Deposit("Short Deposit", 3, 3);
		Deposit longDeposit = new Deposit("Long deposit", 5, 12);
		
		//4. Да се създадат 2 кредита – Home Credit с лихва 6% и Consumer Credit с лихва 10%. Като
		
		Credit homeCredit = new Credit("Home Credit", 6, 1);//периода по кредита се определя от клиента na банката.
		Credit consumerCredit = new Credit("Consumer Credit", 10, 1);
		
		//5. Да се създаде 1 банка в България
		Bank antinari = new Bank("Antinari", "Catinari Str. 1");
		
		//6. Да се създадат 10 клиенти с различни пари в брой и месечна заплата. Първоначално
		//клиентите нямат депозити и кредити. Тези клиенти да се сложат в масив $clients.
		ArrayList<Client> clients = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			clients.add(new Client(i*new Random().nextInt(10000), i*new Random().nextInt(1000)));
		}
		
		//7. Първоначално всичките 10 клиента да си сложат от 80% до 100% (на базата на
		//случайно число) парите на депозит в банката.
		for (Client c : clients) {
			double amount = c.getCash()*(new Random().nextInt(21)+80)/100;
			c.makeDeposit(amount, (int)(amount%12+1), antinari);//random period (int) (amount%12+1)
		}
		//8. След това да се изпише паричната наличност на банката както и нейния паричен резерв.
		antinari.printCash_Reserve();
		
		//9. Всеки един от тези клиенти да вземе на случаен принцип кредити от банката.
		for (Client c : clients) {
			double amount = c.getCash()*(new Random().nextInt(60))/100;
			c.askCredit(antinari, amount, new Random().nextInt(12)+1);
		}
		//10. Да се изпишат информация (всички свойства) за всички клиенти, всички депозити,
		//всички отпуснати кредити и информация за състоянието на банката.
		//a. clients
		for (Client c : clients) {
			System.out.println(c);
		}
		//b. bank
		System.out.println(antinari);
		
	}

}
