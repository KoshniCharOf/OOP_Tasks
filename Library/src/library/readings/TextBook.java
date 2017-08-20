
package library.readings;

import demo.Val;

/**
 * 
 * Учебниците са разделени по теми в библиотеката
 *Учебниците имат:
• наименование,
• издателство,

• автор,
• тема (История, Програмиране, ...).
(4 точки)
 */
public class TextBook extends Reading implements Comparable<TextBook>{

	public enum Theme {HISTORY, PROGRAMING, CIVIL_LAW, BIOLOGY, MATHEMATICS}
	private Theme theme;
	private String author;
	private int fee;
	

	public TextBook(String name, String publisher, Theme theme, String author) {
		super(name, publisher);
		this.theme = theme;
		this.author = Val.validText(author);
		this.fee =3;
	}

	@Override
	public String getSubSection() {
		
		return this.theme+"";
	}

	@Override
	public String getType() {
		
		return "TEXTBOOKS";
	}


	@Override
	public int compareTo(TextBook o) {
		if(this.getSubSection().compareTo(o.getSubSection())==0){
			return this.name.compareTo(o.name);
		}
		return this.getSubSection().compareTo(o.getSubSection());
	}

	@Override
	public String toString() {
		return this.name;
	}

	public int getFee() {
		return fee;
	}

	@Override
	public int getPeriod() {
		
		return 150;
	}

	
}
