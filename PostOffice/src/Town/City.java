
package Town;

import java.util.ArrayList;
import java.util.Stack;

import post.PostBox;

/**
 * 
 *Пощенската станция е разположила 25 улични пощенски кутии
навсякъде из града.
 */
public class City {
	public ArrayList<PostBox> boxes = new ArrayList<>();
	
	

	public City() {
		for (int i = 0; i < 25; i++) {
			boxes.add(new PostBox());
		}
	}


	public ArrayList<PostBox> getBoxes() {
		return boxes;
	}
	
	

}
