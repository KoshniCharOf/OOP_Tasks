/**
 * 
 */
package shipment;

import Town.Citizen;

/**
 * @author NIE
 *�������� ���� ���� ���� ������� (�������, ������ �
��������).
 */
public class Parcel extends Shipment {

	private int size1;
	private int size2;
	private int size3;
	private boolean isFragile;
	
	
	
public Parcel(Citizen sender, Citizen reciever, int size1, int size2, int size3, boolean isFragile) {
		super(sender, reciever);
		this.size1 = validateSize(size1);
		this.size2 = validateSize(size2);
		this.size3 = validateSize(size3);
		
		this.isFragile = isFragile;
	}



	//	//�������� � ������� �� 60 �� �� ����� ������ ��
//	������ �� �������� � �� �������� � 2 ����. ��� ����� ��
//	�������� � ��� 60 ��, ������� �� ����� �� ������������� �
//	������� �� �� ��������� � 50%. ��� ������� � �������� ����
//	������, ������� �� ������ �� ��������� � 50%.
	@Override
	public double getFee() {
		double fee = isFragile?3:2;
		if(size1>60 || size2>60 || size3 >60){
			fee *= 1.5;
		}
		return fee;
		
	}



	@Override
	public int deliverTime() {
		
		return 15;
	}



	public boolean isFragile() {
		return isFragile;
	}

	private int validateSize(int a){
		if(a > 0){
			return a;
		}
		return a*-1 + 1;
	}

	@Override
	public String toString() {
		return "Parcel  size1=" + size1 + ", size2=" + size2 + ", size3=" + size3 + ", isFragile :" + isFragile
				+ ", Fee: " + getFee() + ", deliverTime: " + deliverTime() + " " + super.toString();
	}



	
}
