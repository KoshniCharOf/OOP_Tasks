

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import shop.MusicShop;

public class Demo {
	public static void main(String[] args) {
		
		HashMap<String, String[]> menu = new HashMap<>();
		lockEnLoad(menu);
		MusicShop shop = new MusicShop();
		for (int i = 0; i < 50; i++) {
			shop.load(randomName(menu), new Random().nextInt(15)+1);
		}
		
		shop.printByType();
		shop.printByName();
		shop.printByPrice("down");//write up or down
		shop.printInStock();
		for (int i = 0; i < 100; i++) {
			shop.sell(randomName(menu), new Random().nextInt(4)+1);
		}
	shop.printBySales();
	shop.printBestseller();
	shop.printWorstseller();
	shop.printBestsellerType();
	shop.printBestProfitType();
	shop.orderZeroAvailabilities();
	}
	static void lockEnLoad(HashMap<String, String[]> menu){
		menu.put("Electronic", new String[]{"SYNTHESIZER", "BASS GUITAR", "ELECTRIC VIOLIN"});
		menu.put("Keyboards",  new String[]{"ORGAN", "PIANO", "ACCORDEON"});
		menu.put("Percussion", new String[]{"DRUMS", "TARANBUKA", "DRUM", "DRUMMER"});
		menu.put("Spirals", new String[]{"TRUMPET", "TROMBONE", "TUBE", "FLUTE", "CLARINET"});
		menu.put("Stringed", new String[]{"VIOLIN", "VIOLA", "BASS", "HARP", "GUITAR", "GADULKA"});
	}

	static String randomName(HashMap<String, String[]> menu){
		ArrayList<String> all = new ArrayList<>();
		for (Entry<String, String[]> it : menu.entrySet()) {
			for (String s : it.getValue()) {
				all.add(s);
			}
		}
		return all.get(new Random().nextInt(all.size()));
	}
}
