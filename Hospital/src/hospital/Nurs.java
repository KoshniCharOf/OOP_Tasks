
package hospital;

/**
 * 
 *Медицинските сестри имат име, години стаж и телефонен номер.
 */
public class Nurs extends Person {

	/**
	 * @param name
	 * @param phoneNumber
	 */
	private int internship;
	
	public Nurs(String name, int internship) {
		super(name);
		this.internship = Val.validNum(internship);
	}

	public void giveMedicines(Patient p ){
		System.out.print(this.getName()+" gave to  "+p.getName()+" Section: "+p.getBoard().getSection()+" Room number: "+p.getBoard().getRoom().getRoomNumber());
		System.out.println(" Medicine: "+p.getBoard().getPlan().getMedicines());
	}
}
