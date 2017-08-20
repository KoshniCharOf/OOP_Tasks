import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * Да се реализира програма, която да описва работата на склад за стоки. 
 * В склада има продукти, като за всеки продукт имаме информация за име и
 * наличност в склада. Продуктите са групирани по тип. 
 *    При създаване на склада в
 * него трябва да има три типа продукти: FRUITS, VEGETABLES, MEATS, като за
 * всеки тип има по 15 единици наличност на следните продукти: • FRUITS: Banana,
 * Orange, Apple. • VEGETABLES: Potato, Eggplant, Cucumber. • MEATS: Pork, Beef,
 * Chicken
 *
 */
public class Warehouse {
	private static final int DEFICIT = 3;
	private Supplier supplier;
	private HashMap<String, HashMap<Product, Integer>> goods = new HashMap<>();
	private final String label = "Nice Warehouse";
	
	public Warehouse() {
		
		for (int i = 0; i < Product.names.length; i++) {
			for (int j = 0; j < Product.names[i].length; j++) {
				
				String name = Product.names[i][j]; //just to be more readable
				Product p = new Product(name);
				
				if (!goods.containsKey(p.getType())) {
					goods.put(p.getType(), new HashMap<>());
				}
				this.goods.get(p.getType()).put(p, 5);
			}
		}
		this.supplier = new Supplier(this);
	}
	
	
/*	В склада трябва да има два метода
	1. Доставка на стоки – в този метод се проверява дали в склада има наличност под
	указан минимален праг. Ако има такива, да се захрани склада с по 25 бройки от всеки
	дефицитен продукт. Ако няма дефицитни стоки, методът трябва да изчака някоя стока
	да се изчерпи, за да захрани склада.*/
	private void checkStock(){
		ArrayList<String> namesOfProducts = new ArrayList<>();
		for (Entry<String, HashMap<Product, Integer>> en : goods.entrySet()) {
			for (Entry<Product, Integer> en2 : en.getValue().entrySet()) {
				if(en2.getValue() < DEFICIT){
//					en2.setValue(en2.getValue()+25);  :))
					namesOfProducts.add(en2.getKey().getName());
				}
			}
		}
		if(namesOfProducts.size() > 0){
			System.out.println();
			System.out.println(this.label+" purchased : "+namesOfProducts);
			this.supplier.deliverGoods(namesOfProducts);
		}else{
			System.out.println(this.label+" is loaded enough");
		}
		
		
	}
	
/*	2. Взимане на стоки – в този метод се подава име на стока и се изисква склада да захрани
	5 бройки от тази стока. Ако стоката е дефицитна, методът трябва да изчака                дефицитна?
	захранването на склада и тогава да вземе стоката.*/
	public int deliverProducts(String name){
		checkStock();
		for (Entry<String, HashMap<Product, Integer>> en : goods.entrySet()) {
			for (Entry<Product, Integer> en2 : en.getValue().entrySet()) {
				if(en2.getKey().getName().equals(name)){
					if(en2.getValue() < DEFICIT ){//Ако стоката е дефицитна
						ArrayList<String> del = new ArrayList<>();
						del.add(name);
						this.supplier.deliverGoods(del);// да изчака захранването на склада
					}
					en2.setValue(en2.getValue()-5);
					return 5;
				}
			}
		}
		return 0;
	}


	public HashMap<String, HashMap<Product, Integer>> getGoods() {
		return goods;
	}


	public String getName() {
		
		return this.label;
	}
	
}
