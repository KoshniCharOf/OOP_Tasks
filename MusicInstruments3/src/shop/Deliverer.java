/**
 * 
 */
package shop;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import Instruments.MusicInstrument;

/**
 * 
 * Усложнение:
• Да се създаде обект „Доставчик на инструменти“, който предлага гама от
инструменти, като за всеки инструмент има информация за времето на доставката до
магазина.
• Да се даде възможност клиент да си поръчва инструмент ако той не е наличен в
магазина. Тогава магазинът трябва да заявки инструментите (по наименование и брой)
към доставчика и да върне информация на клиента колко време ще е нужно на
поръчката, за да пристигне.
• Да се промени логиката така, че магазинът да прави регламентирани доставки на
всички инструменти с нулева наличност (например веднъж месечно).
 */
public  class Deliverer {
	
	 Random r = new Random();
	 HashMap<String[], Integer> instruments  = new HashMap<>();
	
	
	public Deliverer() {
		lockEnLoad(instruments);
	}
	protected int getDeliverTime(String inst, int count){
		int delivery = 0;
		for (Entry<String[], Integer> it : instruments.entrySet()) {
			for (String s : it.getKey()) {
				if(s.equalsIgnoreCase(inst)){
					delivery = it.getValue() * (r.nextInt(count)+1);// more realistic
					System.out.println(delivery+" DAYS ESTIMATE SHIPING TIME "+inst);
				}
			}
		}
		return delivery;
	}

	private void lockEnLoad(HashMap<String[], Integer> instruments){
		 instruments.put(new String[]{"SYNTHESIZER", "BASS GUITAR", "ELECTRIC VIOLIN"},r.nextInt(20)+1);
		 instruments.put(new String[]{"ORGAN", "PIANO", "ACCORDEON"},r.nextInt(70)+1);
		 instruments.put(new String[]{"DRUMS", "TARANBUKA", "DRUM", "DRUMMER"},r.nextInt(10)+1);
		 instruments.put(new String[]{"TRUMPET", "TROMBONE", "TUBE", "FLUTE", "CLARINET"},r.nextInt(50)+1);
		 instruments.put(new String[]{"VIOLIN", "VIOLA", "BASS", "HARP", "GUITAR", "GADULKA"},r.nextInt(60)+1);
	}

}
