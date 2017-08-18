package agency;
import java.util.ArrayList;
import java.util.HashSet;

import client.Buyer;
import client.Seller;
import common.Person;

/**
 * 
 */

/**
 * ����� ����� �������:
� ���;
� ��������� �����;
� ������ � ����������� �� �������, ����� �������� ���� (���������);
� ������ � ����������� �� �������, ����� ������ ���� (��������);
� ������ � ������, ����� �������� �� ��������� ��� �����.
 *
 */
public class Agent extends Person{

	private Agency workPlace;
	private double money;
	private HashSet<Seller> sellers;
	private HashSet<Buyer> buyers;
	private ArrayList<View> views;
	
	
	public Agent(String name, Agency workPlace) {
		super(name);
		this.workPlace = workPlace;
		this.money = 0;
		this.sellers = new HashSet<>();
		this.buyers = new HashSet<>();
		this.views = new ArrayList<>();
	}
	public void addSeller(Seller s){
		sellers.add(s);
	}
	public void addBuyer(Buyer b){
		buyers.add(b);
	}
	public ArrayList<View> getViews() {
		return views;
	}
	public Agency getWorkPlace() {
		return workPlace;
	}
	public void recieveMoney(double money){
		if(money > 0){
			this.money+=money;
		}
	}
	@Override
	public String toString() {
		return "Agent [ name=" + name + "]";
	}
	public double getMoney() {
		return money;
	}

	
}
