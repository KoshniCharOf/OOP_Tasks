/**
 * 
 */
package client;

import java.util.Date;
import java.util.Random;
import java.util.TreeSet;

import agency.Agency;
import agency.View;
import common.Notary;
import estates.Estate;



/**
 * ���������� ���� ������, � ����� ���������� �� ������� �� ����, ����� � ������ � ������,
����� �� ���������.
 *
 */
public class Buyer extends Client {

	public Buyer(String name) {
		super(name);
		this.budget = new Random().nextInt(120000)+30000;
		this.views = new TreeSet<>();
		this.money = budget*2;
	}
	private double budget;
	private TreeSet<View> views;
	
//	����� ������ ���� �� ��������� �������� ��������:
//	
//		� ��� � ������� � �� ���������� ��������� �� ������� �� ���� ��� ���������. � �����
//		������ �� ��������� �� �� ���������� ����� �� ���������� �������. �������� ��
//		���������� � ������� � �������� �� ������.
		public void searchRequest(Agency a){
			this.agent = a.asignAgent();
			this.agent.addBuyer(this);
		}
//		� ��� � ������� � �� ����� ����� �� ��������� ���� �� �������� � �����. ������� ����
//		�� �� ��������� ���� ��� ������ �� ����� � ��� ������� �� ��������. ���
//		������������� �� �����, ��� ����� � ������� � ������ �� ��������, ����� � �� ������.
		public void requestView(Estate e){
			if(e.getPrice() > this.budget){
				System.out.println(this.name+" No view budget "+this.budget+" Estate price: "+e.getPrice());
				return;
			}
			View v  = new View(e, this.agent, this, new Date());
			this.views.add(v);
			this.agent.getViews().add(v);
			System.out.println(v);
		}
//		� ��� � ������� � �� ����� ������� �� ����. ��������� ���� �� ���� ���� �� ����, ��
//		����� ��������� � ����� �� �����. ��� ������� ��������� ����� 3% �� ������ ��
//		����� �� ���������. ��������� ���� ���������� �� ������������ �� ������, �
//		���������� �������� ����� � ������ ������. ���������� �� ����� ���� ����� 3%
//		���������� �� ���������, ���� � �� ���� ���������� ���������� ������ �� ������ ���
//		������� �� �������.
		public void buyEstate(){
			if(this.views.isEmpty()){
				System.out.println(this.name+" have no views. Go work harder!");
				return;
			}
			Estate e = this.views.last().getEstate();
			
			if(Notary.conveyancingDeal(e.getOwner(), e, this)){ 
				
				System.out.println("Congats, "+this.name+" you have bought "+this.estate);	
			}
			
		}
		@Override
		public String toString() {
			
			return super.toString()+ "Buyer [budget=" + budget + "]";
		}
		
}
