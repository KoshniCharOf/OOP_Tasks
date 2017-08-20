

import java.util.ArrayList;
import java.util.HashMap;

import products.KiloProd;
import products.KiloProd.Type;
import products.NumProd;
import products.NumProd.TypoNum;
import products.Product;
import shop_and_buyer.Buyer;
import shop_and_buyer.Shop;



public class demo {
	public static void main(String[] args) {
		
		Product p = new KiloProd("shunka", 10, 2, Type.MEAT);
		HashMap<Product, Integer> products = new HashMap<>();
		products.put(p, p.getQuantity());
		Shop vsichkoPoLevche = new Shop("Levcho", "bul. Makedonia", 1000, products, 5);
		
		/*2. Създаване на различни видове стоки на килограм –Месо, Сирене, Риба. Всяка стока се
		създава с наименование, цена и количество;*/
		Product fish = new KiloProd("Skumria", 20, 5, Type.FISH);
		Product cheese = new KiloProd("nai-vonqshtoto", 5, 10, Type.CHEESE);
		Product meat = new KiloProd("Govejdo", 10, 20, Type.MEAT);
		
		/*3. Създаване на различни видове стоки на бройка –Бира, Книга, Стол. Всяка стока се
		създава с наименование, цена и количество;*/
		Product beer = new NumProd("kamenitza",2,50,TypoNum.BEER);
		Product book = new NumProd("voina i mir",33.3, 10, TypoNum.BOOK);
		Product stool = new NumProd("Kresloto ne dedo",555.55,2,TypoNum.STOOL);
		
		/*4. Добавяне на стоките в магазина;*/
		products.put(fish, fish.getQuantity());
		products.put(cheese, cheese.getQuantity());
		products.put(meat, meat.getQuantity());
		products.put(beer, beer.getQuantity());
		products.put(book, book.getQuantity());
		products.put(stool, stool.getQuantity());
		vsichkoPoLevche.printGoods();
		
		/*5. Създаване на купувачи с предварително подадени магазин, брой продукти зa
		пазаруване и пари в наличност.*/
		Buyer rachka = new Buyer(vsichkoPoLevche, 200, 2);
		Buyer nachka = new Buyer(vsichkoPoLevche, 600, 20);
		Buyer pachka = new Buyer(vsichkoPoLevche, 1000, 10);
/*		ArrayList<Buyer> buyers = new ArrayList<>();
		buyers.add(rachka);
		buyers.add(nachka);
		buyers.add(pachka);*/
		
		/*6. Добавяне на стоки към количката на купувачите;*/
		System.out.println("Добавяне на стоки към количката на купувачите");
		rachka.addProduct(book, 1);
		rachka.addProduct(beer, 2);
		rachka.addProduct(meat, 2 );
		
		nachka.addProduct(cheese, 2);
		nachka.addProduct(stool, 1);
		
		//7. Премахване на стоки от количката на купувачите;
		System.out.println("Премахване на стоки от количката на купувачите");
		nachka.removeProduct(book, 1);
		nachka.removeProduct(cheese, 2);
		
		//8. Плащане от страна на купувачите на касата на магазина;
		System.out.println("Плащане от страна на купувачите на касата на магазина");
		System.out.println();
		vsichkoPoLevche.printGoods();
		rachka.pay();
		nachka.pay();
		
		//9. Визуализиране на наличностите в магазина преди и след като е пазарувал купувача.
		vsichkoPoLevche.printGoods();
	}

}
