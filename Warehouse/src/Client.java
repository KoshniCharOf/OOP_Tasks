
import java.util.Random;

/*Да се създадат девет обекта, които описват клиенти в магазин. За всеки от трите създадени
обекта да се зададат по три от тези клиента. На всеки 5 секунди клиентите купуват
произволно количество (между 1 и 4) от произволен продукт в магазина и така намаляват
количеството на продукта в съответния магазин. Когато продукта не е с достатъчно
количество, клиентът трябва да изчака продукта да бъде доставен.*/

public class Client {
	
	private static int id = 1;
	//private Stack<Product> bag;// no bag we just have fun at the store
	
	public String buy(){
		
		System.out.println("Hmm what to buy...");
		int pick = new Random().nextInt(Product.names.length);
		int up = new Random().nextInt(Product.names[pick].length);
		//constant 
		return Product.names[pick][up];
		
	}

	public String getName() {
		return "Michka "+id++; //don'n get Michka often :)
	}
	

}
