
package hospital;

import java.util.Random;

public class Doctor extends Person {

	/**
	 * @param name 
	 * @param phoneNumber
	 */
	enum Specialistion {ORTOPEDIST, CARDIOLOGIST, VIRUSOLOGIST}
	private Specialistion spec;
	private boolean isBusy = false;
	
	public Doctor(String name,  Specialistion spec) {
		super(name);
		this.spec = spec;
	}
	
	public void createTreatmentPlan(PasteBoard bord){
		String diagnose = "";
		switch (spec) {
		case ORTOPEDIST:
			System.out.println("red pills");
			diagnose = "Broken hand";
			break;
		case CARDIOLOGIST:
			System.out.println("blue pills");
			diagnose = "Broken heart";
			break;
		case VIRUSOLOGIST:
			System.out.println("all pills");
			diagnose = "Broken nose";
			break;
		default:
			break;
		}
		bord.setPlan(new TreatmentPlan(diagnose,"mnoogo hapcheta", new Random().nextInt(3)+3));
	}
	
	public void visit(Patient p){
		System.out.println(this.getName()+" Visits "+p.getName()+" Section: "+p.getBoard().getSection()+" Room number: "+p.getBoard().getRoom().getRoomNumber());
	}

	public boolean isBusy() {
		return isBusy;
	}

	public void setBussy(boolean isBussy) {
		this.isBusy = isBussy;
	}

}
