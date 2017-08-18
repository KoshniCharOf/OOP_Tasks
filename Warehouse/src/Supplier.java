import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 */

/**
 * �� �� ������� �����, ����� ������ ��������� �� ����� � ������. ����������� �
 * ��������� �� �������� ������ � ��������� ����� ������� ��� ����� ����� �����
 * ��� ���������� ���� �� ������.
 * 
 *
 *
 */

public class Supplier {

	
	private String name = "Suplier ";
	private Warehouse client;
	
	
	public Supplier(Warehouse client) {
		super();
		this.client = client;
	}


	public void deliverGoods(ArrayList<String> namesOfProducts) {
		for (Entry<String, HashMap<Product, Integer>> en : client.getGoods().entrySet()) {
			for (Entry<Product, Integer> en2 : en.getValue().entrySet()) {
				for (String prodName : namesOfProducts) {
					if(en2.getKey().getName().equals(prodName)){
						en2.setValue(en2.getValue()+25); //supplier create products:) He is God in the project
						System.out.println(this.name+ " delivered "+25+" "+prodName+" to "+this.client.getName());
					}
				}
			}
		}
	}
	
	

}
