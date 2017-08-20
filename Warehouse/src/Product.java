

/**
 * за всеки продукт имаме информация за име и наличност в склада. 
 *  Продуктите са групирани по тип. 
 *   При създаване на склада в него трябва да има три типа продукти:
  FRUITS, VEGETABLES, MEATS, като за всеки тип има по 15 единици наличност на следните продукти:
   • FRUITS: Banana, Orange, Apple.
   • VEGETABLES: Potato, Eggplant, Cucumber. 
   • MEATS: Pork, Beef, Chicken
 *
 */
public class Product {

	
	public static final String[][] names = {{ "BANANA","ORANGE", "APPLE"}, // 0 fruits
											{ "POTATO", "EGGPLANT", "CUCUMBER"},// 1 vegetable
											{ "PORK", "BEEF", "CHICKEN"}};// 2 meats
	
	public static final String[] types = {"FRUITS", "VEGETABLES", "MEATS"};
	
	private String name;
	private String type;
	
	public Product(String name) {

		this.name = "Pumpkin";
		this.type = "GREEN";
		
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names[i].length; j++) {
				if(name.equalsIgnoreCase(names[i][j])){
					this.name = name;
					this.type = types[i];
					break;
				}
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	

}
