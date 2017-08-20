import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

/**
 * 
 */

/**
 * Да се създадат три обекта, които описват магазини за продажба на стоки. Магазините имат
продукти в наличност, като типовете и информацията за всеки продукт е аналогична на тези в
склада. Магазинът е отговорен за това да вземе стока от склада, когато количеството й падне
под определен минимален праг за този магазин.
 *
 */
public class Store {
	
	private String name;
	private static final int DEFICIT = 2;
	private static int id = 33;
	private static String checkoutClient;
	private Warehouse warehouse;
	private ArrayList<Client> clients = new ArrayList<>();
	private HashMap<String, HashMap<Product, Integer>> merchandise = new HashMap<>();

	public Store(Warehouse warehouse) {
		this.name = "Store "+id++;
		for (int i = 0; i < Product.names.length; i++) {
			for (int j = 0; j < Product.names[i].length; j++) {
				
				String name = Product.names[i][j]; 
				Product p = new Product(name);
				
				if (!merchandise.containsKey(p.getType())) {
					merchandise.put(p.getType(), new HashMap<>());
				}
				this.merchandise.get(p.getType()).put(p, 0);
			}
		}
		this.warehouse = warehouse;
	}
	
	private void checkStock(){
		for (Entry<String, HashMap<Product, Integer>> en : merchandise.entrySet()) {
			for (Entry<Product, Integer> en2 : en.getValue().entrySet()) {
				if(en2.getValue() < DEFICIT){
					String name = en2.getKey().getName();
					System.out.println(this.name + " ordered "+name);
					int newStock = this.warehouse.deliverProducts(name);
					System.out.println(this.warehouse.getName()+" delivered "+newStock+" "+name+" in "+this.name);
					en2.setValue(en2.getValue()+newStock);
				}
			}
		}
	}

	public void openStore(){
		for (Client client : clients) {
			Store.checkoutClient = client.getName();//I know it is really bad, but now working:)
			this.sell(client.buy());
			//System.out.print(client.getName());
		}
	}
	private void sell(String name){
		checkStock(); // in my store nobody wait(just can't make that)
		int bought = new Random().nextInt(4)+1;
		for (Entry<String, HashMap<Product, Integer>> en : merchandise.entrySet()) {
			for (Entry<Product, Integer> en2 : en.getValue().entrySet()) {
				if(en2.getKey().getName().equals(name)){
					en2.setValue(en2.getValue()-bought);
					System.out.println(this.name+" sold "+bought+" of "+name);
				}
			}
		}
		System.out.println(checkoutClient+" bought "+bought+" of "+name);
	}
	public ArrayList<Client> getClients() {
		return clients;
	}

	@Override
	public String toString() {
		return "Store "+ name ;
	}
	
	

}
