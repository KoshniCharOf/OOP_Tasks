package weapons;

import java.util.Random;

public class Gun extends Weapon {

	public Gun(int price) {
		super(price);
		
	}

	@Override
	public int shoot() {
		System.out.println("Gun shooting");
		return new Random().nextInt(100)+50;
	}
	
	@Override
	public String toString() {
		return "Gun";
	}

	
}
