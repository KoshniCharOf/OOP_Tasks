
package hospital;
/**
 * 
 **   В болницата има 3 отделения 
	• Ортопедия, 10 стаи x 3 легла
	• Кардиология,10 стаи x 3 легла
	• Вирусология, 10 стаи x 3 легла
	В едно отделение има по 10 стаи, във всяка стая има по 3 легла. В едно
	отделение могат да лежат само пациенти с еднаква диагноза, а в една стая да
	има само пациенти от един пол. Ако няма свободни легла в болницата да не
	могат да се приемат пациенти.
 */
public class Room {

	private static int id = 1;
	private int freeBeds = 3;
	private char gender = '0';
	private int roomNumber;
	
	public Room() {
		this.roomNumber = id++;
	}
	
	public boolean isCompatibleGender(Patient p){
		if(this.gender == p.getGender()){
			return true;
		}
		if(this.gender == '0' ){
			this.gender = p.getGender();
			return true;
		}
		return false;
	}

	public boolean hasFreeBed(){
		return this.freeBeds > 0;
	}
	
	public int getFreeBeds() {
		return freeBeds;
	}

	public void setFreeBeds(int freeBeds) {
		this.freeBeds = freeBeds;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	public  int getRoomNumber() {
		return roomNumber;
	}
	
}
