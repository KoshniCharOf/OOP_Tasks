/**
 * 
 */
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
 * @author NIE
 *���������� ������� � ����������� 25 ������ �������� �����
��������� �� �����.
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

//	��� ���������� �� ����� ��� ����� � ���������� �������, �� �� ���������� � ����
//	���������, ���� ���� ���� �� �������� � � ����� ��
//	��������. ������� ������� �������� ���� � ������ �
//	������ �������� ������ � ����� � ������. ������� �
//	�������� �� ���, ���� �� ����� ��� �������� ��
//	��������� �� ������ �� ���������� �� ����� ������.
	public void archiveThat(Shipment s){
		//String date = ""+new Random().nextInt(31);
		LocalDate date = LocalDate.now(); //may be have to shipment date member?
		if(!archive.containsKey(date)){
			this.archive.put(date, new TreeSet<>());
		}
		archive.get(date).add(s);
		System.out.println("accepted "+s+" date: "+date);
	}
	
//	������ ����������� � ���������� ������� ������� ��-����� �� 50 ������ (����� �
//			������ ����� ������), ������ ������ �������� �� �����
//			�������� �� �������� ����� � �� ������� ������ ����� ��
//			�������� �������� �����. ������� ���������� 2 ����,
//			���� ����� �� ������ � ���������� ������� � �������
//			������ �������� ����� � ������ �� ����, ���� �����
//			�������� ������� � �����������. (12 �����)
	
	//��� ��� ����� � ����� ���������
	public void serviceTheCity(City t){
		System.out.println("===============Good morning it is 4:00am this city needs us ==============");
		if(this.packets.size() < 50){
			
			for (Collector c : colectors) {//TODO BETTER
				c.collect(t.boxes.get(new Random().nextInt(t.boxes.size())));
				while(!c.bag.isEmpty()){
					archiveThat(c.bag.peek()); //������� ������ �������� ����� � ������ �� ����
					this.packets.push(c.bag.pop());// ���� ����� �������� ������� � �����������.
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
//	������ � ����������� ��� ������ �� 50 ������, ������ ��
//	��������� ������ �������� ��������� � ����� �����
//	����� ���� ������ �� ����������. ����� ��������
//	������� �� ������� ������� �� ������, ���� ���� ��
//	������ 10 ������ �� ����� � 15 ������ �� �����. ����
//	���� ��������� � �����������, ����������� �� ������ � ���������� ������� � ��������
//	�� ��� ������. (13 �����)
	
	
	public Stack<Shipment> getPackets() {
		return packets;
	}
//	��������� �� ��������� � ����� �������, ��� ����� ��� ���������� �� ��������� ��
//	�������� �����:
	
//	� ���������� �� ������ ������ �� �������� ����
//	��������� ����.
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
//	� ���������� �� ����������� ���������� ��
//	����� ��� ������ ������ �� ����.(
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
//	� ���������� �� ��������� �� ��������� ������ ������ ������ ������, ���������� ��
//	���������� �������.
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
//	� ���������� �� �������� �� ����������� � ��
//	����� �������� �� �� ������ ����� ���� ������, ����� ��� � ���������.
//	�������� �� �� ������� �� ���� ������.
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
