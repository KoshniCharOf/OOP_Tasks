
import java.util.Random;

//�� �� �������� ����� ������, ����� ������� ������� � �������. �� ����� �� ����� ���������
//������ �� �� ������� �� ��� �� ���� �������. �� ����� 5 ������� ��������� �������
//���������� ���������� (����� 1 � 4) �� ���������� ������� � �������� � ���� ���������
//������������ �� �������� � ���������� �������. ������ �������� �� � � ����������
//����������, �������� ������ �� ������ �������� �� ���� ��������.
public class Client {
	private static int id = 1;
	//private ArrayList<Product> bag;// no bag we just have fun at the store
	
	public String buy(){
		System.out.println("Hmm what to buy...");
		int pick = new Random().nextInt(Product.names.length);
		int up = new Random().nextInt(Product.names[pick].length);
		//constant 
		return Product.names[pick][up];
		
	}

	public String getName() {
		return "Michka "+id++; //don'n get Michka often :)
	}
	

}
