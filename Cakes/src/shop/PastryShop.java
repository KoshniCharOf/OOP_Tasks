package shop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import cakes.Cake;
import cakes.Kinder;
import cakes.Special;
import cakes.Standart;
import cakes.Wedding;
import clients.Client;
import clients.Order;

/**
 * Реализирайте структура от класове, която да представлява работата на сладкарница в София.
Сладкарницата съдържа следните характеристики:
• наименование;
• адрес;
• телефон за контакти;
  В сладкарницата работят доставчици, които отговарят за доставката на торти.
 *
 */
public class PastryShop {
	
	private String name;
	private String adress;
	private String phoneNumber;
	private ArrayList<Supplier> suppliers;
	private double cash;
	private ArrayList<Order> orders;
	private TreeMap<Double, Client> clients = new TreeMap<>();
	
	//Сладкарницата разполага с каталог с торти, който съдържа всички торти, които се предлагат.
	private HashMap<String,TreeMap<Cake, Integer>> cakes = new HashMap<>();
	//TODO  HashMap<String,HashMap<String, TreeSet<Cake>> cakes = new HashMap<>(); 
	
/*	Тортите са категоризирани по вид (стандартна, сватбена, специална и детска), като за всеки
	вид във витрините се съдържат подредени по тип, а за всеки тип може да има няколко торти в
	наличност. Стандартните и специалните торти са подредени по цена, в низходящ ред, а
	сватбените и детските – по брой парчета.*/
	
	public PastryShop(String name, int cakesCount) {
		this.name = name;
		for (int i = 0; i < 5; i++) {
			this.suppliers.add(new Supplier());	
		}
		for (int i = 0; i < cakesCount; i++) {
			storeCake(makeCake());
		}
		this.suppliers = new ArrayList<>();
		this.orders = new ArrayList<>();
		this.clients = new TreeMap<>();
	}
	
	private Cake makeCake(){
		Cake c = null;
		switch (new Random().nextInt(4)) {
		case 0:
			return new Standart();
		case 1:
			return new Special();
		case 2:
			return new Kinder();
		case 3:
			return new Wedding();
		default:
			return c;
		}
	
	}

	private void storeCake(Cake c){
		if(!this.cakes.containsKey(c.getType())){
			this.cakes.put(c.getType(), new TreeMap<>());
		}
		for (Entry<String, TreeMap<Cake, Integer>> it : this.cakes.entrySet()) {
			if(it.getKey().equals(c.getType())){
				if(!it.getValue().containsKey(c)){
					it.getValue().put(c, 1);
					break;
				}
				for (Entry<Cake, Integer> it2 : it.getValue().entrySet()) {
					if(it2.getKey().equals(c)){ // I know this block is useless now 
						//But every cake is unique :)
						it2.setValue(it2.getValue()+1);
						break;
					}
				}
			}
		}
	}
	
	public void takeOrder(Order order){//order s cena i bez cena
		if(order == null){
			System.out.println("Next client, please!");
			return;
		}
		this.orders.add(order);// to print sum
		Supplier s = this.suppliers.get(new Random().nextInt(suppliers.size()));
		System.out.println("Supplier is "+s);
		s.getOrders().add(order);
		this.packCakes(order);
		this.sendSupplier(s);
	}
	
	private void sendSupplier(Supplier supp){//drama method-  he can out or I can add some logic here
		System.out.println("\n"+this.name+ " has sent "+supp);
		supp.deliver();
	}
	
	private ArrayList<Cake> packCakes(Order o){
		ArrayList<Cake> packedCakes = new ArrayList<>();
		for (Cake c : o.getOrderedCakes()) {
			for (Entry<String, TreeMap<Cake, Integer>> en : this.cakes.entrySet()) {
				if(c.getType().equals(en.getKey())){
					for (Entry<Cake, Integer> en2 : en.getValue().entrySet()) {
						if(c.equals(en2.getKey()) && en2.getValue()>0){
							System.out.print("\n"+en2.getKey()+" Packed");
							packedCakes.add(en2.getKey());
							//I can make Sale later this day
							o.updatePrice(en2.getKey().getPrice());//that's why this method exist:)
							en2.setValue(en2.getValue()-1);
						}
					}
				}
			}
		}
		return packedCakes;
	}
	
	public void recieveCashFrom(double cash, Client c) {
		System.out.println(this.name+" has recieved "+cash);
		this.clients.put(cash, c);//  for task 10
		this.cash += cash;
	}
	
	public void printCakes(){
		for (Entry<String, TreeMap<Cake, Integer>> ent : this.cakes.entrySet()) {
			System.out.println("===="+ent.getKey()+"==== Number : "+ent.getValue().entrySet().size());
			for (Entry<Cake, Integer> ent2 : ent.getValue().entrySet()) {
				Cake c = ent2.getKey();
				System.out.println(c.getKind()+" price: "+c.getPrice()+" pieces: "+c.getPiecesCount()+" number:"+ent2.getValue());
			}
		}
	}
	
	public HashMap<String, TreeMap<Cake, Integer>> getCakes() {
		return cakes;
	}
	
	public void showOrdersTurnOver(){
		int total = 0;
		for (Order order : orders) {
			total+=order.getPrice();
		}
		System.out.println("Orders sum = "+total);
	}
	
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}
	
	public void printTheMostWantedSupplierAndLetHimCloseTheDoor(){
		Collections.sort(this.suppliers, new Comparator<Supplier>() {

			@Override
			public int compare(Supplier o1, Supplier o2) {
				
				return o2.getDeliveries()-o1.getDeliveries();
			}
		});
		Supplier s = this.suppliers.get(0);
		System.out.println(s+" deliveries: "+s.getDeliveries());
	}
	public void printBestSellerType(){
		//TODO FIND CLEVER WAY
		int max = 0;
		int current = 0;
		String kind = null;
		String best = null;
		for (Order o : orders) {
			for (Cake c : o.getOrderedCakes()) {
				kind = c.getKind();
				current++;
				for (Order o1 : orders) {
					for (Cake c1 : o.getOrderedCakes()) {
						if(kind.equals(c1.getKind())){
							current++;
						}
					}
				}
				if(current > max){
					best = kind;
					max = current;
				}
				current= 0;
			}
		}
		System.out.println("Best selling type: "+best);
	}
	
	public void printBestClient(){
		System.out.println(this.clients.lastEntry());
	}
}
