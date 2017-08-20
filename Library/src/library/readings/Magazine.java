
package library.readings;

import java.time.LocalDate;
import java.util.Random;

/**
 * 
 *  списанията са разделени– по категории.
 *Списанията имат:
• наименование,
• издателство,

• категория (модни, научнопопулярни, ...),
• номер на брой,
• дата на издаване.
 */
public class Magazine extends Reading implements Comparable<Magazine>{
	
	public enum Category{FASHION, NATURE, AUTO, FISHING}
	private Category category;
	
	private int number;
	
	public Magazine(String name, String publisher, Category category, int number) {
		super(name, publisher);
		this.category = category;
		this.number = number;
		this.setPubDate(LocalDate.of(1900, 1, 1).plusYears(new Random().nextInt(117)));
	}


	@Override
	public String getSubSection() {
		
		return this.category+"";
	}


	@Override
	public String getType() {
		
		return "MAGAZINES";
	}


	
	public int compareTo(Magazine o) {
		if(this.name.compareTo(o.name)==0){
			return this.number - o.number ;
		}
		return this.name.compareTo(o.name);
	}


	@Override
	public String toString() {
		return name + ", Number :" + number ;
	}


	@Override
	public int getFee() {
		
		return -1;//can not be rented
	}


	@Override
	public int getPeriod() {
		
		return -1;
	}
	
}
