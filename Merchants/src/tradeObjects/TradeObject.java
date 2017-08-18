/**
 * 
 */
package tradeObjects;

import java.util.ArrayList;

import products.Product;

/**
 * @author NIE ����������� ������ �������� �������� ��������������: � ����� �
 *         ������� ����� � ���� � ����� ��� ���������.
 * 
 *         ��������� ������ �����: 1. ������ �� ������ � ���� ����� 2 � 10
 *         ��������� �����. ������� ����� ��� ��������� � ������ �� 50 ����. 2.
 *         ������� � ���� � ���� ����� 10 � 100 ��������� �����. ������� �����
 *         ��� ��������� � ������ �� 150 ����. 3. ����� �� ������� � ���� �����
 *         4 � 6 ��������� �����. ������� ����� ��� ��������� � ������ �� 50
 *         ����.
 */
public abstract class TradeObject {
	protected String name;
	protected String workHours;
	protected int area;
	protected double tax;
	protected ArrayList<Product> goods = new ArrayList<>();
	protected double balance;

	public TradeObject(String name, int area) {
		if(name!= null){
			this.name = name;
		}else{
			this.name = "Trade Object";
		}
		
		this.area = validArea(area);
		this.tax = validTax(tax);
	}

	public abstract int validArea(int area);

	public abstract double validTax(double tax);

	public boolean isETTrObject() {
		return true;
	}

	public boolean isChainTrObject() {
		return true;
	}

	public void addGoods(ArrayList<Product> g) {
		
		this.goods.addAll(g);
	}

	public ArrayList<Product> getGoods() {
		return goods;
	}

	public double getTax() {
		return tax;
	}

	public void setBalance(double balance) {
		if(balance >= 0){
			this.balance += balance;
		}
		
	}

	@Override
	public String toString() {
		return name + " balance: " + balance;
	}

}
