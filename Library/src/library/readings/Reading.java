
package library.readings;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


import demo.Val;
import library.Person;

/**
 * 
 *Всяко четиво има списък с история на вземанията, където се попълват:
<дата на взимане под наем> - <дата на връщане>. (3 точки)
common:
• наименование,
• издателство

• автор book, text
 дата на издаване (book mag)
 */
public abstract class Reading {
	
	enum SubSection{}
	protected SubSection sub; 
	protected String name;
	protected String publisher;
	protected String history = "";
	protected LocalDateTime takeDate;
	
	protected double profit;
	protected double expectProfit;
	protected ArrayList<Person> readers = new ArrayList<>();
	protected int countRead;
	private boolean isAvailable = true;
	
	//not common , but helps for my abstraction
	private LocalDate pubDate;
	
	
	public Reading(String name, String publisher) {
		this.name = Val.validText(name);
		this.publisher = Val.validText(publisher);
		
	}
	
	public abstract String getType();
	public abstract String getSubSection();
	
	public abstract int getFee() ;
	public abstract int getPeriod();

	public void setHistory(LocalDateTime history) {
		this.history = this.history.concat(" "+history);
	}
	
	public String getName() {
		return name;
	}

	public String getHistory() {
		return history;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setProfit(double profit) {
		this.profit += profit;
	}

	
	public LocalDateTime getTakeDate() {
		return takeDate;
	}

	public void setTakeDate(LocalDateTime takeDate) {
		this.takeDate = takeDate;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}

	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	public void upCountRead() {
		this.countRead++;
	}

	public int getCountRead() {
		return countRead;
	}

	public double getProfit() {
		return profit;
	}

	public double getExpectProfit() {
		return expectProfit;
	}

	public void setExpectProfit(double expectProfit) {
		this.expectProfit = expectProfit;
	}

	public ArrayList<Person> getReaders() {
		return readers;
	}

	@Override
	public String toString() {
		return "Reading [" + sub + ", name " + name + ", readers " + readers + ", countRead = " + countRead + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(profit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((readers == null) ? 0 : readers.hashCode());
		result = prime * result + ((sub == null) ? 0 : sub.hashCode());
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
		Reading other = (Reading) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(profit) != Double.doubleToLongBits(other.profit))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (readers == null) {
			if (other.readers != null)
				return false;
		} else if (!readers.equals(other.readers))
			return false;
		if (sub != other.sub)
			return false;
		return true;
	}

	
}
