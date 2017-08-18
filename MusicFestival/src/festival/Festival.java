package festival;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * 
 */

/**
 *  ���������� ������� ������� ����. ����� ��� ������� �����, �����
 *         ��������� ������� �����, ������ � ���� �� ������������. ������� ��
 *         ��������� �� ���������, ������� �� �������� ����������� ���
 *         ���������. ����� ����� ��� ������� �����, ����� �� �������. �����
 *         ����� ��� �������� � �����. ��� ������� ��� ��������, �� �
 *         ������������ �� ���������, ������ �� �� ���� ����� � �����
 *         ����������, ����� � ��� �� ������� ���������� ���������. ��� �������
 *         ���� ��������, ��������, �� �������� � ��������� ���� ������������ �
 *         ������� � �� ���� �� �� ���������.
 */
public class Festival {

	public static void main(String[] args) {

		LocalTime time = LocalTime.of(20, 00); // ���������

		ArrayList<Band> bandi = new ArrayList<>();
		bandi.add(new Band("Queen", 7, 6));// ����������
		bandi.add(new Band("KISS", 5, 5));// ����������
		bandi.add(new Band("Radka Krashnata", 3, 10));// � �������� �� �������

		for (Band b : bandi) {
			time = b.playAt(time);
		}

	}

	static String validTextOrName(String s) {
		if (s != null && !s.isEmpty()) {
			return s;
		}
		return "CENSURED";
	}
}
