
package hospital;

/**
 * 
 В болницата работят лекари и медицински сестри.
 * Лекарите имат име, телефонен номер и специализация. 
 * Медицинските сестри имат име, години стаж и телефонен номер.
 * всеки пациент името, годините и телефонния номер.
 */
public abstract class Person {

	protected String name;
	protected String phoneNumber;
	
	public Person(String name) {
		
		this.name = Val.validStr(name);
		
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
