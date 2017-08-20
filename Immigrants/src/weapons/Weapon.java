package weapons;

/**
 * 
 *Данните за 1 оръжие са следните:
• Вид (пистолет, бомба, автомат).
• Цена на черния пазар в евро.
 */
public abstract class Weapon {
	private int price;

	public Weapon(int price) {
		super();
		this.price = price;
	}
	public  boolean isRadical(){
		return true;
	}
	public boolean isBomb(){
		return false;
	}
	public int getPrice() {
		return price;
	}

	/* Стрелянето е операция характерна за всяко оръжие, която изкарва подходящо
	   съобщение и връща броя на изстреляните патрони.*/
	public abstract int shoot();
	
}
