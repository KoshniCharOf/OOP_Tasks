/**
 * 
 */
package client;

import agency.Agent;
import common.Person;

/**
 * Всеки клиент има следните характеристики:
• име;
• телефонен номер;
Клиентите биват продавачи и купувачи.
Продавачите имат имот, който искат да продадат.
Купувачите имат бюджет, с който разполагат за покупка на имот, както и списък с огледи,
които са направили.
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
