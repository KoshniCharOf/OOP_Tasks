
package post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import Town.City;
import shipment.Parcel;
import shipment.Shipment;

/**
 * 
 *Пощенската станция е разположила 25 улични пощенски кутии
навсякъде из града.
 */
public class PostOffice {
	
	private ArrayList<Postman> postmen = new ArrayList<>();
	private ArrayList<Collector> colectors = new ArrayList<>();
	
	private Stack<Shipment> packets = new Stack<>();
	private TreeMap<LocalDate, TreeSet<Shipment>> archive = new TreeMap<>();
	
	

	public PostOffice() {
		for (int i = 0; i < 20; i++) {
			postmen.add(new Postman());
			colectors.add(new Collector());
		}
	}

//	При получаване на писмо или колет в пощенската станция, те се съхраняват в общо
//	хранилище, като също така се записват и в архив на
//	пратките. Архивът съдържа текущата дата и списък с
//	всички получени пратки – писма и колети. Архивът е
//	подреден по дни, като за всеки ден пратките са
//	подредени по часове на получаване на всяка пратка.
	public void archiveThat(Shipment s){
		//String date = ""+new Random().nextInt(31);
		LocalDate date = LocalDate.now(); //may be have to shipment date member?
		if(!archive.containsKey(date)){
			this.archive.put(date, new TreeSet<>());
		}
		archive.get(date).add(s);
		System.out.println("accepted "+s+" date: "+date);
	}
	
//	Когато хранилището в пощенската станция съдържа по-малко от 50 пратки (писма и
//			колети взети заедно), тогава всички събирачи на писма
//			започват да обикалят града и да изземат всички писма от
//			уличните пощенски кутии. Обходът продължава 2 часа,
//			след което се връщат в пощенската станция и вписват
//			всички получени писма в архива за деня, след което
//			попълват писмата в хранилището. (12 точки)
	
	//май без нишки е ебаси дървеното
	public void serviceTheCity(City t){
		System.out.println("===============Good morning it is 4:00am this city needs us ==============");
		if(this.packets.size() < 50){
			
			for (Collector c : colectors) {//TODO BETTER
				c.collect(t.boxes.get(new Random().nextInt(t.boxes.size())));
				while(!c.bag.isEmpty()){
					archiveThat(c.bag.peek()); //вписват всички получени писма в архива за деня
					this.packets.push(c.bag.pop());// след което попълват писмата в хранилището.
				}
			}
			System.out.println("All shipments collected");
		}else{
			while(!packets.isEmpty()){
				for (Postman p : postmen) {
					if(packets.isEmpty()){
						break;
					}
					p.loadTruck(packets.pop());//hope to be equal:)
						
				}
			}
			
			for (Postman p : postmen) {
				p.spread();
			}
			if(packets.isEmpty()){
				System.out.println("All Shipments Delivered");
			}
			
		}
	}
//	Когато в хранилището има повече от 50 пратки, тогава се
//	привикват всички свободни пощальони и всеки взима
//	равен брой пратки за разпращане. Всеки пощальон
//	започва да раздава писмата по адреси, като това му
//	отнема 10 минути за писмо и 15 минути за колет. След
//	като приключат с раздаването, пощальоните се връщат в пощенската станция в очакване
//	на още пратки. (13 точки)
	
	
	public Stack<Shipment> getPackets() {
		return packets;
	}
//	Системата да разполага с модул справки, при който има възможност за извличане на
//	следните данни:
	
//	• Извлечение на всички пратки по подадена като
//	параметър дата.
	public void printShipmentsByDate(LocalDate date){
		System.out.println("===Shipments By Date===");
		for (Entry<LocalDate, TreeSet<Shipment>> ent : archive.entrySet()) {
			if(ent.getKey().equals(date)){
				System.out.println("===Date: "+ent.getKey()+"====");
				for (Shipment s : ent.getValue()) {
					System.out.println(s);
				}
			}
			
		}
	}
//	• Извлечение на процентното съдържание на
//	писма във всички пратки за деня.(
	public void printLettersPersent(){
		int letters = 0;
		for (Entry<LocalDate, TreeSet<Shipment>> en : archive.entrySet()) {
			for (Shipment s : en.getValue()) {
				if(s.getFee()==0.5){
					letters++;
				}
			}
			System.out.println("Date: "+en.getKey()+" Letter\'s percent  :"+(100*letters/en.getValue().size()));
			letters=0;
		}
	}
//	• Извлечение на процентът на чупливите колети спрямо всички колети, обработени от
//	пощенската станция.
	public void printFragilePercentOfParcels() {
		int fragile = 0;
		int allParc = 0;
		for (Entry<LocalDate, TreeSet<Shipment>> en : archive.entrySet()) {
			for (Shipment s : en.getValue()) {
				if(s.deliverTime()>10){
					allParc++;
					Parcel p = (Parcel)s;
					if(p.isFragile()){
						fragile++;
					}
				}
			}
		}
		int percent = allParc == 0? 0 : 100*fragile/allParc;
		
		System.out.println("Fragile Parcels are :"+percent+"%");
	}
//	• Извлечение за работата на пощальоните – за
//	всеки пощальон да се изведе общия брой пратки, които той е разпратил.
//	Списъкът да се сортира по брой пратки.
	public void printPostmanDeliveries(){

		postmen.sort( (o1,  o2 ) -> o2.getDeliveries()-o1.getDeliveries()); //MY FIRST LAMBDA 

		for (Postman p : postmen) {
			System.out.println(p+" "+"Deliveries: "+p.getDeliveries());
		}
	}
	//just playing
	public void printArchive(){
		//private TreeMap<LocalDate, TreeSet<Shipment>> archive = new TreeMap<>();
		System.out.println("===Archive printed===");
		for (Entry<LocalDate, TreeSet<Shipment>> it : archive.entrySet()) {
			System.out.println("======"+it.getKey()+"=====");
			for (Shipment ship : it.getValue()) {
				System.out.println(ship);
			}
		}
	}

}
