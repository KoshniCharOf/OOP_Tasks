package shop_and_buyer;

import java.util.HashMap;
import java.util.Map.Entry;

import products.Product;


/**
 * 
 *Магазинът има следните характеристики:
* Наименование;
* Адрес;
* Пари в касата;
* Списък с продукти.
 */
public class Shop {

	private String name;
	private String adress;
	private double cash;
	private HashMap<Product, Integer> products;
	
	public Shop(String name, String adress, double cash, HashMap<Product, Integer> products, int size) {
		super();
		this.name = validString(name);
		this.adress = validString(adress);
		this.cash = validNum(cash);
		if(validRoom(products, size)){
			this.products = products;
		}else{
			this.products = new HashMap<>();
		}
		
	}
	
	private String validString(String s){
		if(s!=null && !s.isEmpty()){
			return s;
		}
		return "unknown";
	}
	
	private double validNum(double num){
		return num >= 0? num: (num*-1);
	}
	
	private boolean validRoom(HashMap<Product, Integer> prod, int size){
		return prod.size() <= size;
	}
	
	public void printGoods(){
		System.out.println("====Availability====");
		for (Entry<Product, Integer> it : products.entrySet()) {
			System.out.println(it.getValue()+" "+it.getKey());
		}
		System.out.println();
	}
	
	public void loadShop(Product p, int quantity){
		this.products.put(p, quantity);
	}
	
	public void removeProduct(Product p, int quantity){
		int updatedQuantity = this.products.get(p)- quantity;
		if(updatedQuantity > 0){
			this.products.put(p, updatedQuantity);
		}else{
			
			this.products.put(p, 0);
		}
	}
	
	public HashMap<Product, Integer> getProducts() {
		return products;
	}
	
	public void collectMoney(double sum){
		this.cash += sum;
	}
	
}
