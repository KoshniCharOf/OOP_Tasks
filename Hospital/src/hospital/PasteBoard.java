
package hospital;

import hospital.Hospital.Section;


public class PasteBoard {
	private String name;
	private String phone;
	private int age;
	private TreatmentPlan plan;
	private Section section;
	private Room room;
	
	public PasteBoard(Patient p) {

		this.name = p.getName();
		this.age = p.getAge();
	}

	public void setPlan(TreatmentPlan plan) {
		this.plan = plan;
	}

	public TreatmentPlan getPlan() {
		return plan;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
//
}
