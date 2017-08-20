package shop;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.TreeSet;

import clients.Client;
import clients.Order;


/**
 * Всеки доставчик съдържа:
• име;
• телефонен номер;
• списък с неповтарящи се поръчки, които трябва да разпрати.
 *
 */
public class Supplier implements Comparable<Supplier>{
	
	private String name;
	private String phoneNum;
	private TreeSet<Order> orders = new TreeSet<>();
	private double tips;
	private int deliveries = 0;
	
	public Supplier() {
		this.name = "Backshishi "+new Random().nextInt(50);
	}

	public void deliver(){
		
		Order o = this.orders.first();
		Client client = o.getClient();
		System.out.println(this+" delivered an order to "+client);
		o.setDelivered(LocalDateTime.now());
		double price = o.getPrice();
		o.setPrice(client.getMyPrice(price)); // update price in the order
		System.out.println("Price for this client is "+o.getPrice());
		o.cashlessPaid();//to be elegant here like POS terminal
		this.tips+=client.giveTip(o.getPrice());
		deliveries++;
	}
	
	public TreeSet<Order> getOrders() {
		return orders;
	}
	
	@Override
	public String toString() {
		return "Supplier [" + name + "]";
	}

	@Override
	public int compareTo(Supplier o) {
		
		return this.tips-o.tips>0?-1:1;
	}

	public double getTips() {
		return tips;
	}

	public int getDeliveries() {
		return deliveries;
	}

	
}
