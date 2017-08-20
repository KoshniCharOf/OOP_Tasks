import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import clients.Client;
import clients.Corporate;
import clients.PrivateClient;
import shop.PastryShop;
import shop.Supplier;

public class Demo {

	public static void main(String[] args) {
		
//		1. Да се създаде сладкарница „Сладки таланти“ с пет доставчика с произволни имена.
		
//		2. Да се създадат 30 торти с произволни типове и видове, като е възможно от един тип и
//		от един вид да има повече от една торти. Всяка торта има 25% процента шанс да бъде
//		от един от четирите описани вида.
		PastryShop talents = new PastryShop("Сладки таланти", 30);
		
//		3. Да се създадат десет клиента – пет корпоративни и пет частни с произволни имена и
//		съответните им отстъпки и ваучери.
		ArrayList<Client> clients = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if((i & 1)==0){
				clients.add(new Corporate("Corporation "+i));
				continue;
			}
			clients.add(new PrivateClient("MamaMia "+i));
		}
		talents.printCakes();
		
//		4. Всеки клиент да направи поръчка на торти и те да му бъдат доставени.
		for (Iterator<Client> it = clients.iterator(); it.hasNext();) {
			Client client = (Client) it.next();
			talents.takeOrder(client.placeOrder(talents, talents.getCakes()));
		}

//		5. Да се изведе на екрана наличността на торти, разписана по видове и типове, преди и
//		след поръчките.
		talents.printCakes();
		
//		6. Да се изпише общата сума, получена от сладкарницата, след поръчка на тортите.
		talents.showOrdersTurnOver();
		
//		7. Да се изведе списък с всички доставчици на сладкарницата, сортиран по големина на
//		техните бакшиши, като подредбата е от най-богатия към този с най-малко бакшиши.
		Collections.sort(talents.getSuppliers());
		for (Supplier s : talents.getSuppliers()) {
			System.out.println(s +" Tips "+s.getTips());
		}
		
//		8. Да се изведе вида торти, който най-често се е продавал.
		talents.printBestSellerType();
		
//		9. Да се изведе доставчика, направил най-много поръчки.
		talents.printTheMostWantedSupplierAndLetHimCloseTheDoor();
		
//		10. Да се изведе клиентът, който е заплатил най-голяма сума за тортички.
		talents.printBestClient();
	}
}
