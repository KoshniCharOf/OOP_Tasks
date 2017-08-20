/**
 * 
 */
package post;

import java.util.Stack;

import shipment.Letter;

/**
 * 
 **Пощенската станция е разположила 25 улични пощенски кутии
навсякъде из града.
 */
public class PostBox {
	
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
