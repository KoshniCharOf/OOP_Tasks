package clients;
import java.util.Random;


/**
 * Частните клиенти имат ваучери за покупка на торти на стойност между 10 и 30 лв. Всеки
частен клиент разполага с между един и четири ваучера.
 *
 */
public class PrivateClient extends Client {
	

	private int voucher = new Random().nextInt(4)+1;
	
	public PrivateClient(String name) {
		super(name);
		this.countOfCakes = new Random().nextInt(3)+1;
	}
	
	@Override
	public double getMyPrice(double price) {
		System.out.println("\n Voucher\\s count: "+this.voucher);
		int savings = 0;
		while(this.voucher > 0){
			savings += new Random().nextInt(21)+10;
			voucher--;
		}
		System.out.println("Saved "+savings+" lv of "+price);
		if(price<savings){
			System.out.println(" My lucky day. It is FREE");
			return 0;
		}
		return price-savings;
	}
	
	@Override
	public double giveTip(double price) {
		this.money -= price*0.02;
		System.out.printf("\nTIP: %.2f \n",(price*0.02));
		return price*0.02;
	}

}
