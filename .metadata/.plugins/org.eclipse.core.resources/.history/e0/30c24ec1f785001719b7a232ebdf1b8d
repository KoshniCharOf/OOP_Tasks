/**
 * 
 */
package merchants;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;

import products.Product;
import supliers.Supplier;
import tradeObjects.TradeObject;


 
//  Реализирайте структура от класове, която да представлява работата на търговци
//  в София. Всеки търговец съдържа в себе си следните характеристики: 1.
//  Наименование 2. Адрес на регистрация 3. Капитал – начална сума за започване на
//  бизнес. 4. Търговски обект, където оперира (един или няколко) 5. Доставчик, от
//  който зарежда стоки (един или няколко)
  
//  ================= NO MARKER INTERFACES THIS TIME ================= 
//   В София оперират различни
//  видове търговци: 1. Амбулантен търговец – той не оперира в определен търговски
//  обект и работи с един доставчик на дребно. 2. ЕТ – едноличен търговец – той
//  оперира само с доставчици на дребно (не повече от 5) и притежава един
//  търговски обект. ЕТ може да притежава бутка на улицата или сергия на пазара.
//  3. Търговска верига – работи с много доставчици на дребно и на едро (не повече
//  от 15) и има много търговски обекти (не повече от 10). Притежава както будки,
//  така и магазини в моловете.
// 
public abstract class Merchant {
	protected String name;
	protected String adress;
	protected double capital;
	protected int trades;
	protected double taxPaid;
	protected ArrayList<TradeObject> tradeObject;
	protected ArrayList<Supplier> supplier;

	public Merchant(double capital, String name) {
		if (name != null) {
			this.name = name;
		} else {
			this.name = "Merchant";
		}

		this.capital = capital < 0 ? 0 : capital;
		this.tradeObject = new ArrayList<>();
		this.supplier = new ArrayList<>();
	}

	public abstract void addTradeObject(TradeObject to);

	public abstract void addSuplier(Supplier supp);

	// Всеки търговец може да изпълнява следните действия:
	// - да прави поръчка на определена стойност към доставчик. Поръчката не
	// може да надвишава 50% от капитала на търговеца. Ако доставчика
	// направи отстъпка, разликата в парите да се върне обратно на търговеца.
   //	При поръчка на стоки от доставчик, търговеца приема в търговския обект
	// списък с произволно генериран брой продукти, като всеки продукт има
	// наименование и произволна цена между 5 и 15 лева. Общата цена на
	// продуктите представлява стойността на доставката.
	public void placeOrder(TradeObject to, double sum) {
		if (sum > this.capital / 2 || sum < 5) {
			System.out.println(this.name + ", sum: " + sum + " risk is too much, you need diversification");
			return;
		}
		Supplier s = this.supplier.get(new Random().nextInt(this.supplier.size()));

		double total = 0;
		ArrayList<Product> goods = new ArrayList<>();
		int count = 1000;//around 1000 tries to make exact sum
		while (total <= sum && --count > 0) {
			Product p = new Product();
			if (p.getPrice() + total > sum) {
				continue;
			}
			goods.add(p);
			total += p.getPrice();
		}
		// to.setBalance(-total * s.getDiscount());
		this.capital -= total * s.getDiscount();
		this.addGoods(to, goods);// here is the magic of my Bagman abstraction
		printGoods(goods);
		System.out.printf("Total: " + total + " " + this.name + " has saved  %.2f lv \n",
				(total - total * s.getDiscount()));

	}

//	- да прибира оборот от търговския обект – 130% от стойността на поръчаните стоки.
//	(дефакто търговците имат 30% надценка).
//	Оборотът представлява печалбата от произволен брой продадени артикули.
	public double getTurnover(TradeObject to) {

		double turnover = 0;
		if (to.getGoods().size() > 0) {
			
			for (int i = 0; i < new Random().nextInt(to.getGoods().size()); i++) {
				Product sold = to.getGoods().remove(new Random().nextInt(to.getGoods().size()));
				turnover += sold.getPrice() * 1.3;
				this.trades++;
			}
		}

		this.capital += turnover;
		to.setBalance(turnover);
		return turnover;
	}

	// - да плаща данъци на държавата за съответния търговски обект.
	public void payTaxes(TradeObject t) {
		// System.out.println("Sales detected! Pay your taxes mr. Petriot or go
		// to jail");//realy big drama
		this.capital -= t.getTax() / 12;
		this.taxPaid += t.getTax() / 12;
		System.out.printf("You have paid  %.2f  tax. \n", t.getTax() / 12);
	}

	protected void addGoods(TradeObject to, ArrayList<Product> p) {
		System.out.println("Adding in "+to);
		to.addGoods(p);
	}

	private void printGoods(ArrayList<Product> p) {
		Collections.sort(p, ( o1,  o2) -> o1.getPrice() - o2.getPrice());

		System.out.println("=====GOODS====");
		for (Product product : p) {
			System.out.println(product);
		}
	}

	public ArrayList<TradeObject> getTradeObject() {
		return tradeObject;
	}

	public double getCapital() {
		return capital;
	}

	public String getName() {
		return name;
	}

	public int getTrades() {
		return trades;
	}

	public double getTaxPaid() {
		return taxPaid;
	}

	@Override
	public String toString() {
		return name;
	}

}
