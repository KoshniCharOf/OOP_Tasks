/**
 * 
 */
package post;

import Town.Citizen;

/**
 * @author NIE
 **� ���������� ������� ������� ��������� � �������� �� �����.
����������� ���� ���, ������� � ������ ����. ����������
�� ����� �� ������ ���������, ����� ���� ����� �� ����, �� ��
�� �������, �� ���� �� �� �� ��� �������.(6 �����)
 */
public abstract class PostalWorker extends Citizen{ 

	private int servYear;
	
	public PostalWorker() {
		
		
	}

	public void setServYear(int servYear) {
		this.servYear = servYear;
	}
	
}
