package clients;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import cakes.Cake;
import shop.PastryShop;


/**
 * Всяка поръчка има следните характеристики:
• клиент;
• цена;
• адрес за доставка;
• списък с торти, които са поръчани;
• дата и час на доставката.
 *
 */
public class Order implements Comparable<Order>{
	
	private Client client; 
	private double price;
	private String adress;
	private ArrayList<Cake> orderedCakes;
	private LocalDateTime delivered;
	private PastryShop shop;
	
	public Order(Client client, ArrayList<Cake> orderedCakes, PastryShop shop) {
		super();
		this.client = client;
		this.orderedCakes = orderedCakes;
		this.adress = ""+new Random().nextInt(321)+" Sweet Str.";
		this.shop = shop;
		
	}

	public double getPrice() {
		return price;
	}
	public void updatePrice(double price) {
		this.price += price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<Cake> getOrderedCakes() {
		return orderedCakes;
	}
	public Client getClient() {
		return client;
	}
	public String getAdress() {
		return adress;
	}
	public void cashlessPaid(){
		System.out.println("Cashless paid");
		this.client.pay(this.price);
		this.shop.recieveCashFrom(this.price, this.client);
	}
	
	public void setDelivered(LocalDateTime delivered) {
		this.delivered = delivered;
	}

	@Override
	public String toString() {
		return "Order [client " + client + ", price=" + (price==0?"To be calculated":""+price) + ", orderedCakes=" + orderedCakes.size() + "]";
	}

	@Override
	public int compareTo(Order o) {
		
		return this.orderedCakes.size()-o.orderedCakes.size();
	}
	
}
