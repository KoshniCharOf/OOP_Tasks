package court;

import java.util.TreeSet;

import citizens.Accused;
import citizens.Accuser;
import citizens.Witness;
import jurists.Lawyer;


/**
 * Ако делото е гражданско, съдебните заседатели са 3.
 * Ако делото е гражданско, обвинителя е гражданин;
 *
 */
public class CivilCase extends Case {

	private Accuser accuser;
	
	
	public CivilCase(Accused accused, TreeSet<Witness> witnesses, Accuser accuser, Court court) {
		super(accused, witnesses,court);
		asignJuri(3);
		this.accuser = accuser;
		this.accuser.setCasse(this);
		this.accuser.hireLawers(court.getLawyers());
		this.jurists.addAll(accuser.getLawers());
		
	}
	
	
//		2. Ако делото е гражданско, всеки адвокат на обвинителя задава по 3 въпроса на обвиняемия,	
		//след което задава по 2 въпроса на всеки от свидетелите.
	
	@Override
	public void askingAccusedAndWitnesses() {
		System.out.println("CIVIL CASE N: "+this.hashCode());
		System.out.println("=====Lawers of Accuser=====");
		
		for (Lawyer lawer : this.accuser.getLawers()) {
			for (int i = 0; i < 3; i++) {
				lawer.ask(this.accused);
			}
			for (Witness wit : this.witnesses) {
				for (int i = 0; i < 2; i++) {
					lawer.ask(wit);
				}
			}
		}
	}
}
