/**
 * 
 */
package post;

import java.util.Stack;

import shipment.Letter;

/**
 *
 * няма стаж
 */
public class Collector extends PostalWorker {

	Stack<Letter> bag = new Stack<>();//I know I should use interface 
	
	public Collector() {
		super();
		
	}
	//събира писма
	protected void collect(PostBox box){
		while(!box.getLetters().isEmpty()){
			bag.push(box.getLetters().pop());
		}
	}
	public Stack<Letter> getBag() {
		return bag;
	}
	

}
