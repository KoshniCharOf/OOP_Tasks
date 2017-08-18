/**
 * 
 */
package estates;

import java.util.Random;

import agency.Agent;
import client.Client;

/**
 *����� ���� ������� �������� ��������������:
� ��������;
� �����;
� ���� �� �����;
�
� ���� (��.�.);
� �����, ����� �������� � �������������� �����.
 *
 */
public abstract class Estate implements Comparable<Estate>{
	protected String description;
	protected String adress;
	protected double price; 
	protected int area;
	protected Agent agent;
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	protected String type;
	protected Client owner;
	
	//��� �� ����� (������� ��-����);
//	������� �����:
//		1. ����������� (������, ����������, ��������, ��������, �������);
//		2. ���� (���� �� ����, ���� ����);
//		3. ������� (����, ������, ����).
	
	
	public Estate( Client owner) {
		super();
		
		this.adress = "Mladost "+new Random().nextInt(500);
		this.price = validPrice();
		this.area = validArea();
		this.owner = owner;
	}
	
	protected abstract double validPrice();
	protected abstract int validArea();
	
	@Override
	public int compareTo(Estate o) {
		
		return this.price-o.price>0?1:-1;
	}



	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public Client getOwner() {
		return owner;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Estate [ price: " + price + ", area=" + area +"]";
	}
	

}
