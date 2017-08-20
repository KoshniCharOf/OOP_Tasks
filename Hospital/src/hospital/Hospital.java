
package hospital;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Random;

import hospital.Doctor.Specialistion;

/**
 * 
 * В болницата работят лекари и медицински сестри.
 * Лекарите имат име, телефонен номер и специализация. 
 * Медицинските сестри имат име, години стаж и телефонен номер.
 * всеки пациент името, годините и телефонния номер.
 */
public class Hospital {
	private String name;
	private String adress;
	private ArrayList<Doctor> doctors;
	private HashMap<Section, ArrayList<Nurs>> nurses;
	private HashMap<Patient, PasteBoard> boards;
	static enum Section {ORTHOPEDY, CARDIOLOGY, VIROLOGY}
	private Section section;
	
	private HashMap<Section, ArrayList<Room>> building;
	
	
	public Hospital(String name, String adress) {

		this.name = Val.validStr(name);
		this.adress = Val.validStr(adress);
		
		this.doctors = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int j = new Random().nextInt(Specialistion.values().length);
			Specialistion s = Specialistion.values()[j];
			doctors.add(new Doctor("Dr.Mouse "+(i+1),  s));
		}
		this.nurses = new HashMap<>();//hashmap section array nurses
		nurses.put(Section.ORTHOPEDY, new ArrayList<>());
		nurses.put(Section.CARDIOLOGY, new ArrayList<>());
		nurses.put(Section.VIROLOGY, new ArrayList<>());
		
			for (int i = 0; i < 10; i++) {
				nurses.get(Section.ORTHOPEDY).add(new Nurs("Ohbolilova",  i*5));
				nurses.get(Section.CARDIOLOGY).add(new Nurs("Srcelilova",  i*4));
				nurses.get(Section.VIROLOGY).add(new Nurs("Sopolilova",  i*3));
			}
		
		this.boards = new HashMap<>();
		this.building = new HashMap<>();
		building.put(Section.ORTHOPEDY, new ArrayList<>());
		building.put(Section.CARDIOLOGY, new ArrayList<>());
		building.put(Section.VIROLOGY, new ArrayList<>());
		for (int i = 0; i < 10; i++) {
			building.get(Section.ORTHOPEDY).add(new Room());
			building.get(Section.CARDIOLOGY).add(new Room());
			building.get(Section.VIROLOGY).add(new Room());
		}	
	}
	

	/*В болницата могат да се приемат пациенти, като при приема на всеки пациент
се издава картон с данните в болницата, който съдържа името, годините и
телефонния номер. Също така на пациента се заделя лекуващ лекар от
свободните в момента. Ако няма свободен лекар, пациента трябва да изчака
докато се освободи такъв. Лекуващият лекар изготвя план за лечение, който
съдържа в себе си диагноза и списък от лекарства , които болният трябва да
приеме. Лечението продължава за произволен период м/у 3 и 5 дни като всеки
ден се дават лекарства от плана. Даването на лекарства се извършва от
медицински сестри.*/
	public void acceptPatient(Patient p){
		//в болницата, който съдържа името, годините и телефонния номер.
		//на пациента се заделя лекуващ лекар от свободните в момента.
		    if(assignDoc(p)){
		    	//printDocsPatients();//remove
		    	if(accommodation(p)){
		    		treatment(p);
		    	}
		    }
			
			
		}
		//Лекуващият лекар изготвя план за лечение TreatmentPlan plan = new Treat(); 
				//--съдържа в себе си диагноза и списък от лекарства
		
		//Лечението продължава за произволен период м/у 3 и 5 дни
		
		//Даването на лекарства се извършва от медицински сестри.
		
	
	private boolean assignDoc(Patient p ){
		
		p.setBoard(new PasteBoard(p));
		for (Doctor doc : doctors) {
			if(doc!=null && !doc.isBusy()){
				p.setCuring(doc);
				doc.setBussy(true);
				doc.createTreatmentPlan(p.getBoard());
				this.boards.put(p, p.getBoard());
				return true;
			}
		}
		System.out.println("no free doctors now");
		return false;
	}
	
	private void treatment(Patient p){
		for (int i = 0; i < p.getBoard().getPlan().getDaysHospitalized(); i++) {
			System.out.println("Day: "+(i+1));
			printNextDayOut(i+1);
			//nurs give medicines
			for (Nurs n : nurses.get(p.getBoard().getSection())) {
				if(n!=null){
					n.giveMedicines(p);
					break;
				}
			}
			p.getDoctor().visit(p);
		}
		signOut(p);
		
		//Всеки ден всеки пациент има визитация от лекуващия си лекар.
	}
	
	//При прием в болницата пациентът се настанява в стая, която се намира в отделение.
	private boolean accommodation(Patient p){
		
		String diagnose = this.boards.get(p).getPlan().getDiagnose();
		Section sec = null;
		switch (diagnose) {
		case "Broken hand":
			sec = Section.ORTHOPEDY;
			break;
		case "Broken heart":
			sec = Section.CARDIOLOGY;
			break;
		case "Broken nose":
			sec = Section.VIROLOGY;
			break;
		default:
			break;
		}
		if(checkForRoomAt(p, sec)){
			boards.get(p).setSection(sec);
			return true;
		}else{
			System.out.println("No free rooms");
			return false;
		}
	}
	/*В болницата има 3 отделения 
	• Ортопедия, 10 стаи x 3 легла
	• Кардиология,10 стаи x 3 легла
	• Вирусология, 10 стаи x 3 легла
	В едно отделение има по 10 стаи, във всяка стая има по 3 легла. В едно
	отделение могат да лежат само пациенти с еднаква диагноза, а в една стая да
	има само пациенти от един пол. Ако няма свободни легла в болницата да не
	могат да се приемат пациенти.*/


	private boolean checkForRoomAt(Patient p, Section c) {
		for (Room r : this.building.get(c)) {
			if(r.hasFreeBed() && r.isCompatibleGender(p)){
				this.boards.get(p).setRoom(r);
				r.setFreeBeds(r.getFreeBeds()-1);
				return true;
			}
		}
		return false;	
	}
	
	/*Пациентите , чието лечение е приключило, се изписват. Когато това се
случи на конзолата да се изпише :
'Пациент <firstName> <lastName> от пол <gender> с диагноза <diagnoseName>
беше изписан '.
Съответно леглото, което той заема да се освободи.*/
	public void signOut(Patient p){
		///printFreeBeds();//remove
		Room r = building.get(boards.get(p).getSection()).get(p.getBoard().getRoom().getRoomNumber());
		r.setFreeBeds(r.getFreeBeds()+1);
		p.getDoctor().setBussy(false);
		if(r.getFreeBeds()==3){
			r.setGender('0');
		}
		
		signOutMessage(p);
	}
	
	private void signOutMessage(Patient p){
		/*Пациент <firstName> <lastName> от пол <gender> с диагноза <diagnoseName>
		беше изписан '.*/
		System.out.println("Patient "+p.getName()+" gender: "+(p.getGender()=='m'?"man":"woman")+
				", diagnose: "+p.getBoard().getPlan().getDiagnose()+" was healed and signed out");
	}
	
	// print Свободни легла в болницата по отделения
	public void printFreeBeds(){
		for (Section s : building.keySet()) {
			System.out.println("========"+s+"=========");
			int free = 0;
			for (Room r : building.get(s)) {
				free+=r.getFreeBeds();
			}
			System.out.println(free+" free beds");
		}
	}
	//print Брой пациенти за всеки доктор
	public void printDocsPatients(){
		for (Doctor d : doctors) {
			System.out.println(d.getName()+" is "+(d.isBusy()?"Busy":"Not busy"));
		}
	}
	//print Пациенти, които ще бъдат изписани на следващия ден.
	public void printNextDayOut(int day){
		for (Patient p : boards.keySet()) {
			if(p.getBoard().getPlan().getDaysHospitalized()-1 == day){
				System.out.println(p.getName()+" signs out tomorow");
			}
		}
	}
}
