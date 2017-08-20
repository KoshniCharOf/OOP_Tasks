package court;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import jurists.Judje;
import jurists.Juri;
import jurists.Jurist;
import jurists.Lawyer;
import jurists.Prosecutor;


/**
 * Всеки съд съдържа в себе си следните характеристики:
- Наименование;
- Адрес;
- Юридически лица (юристи);
- Списък с дела.
 *
 */
public class Court {
	
	private String name;
	private String adress;
	private TreeSet<Jurist> jurists;
	private ArrayList<Case> cases;
	private ArrayList<Judje> judjes;
	private ArrayList<Juri> juror;
	private ArrayList<Lawyer> lawyers;
	private ArrayList<Prosecutor> prosecutors;
	
	public Court(String name, String adress) {

		this.name = name;
		this.adress = adress;
		this.cases = new ArrayList<>();
		this.judjes = new ArrayList<>();
		this.juror = new ArrayList<>();
		this.lawyers = new ArrayList<>();
		this.prosecutors = new ArrayList<>();
		this.jurists = new TreeSet<>();
	}

	public TreeSet<Jurist> getJurists() {
		return jurists;
	}
	
	public ArrayList<Case> getCases() {
		return cases;
	}

	public ArrayList<Judje> getJudjes() {
		return judjes;
	}

	public ArrayList<Juri> getJuror() {
		return juror;
	}

	public ArrayList<Lawyer> getLawyers() {
		return lawyers;
	}

	public ArrayList<Prosecutor> getProsecutors() {
		return prosecutors;
	}
	
	private void addAllJurists(){
		this.jurists.addAll(prosecutors);
		this.jurists.addAll(judjes);
		this.jurists.addAll(juror);
		this.jurists.addAll(lawyers);
	}
	
	public void printJurists(){
		addAllJurists();
		for (Jurist jurist : jurists) {
			System.out.println(jurist+" -  "+jurist.getCases());
		}
	}
	
}
