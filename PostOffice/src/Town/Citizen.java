
package Town;

import java.util.ArrayList;
import java.util.Random;

import post.PostBox;
import post.PostOffice;
import shipment.Letter;
import shipment.Parcel;
import shipment.Shipment;

/**
 * 
 *В града живеят граждани, които имат име, фамилия и адрес.
 */
public class Citizen {
	String[] namesMe = {"Kolio","Toshko","Petar","Iliya","Slavi","Miro","Dancho","Pancho","Racho","Tacho","Pacho","Nacho","Kacho","Bacho"};
	private String name;
	private String lastName;
	private String adress;
	private ArrayList<Citizen> friends;
	
    public Citizen() {
		this.name = namesMe[new Random().nextInt(namesMe.length)];
		//addFriends();
	}

    private void addFriends(){
    	friends = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			friends.add(new Citizen());
		}
    }
    
//	Всеки гражданин може да пуска писма в някоя от пощенските
//	кутии (на random принцип).
	public void sendLetter(City t){
		addFriends();//added here because I don't want to slow down the constructor for Postal workers too
		Letter longLongDramaLetter = new Letter(this, this.friends.get(new Random().nextInt(friends.size())));
		PostBox box = t.getBoxes().get(new Random().nextInt(t.getBoxes().size()));
		box.getLetters().push(longLongDramaLetter);
		System.out.println("Letter send in PostBox number: "+box.getNum());
	}
	
//	Гражданите също така могат да подават директно в пощенската
//	станция както писма, така и колети (на random принцип)
	public void shipSomething(PostOffice p ){
		addFriends();
		Citizen reciever = this.friends.get(new Random().nextInt(friends.size()));
		Shipment ship = null;
		int size = new Random().nextInt(90);
		if(new Random().nextBoolean()){
			ship = new Letter(this, reciever);
		}else{
			ship = new Parcel(this, reciever, size, size/2, size*2, new Random().nextBoolean());//tab ruuules in arguments:)))
		}
		p.getPackets().push(ship);
		p.archiveThat(ship);
	}


	@Override
	public String toString() {
		return "name: " + name ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Citizen other = (Citizen) obj;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
