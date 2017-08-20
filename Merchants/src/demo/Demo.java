package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import merchants.Bagman;
import merchants.Chain;
import merchants.ET;
import merchants.Merchant;
import supliers.Retailer;
import supliers.Supplier;
import supliers.Wholesale;
import tradeObjects.Budka;
import tradeObjects.MallShop;
import tradeObjects.Sergia;
import tradeObjects.TradeObject;

public class Demo {

	public static void main(String[] args) {

		// Да се реализира демо, което:
		// 1. Създава 10 доставчика на произволен принцип – на дребно и на едро.
		ArrayList<Supplier> supps = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (new Random().nextBoolean()) {
				supps.add(new Retailer());
				continue;
			}
			supps.add(new Wholesale());
		}
		// 2. Създава 20 търговски обекта на произволен принцип – сергии,
		// магазини и будки.
		ArrayList<TradeObject> trades = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			switch (new Random().nextInt(3)) {
			case 0:					//name,         area
				trades.add(new Budka("budka " + i, i / 2 - 2)); 
				break;
			case 1:
				trades.add(new Sergia("sergia " + i, i / 2));
				break;
			case 2:
				trades.add(new MallShop("mall Shop " + i, i));
				break;
			default:
				break;
			}
		}
		
		// 3. Създава един амбулантен търговец с капитал 100 лева, един ЕТ с
		// капитал 500 лева и една търговска верига с капитал 3000 лева.
		ArrayList<Merchant> merchants = new ArrayList<>();
		merchants.add(new Bagman(100, "Bash Tarikata"));
		merchants.add(new ET(500, "Ocelyalko Survaivarski"));
		merchants.add(new Chain(3000, "International Fruit Services Inc."));
		
		// 4. Подава на търговците съответни търговски обекти на произволен
		// принцип.
		for (Merchant m : merchants) {
			for (TradeObject tradeObject : trades) {
				m.addTradeObject(tradeObject);
			}
			for (Supplier supplier : supps) {
				m.addSuplier(supplier);
			}
		}
		
		// 5. Да се извика метод, който приема списък от създадените търговци и
		// за всеки търговец се започва търговска дейност.
		startTrading(merchants);
		
		// 6. Да се изпише текущия паричен баланс на всеки обект след
		// упражняването
		// на търговска дейност.
		printBalance(merchants);
		// 7. Да се изведе търговецът с най-голям брой продадени стоки за
		// месеца.
		printMaxCountMerchants(merchants);
		// 8. Да се изведе търговецът с най-голям размер на изплатения данък към
		// държавата.
		printBestTaxPayers(merchants);
	}


	// Търговската дейност представлява:
	// ◦ поръчка на стоки от доставчик за всеки търговски обект. Да се извежда
	// на екрана списъка със стоки, сортиран по цена в нарастващ ред.
	// ◦ прибиране на оборот от всеки търговски обект – да се извежда на
	// екрана общата сума на печалбата. След продажба списъкът с
	// останалите стоки в магазина трябва отново да е сортиран по цена.
	// ◦ плащане на месечен данък към държавата за всеки търговски обект.
	public static void startTrading(ArrayList<Merchant> merch) {
		System.out.println("===START TRADING===");
		for (Merchant merchant : merch) {
			if (merchant.getTradeObject() == null) {
				trade(merchant, null);//TODO  my Bagman, this if is not best, think again
				continue;
			}
			for (TradeObject to : merchant.getTradeObject()) {
				trade(merchant, to);
			}
		}
	}
	static void trade(Merchant merchant, TradeObject to){
		merchant.placeOrder(to, merchant.getCapital() / (new Random().nextInt(10) + 1));
		double turnover = merchant.getTurnover(to);
		System.out.println("Profit : " + (turnover - turnover / turnover));
		merchant.payTaxes(to);
	}

	// 6. Да се изпише текущия паричен баланс на всеки обект след упражняването
	// на търговска дейност. 
	static void printBalance(ArrayList<Merchant> merch) {
		System.out.println("=====BALANCE====");
		for (Merchant m : merch) {
			if (m.getTradeObject() == null) {// this is my Bagman, again. But this check is not good
				System.out.println(m.getName() + " " + m.getCapital());
				continue;
			}
			for (TradeObject to : m.getTradeObject()) {
				System.out.println(m.getName() + " " + to);
			}
		}
	}

	// 7. Да се изведе търговецът с най-голям брой продадени стоки за месеца.
	static void printMaxCountMerchants(ArrayList<Merchant> merch) {
		System.out.print("7. === Most trades merchant : ");
		Collections.sort(merch, (o1,  o2)->o2.getTrades() - o1.getTrades());
		
		System.out.println(merch.get(0).getName() + " trades: " + merch.get(0).getTrades());
		
	}

	// 8. Да се изведе търговецът с най-голям размер на изплатения данък към
	// държавата.
	static void printBestTaxPayers(ArrayList<Merchant> merch) {
		System.out.print("8. === Best tax payer : ");
		Collections.sort(merch, (o1,  o2) -> o2.getTaxPaid() - o1.getTaxPaid() > 0 ? 1 : -1);
		
		System.out.printf(merch.get(0).getName() + " Tax paid:  %.2f \n", merch.get(0).getTaxPaid());
			
	}

}
