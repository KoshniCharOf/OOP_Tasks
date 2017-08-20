package court;
import java.util.Random;
import java.util.TreeSet;

import citizens.Accused;
import citizens.Witness;
import jurists.Prosecutor;


/**
 * Ако е наказателно –съдебните заседатели са 13.
 * Ако делото е наказателно, обвинителя е прокурор.
 *
 */
public class CriminalCase extends Case{

	private Prosecutor prosecutor;
	
	public CriminalCase(Accused accused, TreeSet<Witness> witnesses,Court court) {
		super(accused, witnesses, court);
		asignJuri(13);
		this.prosecutor = court.getProsecutors().get(new Random().nextInt(court.getProsecutors().size()));
		this.jurists.add(prosecutor);
	}

	
//	3. Ако делото е наказателно, прокурора задава 5 въпроса на обвиняемия,
//	след което задава по 5 въпроса на всеки от свидетелите.
	
	@Override
	public void askingAccusedAndWitnesses() {
		System.out.println("CRIMINAL CASE N: "+this.hashCode());
		System.out.println("=====Prosecutor=====");
		for (int i = 0; i < 5; i++) {
			prosecutor.ask(accused);
		}
		for (Witness wit : this.witnesses) {
			for (int i = 0; i < 5; i++) {
				prosecutor.ask(wit);
			}
		}	
	}


	void setProsecutor(Prosecutor prosecutor) {
		this.prosecutor = prosecutor;
	}

}
