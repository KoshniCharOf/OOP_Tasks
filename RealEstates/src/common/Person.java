package common;



import client.Client;
import estates.Estate;

public class Person implements Comparable<Person> {
	
	protected String name;
	protected String phoneNum;
	protected double money;
	protected Estate estate;
	
	
	public Person(String name) {
		super();
		this.name = name;
	}


	private void recieveMoney(double money){
		if(money>0){
			this.money+=money;
		}
	}

	
	public void payTo(double money, Person p ){
		if(this.money < money){
			System.out.println("out of cash ");
		}
		this.money -= money;
		p.recieveMoney(money);
	}
	public double pay(double money){//Just trying
		if(this.money < money){
			System.out.println("out of cash");
		}
		this.money -= money;
		return money;
	}

	public void swapOwnershipTo(Client c){
		
		c.estate = this.estate;
		c.estate.setOwner(c);
		this.estate = null;
	}


	@Override
	public int compareTo(Person o) {
		
		return this.name.compareTo(o.name);
	}


	public String getName() {
		return name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estate == null) ? 0 : estate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (estate == null) {
			if (other.estate != null)
				return false;
		} else if (!estate.equals(other.estate))
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		return true;
	}
	
}
