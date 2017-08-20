package shop_and_buyer;

import java.util.HashMap;
import java.util.Map.Entry;

import products.Product;


/**
 * 
 *В магазина могат да пазаруват купувачи. Всеки купувач има следните характеристики:
* Магазин, в който е влязал да пазарува;
* Сума пари, която носи със себе си;
* Максимален брой артикули, които може да купи.
 */
public class Buyer {
	
	private Shop shop;
	private double money;
	private int maxProducts;
	private HashMap<Product, Integer> bag;
	
	/*5. Създаване на купувачи с предварително подадени магазин, брой продукти за
	пазаруване и пари в наличност.*/
	public Buyer(Shop shop, double money, int maxProducts) {
		super();
		this.shop = shop;
		this.money = money;
		this.maxProducts = maxProducts;
		this.bag = new HashMap<Product, Integer>();
	}
	
	/*Всеки купувач може да извършва следните действия:
* Да добавя продукт на килограм към количката си;
* Да добавя продукт на бройки в количката си;
* Да премахва продукт на килограм от количката си;
* Да премахва продукт на бройки от количката си.*/
	public void addProduct(Product p, int quantity){
		if( this.bag.size() < maxProducts && enoughSupply(p, quantity)){
			this.bag.put(p, quantity);
			this.shop.removeProduct(p, quantity);
			System.out.println(this.bag.get(p)+" "+p+" is added in the bag");
		}else{
			System.out.println(p +" not added ");
		}
	}
	
	public void removeProduct(Product p , int quantity){
		if(this.bag.size()>0 && validBag(p, quantity)){
			int newQuantity = bag.get(p)-quantity;
			if(newQuantity>0){
				bag.put(p, newQuantity);
				System.out.println(quantity+" "+p+" removed");
			}
			else{
				System.out.println(quantity+" "+p+" removed");
				bag.remove(p);
			}
			this.shop.loadShop(p, this.shop.getProducts().get(p)+quantity);
		}else{
			System.out.println(p+" not removed");
		}
	}
	
	public void emptyBag(){
		for (Entry<Product, Integer> it : bag.entrySet()) {
			this.shop.loadShop(it.getKey(), it.getValue());
			this.bag = new HashMap<>();
		}
	}
	
	public void pay(){
		double sum = 0;
		for ( Entry<Product, Integer> entry: bag.entrySet()) {
			System.out.println(entry.getValue()+" "+entry.getKey());
			System.out.println(" "+entry.getValue() * entry.getKey().getPrice()+" lv");
			sum+=entry.getValue() * entry.getKey().getPrice();
			
		}
		
		if(sum<=this.money){
			this.money-=sum;
			this.shop.collectMoney(sum);
			System.out.println(sum+"lv transaction is Successful \n");
		}else{
			System.out.println("you don't have enough money to pay the bill");
			emptyBag();
		}
	}
	
	private boolean enoughSupply(Product p, int quantity){
		return this.shop.getProducts().containsKey(p) 
				&& this.shop.getProducts().get(p)>=quantity;
	}
	
	private boolean validBag(Product p , int quantity){
		return this.bag.containsKey(p) && this.bag.get(p)>=quantity;
	}
	

}
