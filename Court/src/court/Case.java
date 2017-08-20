package court;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

import citizens.Accused;

import citizens.Witness;
import jurists.Judje;
import jurists.Juri;
import jurists.Jurist;
import jurists.Lawyer;


/**
 * Съдът може да разглежда дела. Всяко дело има следните характеристики:
-- Тип;
- Съдия, зачислен за делото;
- Съдебни заседатели, зачислени за делото. Ако делото е гражданско, съдебните заседатели са 3.
 Ако е наказателно –съдебните заседатели са 13. 
 Съдебните заседатели не могат да се повтарят за едно дело.
  Няма как един човек да е два пъти съдебен заседател в делото.

- Един обвиняем гражданин;
- Един обвинител. Ако делото е наказателно, обвинителя е прокурор.
  Ако делото е гражданско, обвинителя е гражданин;
- Списък със свидетели. Свидетелите не могат да се повтарят.
 *
 */
public abstract class Case {
	
	protected Judje judje;
	protected HashSet<Juri> juri;
	protected Accused accused;
	protected Court court;
	protected TreeSet<Witness> witnesses;
	
	protected ArrayList<Jurist> jurists;
	protected boolean guilty;
	protected int jurorCount;
	
	
	//За всяко дело юристите и гражданите се зачисляват на произволен принцип.
	//Jurists in court
	public Case( Accused accused, TreeSet<Witness> witnesses, Court court) { 
		
		this.court = court;
		this.judje = court.getJudjes().get(new Random().nextInt(court.getJudjes().size()));
		this.accused = accused;
		this.accused.setCasse(this);
		this.accused.hireLawers(court.getLawyers());
		this.witnesses = witnesses;
		this.jurists = new ArrayList<>();
		this.guilty = false;
		this.juri = new HashSet<>();
	}
	
	
//	Всяко дело трябва да има метод „проведи“. При провеждане на делото се извършват следните операции:
	public void runCase(){
//		1. Всички юристи увеличават броя дела, в които са взели участие, с едно.
		upExpirience(jurists);
		
//		2. Ако делото е гражданско, всеки адвокат на обвинителя задава по 3 въпроса на обвиняемия, след което задава по 2 въпроса на всеки от свидетелите.
//		3. Ако делото е наказателно, прокурора задава 5 въпроса на обвиняемия, след което задава по 5 въпроса на всеки от свидетелите.		
		askingAccusedAndWitnesses();
		
//		4. Всеки адвокат на обвиняемия задава по 5 въпроса на свидетелите по делото.
		lawersOfAccucedTurn();
		
//		5. Всеки съдебен заседател взима решение дали обвиняемия е виновен на базата на произволна стойност.
//		 Ако повече от 50% от заседателите отсъдят еднакво, решението е окончателно.
		juriDecides();
		
//		6. Съдията взима предвид решението на заседателите и ако те са отсъдили „виновен“,
//		определя размера на присъдата отново на произволен принцип –от 3 до 40 години затвор.
		judgeDecides();
		
	}


	private void upExpirience(ArrayList<Jurist> jurists){
		addAllJurists();
		for (Jurist jurist : jurists) {
			jurist.upCases();
		}
	}
	public abstract void askingAccusedAndWitnesses();
	private void lawersOfAccucedTurn(){
		System.out.println("===Lawers of accused turn===");
		for (Lawyer lawer : accused.getLawers()) {
			for (Witness wit : this.witnesses) {
				for (int i = 0; i < 5; i++) {
					lawer.ask(wit);
				}
			}
		}
	}
	private void juriDecides(){
		int count = 0;
		System.out.print("Juri decides ");
		for (int i = 0; i < juri.size(); i++) {
			count+=new Random().nextBoolean()?1 : 0;
		}
		System.out.println(count+" of "+juri.size());
		this.guilty = count > juri.size()/2;
	}
	
	private void judgeDecides(){
		if(!guilty){
			System.out.println("Go home young man \n");
			return;
		}
		int sent = new Random().nextInt(38)+3;
		System.out.println("In the name of the people...You have "+sent+" years to make new friends, btw in prison. \n");
	}

	protected void asignJuri(int case1 ){
		while(this.juri.size() < case1){
			this.juri.add(court.getJuror().get(new Random().nextInt(court.getJuror().size())));
		}
		
	}

	private void addAllJurists(){
		this.jurists.add(judje);
		this.jurists.addAll(juri);
		this.jurists.addAll(accused.getLawers());
	}
	void setJudje(Judje judje) {
		this.judje = judje;
	}


	void setJuri(HashSet<Juri> juri) {
		this.juri = juri;
	}

/*		7 Хронологията на провеждане на делото да се записва в отделен текстов файл за всяко дело. Хронологията включва:
		8 Имената и длъжностите на участниците в делото –юристи и граждани;
		9 Кой на кого е задал въпрос по време на делото;
		10 Как са отсъдили заседателите;
		11 Каква е присъдата.*/
}
