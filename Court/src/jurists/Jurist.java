package jurists;

import citizens.Citizen;


/**
 * Всяко юридическо лице има следните характеристики
- Наименование;
- Длъжност;
- Стаж –брой години служба.
- Брой дела, в които са участвали.

Юридическите лица имат една от четири възможни длъжности: Съдия, Съдебен заседател, Адвокат и Прокурор. 
Не може да има юридическо лице с повече от една длъжност.
Всяко юридическо лице трябва да има следните възможности:
- Да задава въпрос на гражданин;
- Да си води записки с отговорите на гражданите.
 *
 */
public abstract class Jurist implements Comparable<Jurist>{
	
	protected String name;
	protected int servYears;
	protected int cases;

	
	public Jurist(String name, int servYears, int cases) {
		super();
		this.name = name;
		this.servYears = servYears;
		this.cases = cases;
		validExpirience();
	}

	protected abstract void validExpirience();
	
//	Всяко юридическо лице трябва да има следните възможности:
	
//		 Да задава въпрос на гражданин;
	public abstract void ask(Citizen c);
	
//		 Да си води записки с отговорите на гражданите.
	public abstract void takeNote();
	
	public void upCases(){
		this.cases++;
	}
	
	@Override
	public int compareTo(Jurist o) {
		
		return this.name.compareTo(o.name);
	}

	public int getCases() {
		return cases;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cases;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + servYears;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jurist other = (Jurist) obj;
		if (cases != other.cases)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (servYears != other.servYears)
			return false;
		return true;
	}

	
	
}
