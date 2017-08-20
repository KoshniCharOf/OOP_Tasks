package weapons;


public class Bomb extends Weapon {

	public Bomb(int price) {
		super(price);
		
	}

	
	@Override
	public boolean isBomb() {
		return true;
	}


	@Override
	public boolean isRadical() {
		return false;
	}


	@Override
	public int shoot() {
		
		System.out.println("BOOM");
		return 0;
	}

	
}
