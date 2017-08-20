package hospital;

public class Demo {

	public static void main(String[] args) {
		/* Да се реализира прием на 5 пациента в болницата. При прием на всеки
		пациент на конзолата да се извежда следното съобщение:
		'Пациент <firstName> <lastName> от пол <gender> e приет с диагноза
		<diagnoseName>. Лекуващ лекар: д-р <firstName> <lastName>. '*/
		
		Patient tosho = new Patient("Tosho", 45, 'm');

		Hospital tutuda = new Hospital("Don't Cry", "Last Str.99");
		tutuda.printFreeBeds();
		tutuda.printDocsPatients();
		tutuda.acceptPatient(tosho);
		
	}

}
