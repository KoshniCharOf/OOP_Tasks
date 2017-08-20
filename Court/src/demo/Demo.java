package demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import citizens.Accused;
import citizens.Accuser;
import citizens.Witness;
import court.Case;
import court.CivilCase;
import court.Court;
import court.CriminalCase;
import jurists.Judje;
import jurists.Juri;
import jurists.Lawyer;
import jurists.Prosecutor;

public class Demo {

	public static void main(String[] args) {
		// Да се реализира демо програма, която има следните възможности:
		// 1. Създаване на районен съд –Велико Търново;
		Court court = new Court("Районен съд", "Велико Търново");
		// 2. Създаване и вписване на различни юридически лица в съда –трима
		// съдии, 10 съдебни заседателя, 5 адвоката и двама прокурори.
		signUpJurists(court);
		// 3. Създаване на граждани –5 обвинителя, 5 обвиняеми и 10 свидетеля.
		ArrayList<Accuser> accusers = new ArrayList<>();
		ArrayList<Accused> accused = new ArrayList<>();
		ArrayList<Witness> witnesses = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			accusers.add(new Accuser("Boleev "+i, i*9));
			accused.add(new Accused("Negobolislav "+i, i*7));
			witnesses.add(new Witness("Nechev "+i, i*21));
			witnesses.add(new Witness("Nechev "+i*3, i*23));
		}
 		// 4. Създаване на три граждански дела. За всяко дело юристите и
		// гражданите се зачисляват на произволен принцип. 
		                   // юристите ще ги зачисли съдът преди делото;
		for (int i = 0; i < 3; i++) {
			court.getCases().add(new CivilCase(rAccused(accused), rWitness(witnesses), rAccuser(accusers),court));
		}
		
		// 5. Създаване на три наказателни дела. За всяко дело юристите и
		// гражданите се зачисляват на произволен принцип.
		for (int i = 0; i < 3; i++) {
			court.getCases().add(new CriminalCase(rAccused(accused), rWitness(witnesses),court));
		}
		// 6. За всяко дело да се извика метода „проведи“.
		for (Case cas : court.getCases()) {
			cas.runCase();
		}
		// 7. Да се извика метод в Court класа, който изписва данните на всички
		// юристи заедно с техния брой дела, в който са взимали участие. Метода
		// да се извика преди и след провеждане на всички дела. Метода да
		// извежда юристите и техните дела в табличен вид, сортирани по азбучен
		// ред, разделени с тире. Пример:
		// Иван Иванов – 5
		// Петър Петров – 14
		court.printJurists();
	}
	static void signUpJurists(Court court){
		for (int i = 0; i < 10; i++) {
			if (i < 3) {
				court.getJudjes().add(new Judje("Besilkov " + i, 1, 10));
			}
			if (i < 2) {
				court.getProsecutors().add(new Prosecutor("Laskin "+i, 1, 10));
			}
			if (i < 5) {
				court.getLawyers().add(new Lawyer("Kojoderev " + i, 1, 5));
			}
			court.getJuror().add(new Juri("Moralimira " + i*11, 1, 10));
			court.getJuror().add(new Juri("Moralislav " + i*13, 1, 10));
		}
		
	}
	
	static Accused rAccused(ArrayList<Accused> acc){
		return acc.get(new Random().nextInt(acc.size()));
	}
	
	static Accuser rAccuser(ArrayList<Accuser> acc){
		return acc.get(new Random().nextInt(acc.size()));
	}
	
	static TreeSet<Witness> rWitness(ArrayList<Witness> wit){
		TreeSet<Witness> witnesses = new TreeSet<>();
		for (Witness witness : wit) {
			if(new Random().nextBoolean()){
				witnesses.add(witness);
			}
		}
		return witnesses;
	}
}
