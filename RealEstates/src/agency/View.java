package agency;
import java.util.Date;

import client.Buyer;
import estates.Estate;


/**
   Всеки оглед има следните характеристики:
• имот;
• агент;
• купувач;
• дата на провеждане на огледа.
 *
 */
public class View implements Comparable<View>{
	
	private Estate estate;
	private Agent agent;
	private Buyer buyer;
	private Date date;
	
	public View(Estate estate, Agent agent, Buyer buyer, Date date) {
		super();
		this.estate = estate;
		this.agent = agent;
		this.buyer = buyer;
		this.date = date;
	}

	@Override
	public int compareTo(View o) {
		
		return this.estate.getPrice()-o.estate.getPrice()>0?1:-1;
	}

	public Estate getEstate() {
		return estate;
	}

	@Override
	public String toString() {
		return "View " + estate +", buyer: " + buyer + "]";
	}

}
