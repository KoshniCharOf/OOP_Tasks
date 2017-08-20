package clients;

import java.util.Random;

/**
 * Корпоративните имат 10% отстъпка от всички продукти.
 *
 */
public class Corporate extends Client {

	
	public Corporate(String name) {
		super(name);
		this.countOfCakes = new Random().nextInt(3)+3;
		
	}
	@Override
	public double getMyPrice(double price) {
		System.out.println("Saved "+price*0.1);
		return price*0.9;
	}
/*Всеки клиент може да изпълнява следните действия:
			• Ако е корпоративен – да поръча произволен брой (между три и пет) торти от
			произволен вид и тип. В такъв случай се създава поръчка, в която влизат
			необходимите торти (ако са налични), като също така се причислява доставчик на
			произволен принцип, който да занесе тортите. От цената на поръчката се приспадат
			процентът отстъпка на корпоративният клиент. Отстъпките биват произволни между
			5% и 15%. Доставчикът занася поръчката, при което клиентът му заплаща дължимата
			сума заедно с 5% бакшиш. Сумата влиза в касата на сладкарницата, а бакшишът
			остава за доставчика.*/
	@Override
	public double giveTip(double price) {
		this.money-=price*0.05;
		System.out.printf("\n TIP: %.2f \n",price*0.05);
		return price*0.05;
	}

}
