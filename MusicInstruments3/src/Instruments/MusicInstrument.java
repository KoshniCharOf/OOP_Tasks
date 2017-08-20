package Instruments;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * Съществуват различно видове музикални инструменти в каталога на магазина:
• струнни (цигулка, виола, контрабас, арфа, китара, гъдулка, ...)
• ударни (барабани, тарамбука, тъпан, дайре, ...)
• духови (тромпет, тромбон, туба, флейта, кларинет, ...)
• клавишни (орган, пиано, акордеон, ...)
• електронни (синтезатор, бас-китара, електрическа цигулка, ...)
Всеки музикален инструмент има наименование, цена и наличност в магазина.

	ИДЕЯТА БЕШЕ ДА СА В ЕДИН КЛАС, ЗАЩОТО С 30 и с 5-6 ВЕЧЕ Е ПРАВЕНА:)
	но си признавам, че стана леко грозно с 200 реда
 */
public  class MusicInstrument implements Comparable<MusicInstrument>{
	
	private HashMap<String, String[]> allInstruments = new HashMap<>();
	private String type;
	private String name;
	private double price;
	private int quantity;
	private int sales;
	
	public MusicInstrument(String name, int quantity) {
		super();
		if(quantity>0){
			this.quantity = quantity;
		}else{
			this.quantity = 1;
		}
		this.name = name.toUpperCase();
		lockEnLoad();
		findType(name);
	}
	private void lockEnLoad(){
		allInstruments.put("Electronic", new String[]{"SYNTHESIZER", "BASS GUITAR", "ELECTRIC VIOLIN"});
		allInstruments.put("Keyboards",  new String[]{"ORGAN", "PIANO", "ACCORDEON"});
		allInstruments.put("Percussion", new String[]{"DRUMS", "TARANBUKA", "DRUM", "DRUMMER"});
		allInstruments.put("Spirals", new String[]{"TRUMPET", "TROMBONE", "TUBE", "FLUTE", "CLARINET"});
		allInstruments.put("Stringed", new String[]{"VIOLIN", "VIOLA", "BASS", "HARP", "GUITAR", "GADULKA"});
	}
	private void findType(String name){
		for (Entry<String, String[]> it : allInstruments.entrySet()) {
			for (String s : it.getValue()) {
				if(name.equalsIgnoreCase(s)){
					this.type = it.getKey();
					break;
				}
			}
		}
	}


	public double getPrice() {// long long story
		double price = 0;
		switch (this.name) {
		case "SYNTHESIZER" :
			price = 250;
			break;
		case "BASS GUITAR":
			price = 550;
			break;
		case "ELECTRIC VIOLIN":
			price = 750;
			break;
			
		case "ORGAN":
			price = 5250;
			break;
		case "PIANO":
			price = 3550;
			break;
		case "ACCORDEON":
			price = 450;
			break;
		case "DRUMS":
			price = 2250;
			break;
		case "TARANBUKA":
			price = 50;
			break;
		case "DRUM":
			price = 350;
			break;
		case "DRUMMER":
			price = 550;
			break;
		case "TRUMPET":
			price = 950;
			break;
		case "TROMBONE":
			price = 1250;
			break;
		case "TUBE":
			price = 1050;
			break;
		case "FLUTE":
			price = 1550;
			break;
		case "CLARINET":
			price = 350;
			break;
		case "VIOLIN":
			price = 15550;
			break;
		case "VIOLA":
			price = 5250;
			break;
		case "BASS":
			price = 3050;
			break;
		case "HARP":
			price = 6550;
			break;
		case "GUITAR":
			price = 9950;
			break;
		case "GADULKA":
			price = 450;
			break;
		default:
			break;
		}
		return price;
	}

	
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}

	public String getType() {
		return type;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		MusicInstrument other = (MusicInstrument) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(MusicInstrument m) {
		if(this.type.equals(m.type)){
			return this.name.compareTo(m.getName());
		}
		return this.getType().compareTo(m.getType());
	}
	@Override
	public String toString() {
		return type + " " + name + " sales " + sales + " Price " + getPrice();
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
