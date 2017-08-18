import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 */

/**
 * �� �� ��������� ��������, ����� �� ������ �������� �� ����� �� �����. 
 * � ������ ��� ��������, ���� �� ����� ������� ����� ���������� �� ��� �
 * ��������� � ������. ���������� �� ��������� �� ���. 
 * ��� ��������� �� ������ �
 * ���� ������ �� ��� ��� ���� ��������: FRUITS, VEGETABLES, MEATS, ���� ��
 * ����� ��� ��� �� 15 ������� ��������� �� �������� ��������: � FRUITS: Banana,
 * Orange, Apple. � VEGETABLES: Potato, Eggplant, Cucumber. � MEATS: Pork, Beef,
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
	
	
//	� ������ ������ �� ��� ��� ������
//	1. �������� �� ����� � � ���� ����� �� ��������� ���� � ������ ��� ��������� ���
//	������ ��������� ����. ��� ��� ������, �� �� ������� ������ � �� 25 ������ �� �����
//	��������� �������. ��� ���� ��������� �����, ������� ������ �� ������ ����� �����
//	�� �� �������, �� �� ������� ������.
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
//	2. ������� �� ����� � � ���� ����� �� ������ ��� �� ����� � �� ������� ������ �� �������
//	5 ������ �� ���� �����. ��� ������� � ���������, ������� ������ �� ������                ���������?
//	������������ �� ������ � ������ �� ����� �������.
	public int deliverProducts(String name){
		checkStock();
		for (Entry<String, HashMap<Product, Integer>> en : goods.entrySet()) {
			for (Entry<Product, Integer> en2 : en.getValue().entrySet()) {
				if(en2.getKey().getName().equals(name)){
					if(en2.getValue() < DEFICIT ){//��� ������� � ���������
						ArrayList<String> del = new ArrayList<>();
						del.add(name);
						this.supplier.deliverGoods(del);// �� ������ ������������ �� ������
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
