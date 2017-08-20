
package library.readings;

import java.time.LocalDate;
import java.util.Random;

import demo.Val;

/**
 * 
 *книгите са разделени по жанрове в отделни секции. Всяка книга има:
• наименование,
• издателство,

• автор,
• дата на издаване,
• жанр (любовен роман, трилър, ...).
 */
public class Book extends Reading implements Comparable<Book>{
	public enum Janre{ROMANCE, TRILLER, SCI_FI, CRIMI, KIDS}
	
	private String author;
	private Janre janre;
	private int fee;
	
	public Book(String name, String publisher, String author, Janre janre) {
		super(name, publisher);
		this.author = Val.validText(author);
		this.janre = janre;
		this.setPubDate(LocalDate.of(1900, 1, 1).plusYears(new Random().nextInt(120)));
		this.fee = 2;
	}

	@Override
	public String getSubSection() {
		
		return this.janre+"";
	}

	@Override
	public String getType() {
		
		return "BOOKS";
	}

	
	public int compareTo(Book o) {
		if(this.getSubSection().compareTo(o.getSubSection())==0){
			return -1*this.getPubDate().compareTo(o.getPubDate());
		}
		return -1*this.getSubSection().compareTo(o.getSubSection());
	}

	@Override
	public String toString() {
		return this.name + ", PubDate: " + getPubDate() ;
	}

	public int getFee() {
		return fee;
	}

	@Override
	public int getPeriod() {
		
		return 300;
	}

	

}
