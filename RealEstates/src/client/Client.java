/**
 * 
 */
package client;

import agency.Agent;
import common.Person;

/**
 * ����� ������ ��� �������� ��������������:
� ���;
� ��������� �����;
��������� ����� ��������� � ��������.
����������� ���� ����, ����� ����� �� ��������.
���������� ���� ������, � ����� ���������� �� ������� �� ����, ����� � ������ � ������,
����� �� ���������.
 *
 *///:) big class, but I need it, not every Person (in Bulgaria) has an agent
public abstract class Client extends Person{

	public Client(String name) {
		super(name);
		
	}

	protected Agent agent;

	@Override
	public String toString() {
		return "Client [ name=" + name + "]";
	}

	
	
	
}
