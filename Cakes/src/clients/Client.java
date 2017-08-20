package clients;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

import cakes.Cake;
import shop.PastryShop;


/**
 * Всеки клиент има следните характеристики:
• име;
• телефонен номер;
Клиентите биват корпоративни и частни.
Корпоративните имат 10% отстъпка от всички продукти.
Частните клиенти имат ваучери за покупка на торти на стойност между 10 и 30 лв. Всеки
частен клиент разполага с между един и четири ваучера.
 *
 */
public abstract class Client {
	protected String name;
	protected String phone;
	protected double money;
	protected ArrayList<Cake> myPrecious;
	protected int countOfCakes;
	
	public Client(String name) {
		super();
		this.name = name;
	}
	
	public void pay(double money) {
		System.out.println(this.name+" has paid "+money);
		this.money -= money;
	}
	
	public abstract double getMyPrice(double price);
	
	public abstract double giveTip(double price);

	public Order placeOrder(PastryShop shop, HashMap<String, TreeMap<Cake, Integer>> shopWindow) {

		ArrayList<Cake> chosen = this.chooseCake(shopWindow);
		if(chosen.isEmpty()){
			return null;
		}
		Order o = new Order(this, chosen, shop);
		System.out.println("\n"+this +" placed an order "+o);
		return o;
	}
	
	protected ArrayList<Cake> chooseCake(HashMap<String, TreeMap<Cake, Integer>> shopWindow){
		ArrayList<Cake> cakes = new ArrayList<>();
		System.out.println("\n"+this.name+" choosing");
		for (Entry<String, TreeMap<Cake, Integer>> it : shopWindow.entrySet()) {
			for (Entry<Cake, Integer> it2 : it.getValue().entrySet()) {
				if(it2.getValue()>0){//I could just add random boolean and decrement count 
					cakes.add(it2.getKey());//but I need more ... 
				}
			}
		}
		ArrayList<Cake> theChoosenOnes = new ArrayList<>();
		for (int i = 0; i < countOfCakes; i++) {
			if(cakes.isEmpty()){
				break;
			}
			theChoosenOnes.add(cakes.get(new Random().nextInt(cakes.size()))); //DRAMA
		}
		System.out.println(this.name+" orders : ");
		for (int i = 0; i < theChoosenOnes.size(); i++) {
			System.out.print(theChoosenOnes.get(i));
			if(i<theChoosenOnes.size()-1){
				System.out.println("...and then ");//dude where is my car
			}
		}
		return theChoosenOnes;
	}
	//price is calculated in the shop
//	protected double calculatePrice(ArrayList<Cake> c){
//		double d = 0;
//		for (Cake cake : c) {
//			d+=cake.getPrice();
//		}
//		return this.getMyPrice(d);
//	}

	@Override
	public String toString() {
		return "Client [name=" + name + "]";
	}
	
	

}
