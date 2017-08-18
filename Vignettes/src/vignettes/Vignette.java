/**
 * 
 */
package vignettes;

import java.time.LocalDate;


/**
 * Всяка винетка има следните характеристики:
 Дата на издаване – ден, месец и година
 Цвят
 Срок на валидност – дневна, месечна или годишна.
Винетките биват три вида – за кола, за камион, за автобус. Всички винетки за
коли са с един и същ цвят. Аналогично и за камиони и автобуси.

 *
 */
public abstract class Vignette implements Comparable<Vignette>{
	
	public enum Period{DAY,MONTH,YEAR}
	protected LocalDate issueDate;
	protected String color;
	protected Period period;
	protected int stickTime;
	protected int dayPrice;
	
	

	public Vignette(Period period) {
		this.period = period;
		this.issueDate = LocalDate.now();
	}
	
//	Операциите, които се изпълняват върху винетките са :
//
//		• да се залепи на стъклото,
//		• да й се вземе цената.
//		Цената на дневна винетка за кола е 5 лв, за камион – 7 лв., за автобус – 9 лв.
//		Цените за месец се получават като цените за седмица Day се умножат по 10.
//		Цените за година се получават като месечните цени се умножат по 6.
//		Операцията за залепване връща като резултат колко време отнема една винетка
//		да се залепи – 5 секунди за кола, 10 за камион и 20 за автобус.
	
	public  int getPrice(){
		switch (this.period) {
		case DAY:
			return this.dayPrice;
		case MONTH:
			return this.dayPrice*10;
		case YEAR:
			return this.dayPrice*60;
		default:
			return 0;
		}
	}

	public int getStickTime() {
		return stickTime;
	}

	
	@Override
	public int compareTo(Vignette o) {
		
		return this.getPrice() - o.getPrice();
	}

	@Override
	public String toString() {
		return "Vignette color " + color + " period: " + period + " price: " + getPrice() + "lv  StickTime:"
				+ getStickTime()+"min";
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public Period getPeriod() {
		return period;
	}

}
