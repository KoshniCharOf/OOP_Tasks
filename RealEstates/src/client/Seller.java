/**
 * 
 */
package client;

import java.util.Random;

import agency.Agency;
import estates.Apartment;
import estates.Estate;
import estates.House;
import estates.Terrane;

/**
 * ����������� ���� ����, ����� ����� �� ��������.
 *
 */
public class Seller extends Client  {
	
	
public Seller(String name) {
		super(name);
		this.estate = getRandomEstate();
	}

	private Estate getRandomEstate() {
		Estate e = null;
		switch (new Random().nextInt(3)) {
		case 0:
			e = new Apartment(this);
			break;
		case 1:
			e = new House(this);
			break;
		case 2:
			e = new Terrane(this);
			break;
		default:
			break;
		}
	return e;
}

	//	����� ������ ���� �� ��������� �������� ��������:
//		� ��� � �������� � �� ���������� ����� �� �� �������� � ���������. � ����� ������ ��
//		��������� �� �� ���������� ����� �� ���������� �������. ������ ����� � �������� ��
//		���������, � ������� � � ������� � ��������� �� ������.
	public void registerEstate(Agency a){
		this.agent = a.asignAgent();
		this.estate.setAgent(agent);
		a.addEstate(this.estate);
		this.agent.addSeller(this);
	}

	

	
}
