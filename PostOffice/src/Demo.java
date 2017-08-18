

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Random;

import Town.Citizen;
import Town.City;
import post.PostOffice;

public class Demo {
	public static void main(String[] args) {
		
		City sofia = new City();
		PostOffice dpd = new PostOffice();
		ArrayList<Citizen> grajdanya =  new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			grajdanya.add(new Citizen());
		}
		for (Citizen c : grajdanya) {
			if(new Random().nextBoolean()){
				c.sendLetter(sofia);
			}else{
				c.shipSomething(dpd);
			}
		}
		dpd.serviceTheCity(sofia);
		dpd.printLettersPersent();
		dpd.printPostmanDeliveries();
		dpd.printFragilePercentOfParcels();
		LocalDate date = LocalDate.of(2017, 8, 15);
		dpd.printShipmentsByDate(date);
		//dpd.printArchive();
	}

}
