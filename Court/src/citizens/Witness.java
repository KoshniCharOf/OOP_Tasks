
package citizens;

import java.util.ArrayList;

import jurists.Lawyer;

public class Witness extends Citizen implements Comparable<Witness>{

	
	public Witness(String name, int age) {
		super(name, age);
		
	}

	
	@Override
	public void hireLawers(ArrayList<Lawyer> lawers) {
		
		//super.hireLawers(lawers);//
	}


	@Override
	public int compareTo(Witness o) {
		
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "Witness [name=" + name + "]";
	}

}
