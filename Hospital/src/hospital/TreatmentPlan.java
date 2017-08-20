
package hospital;

/**
 * 
 *  съдържа в себе си диагноза и списък от лекарства
 */
public class TreatmentPlan {
	
	private int daysHospitalized;
	private String diagnose;
	private String medicines;
	
	public TreatmentPlan(String diagnose, String medicines, int daysHospitalized) {

		this.diagnose = Val.validStr(diagnose);
		this.medicines = Val.validStr(medicines);
		this.daysHospitalized = Val.validNum(daysHospitalized);
	}
	
	public String getDiagnose() {
		return diagnose;
	}
	
	public String getMedicines() {
		return medicines;
	}
	
	public int getDaysHospitalized() {
		return daysHospitalized;
	}
	
}
