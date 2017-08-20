
package hospital;

/**
 * 
 *всеки пациент името, годините и телефонния номер.
 */
public class Patient extends Person {

	private int age;
	private Doctor  curing;
	private PasteBoard board;
	private char gender;
	
	public Patient(String name, int age, char gender) {
		super(name);
		
		this.age = Val.validNum(age);
		this.gender = gender;//no validation, there are genders for whole alphabet
		
	}
	
	public void setCuring(Doctor curing) {
		this.curing = curing;
	}
	public int getAge() {
		return age;
	}
	public Doctor getDoctor() {
		return curing;
	}
	public void setBoard(PasteBoard board) {
		this.board = board;
	}
	public char getGender() {
		return gender;
	}
	public PasteBoard getBoard() {
		return board;
	}

}
