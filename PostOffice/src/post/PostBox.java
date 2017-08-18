/**
 * 
 */
package post;

import java.util.Stack;

import shipment.Letter;

/**
 * @author NIE
 **���������� ������� � ����������� 25 ������ �������� �����
��������� �� �����.
 */
public class PostBox {
//stack ot pisma
	private static int id = 1;
	private int num;
	private Stack<Letter> letters = new Stack<>();
	

	public PostBox() {
		this.num = PostBox.id++;
	}


	public Stack<Letter> getLetters() {
		return letters;
	}


	public int getNum() {
		return num;
	}
	
}
