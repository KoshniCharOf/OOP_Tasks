/**
 * 
 */
package products;

import java.util.Random;

/**
 * като всеки продукт има наименование и произволна цена между 5 и 15 лева.
 *
 */
public class Product implements Comparable<Product> {

	private String name;
	private int price;

	public Product() {
		String name = "Apple Apricot Avocado Banana Bilberry Blackberry Blackcurrant Blueberry "
				+ "Boysenberry Currant Cherry Cherimoya Cloudberry Coconut Cranberry Cucumber "
				+ "Custard apple Damson Date Dragonfruit Durian Elderberry Feijoa Fig Goji berry "
				+ "Gooseberry Grape Raisin Grapefruit Guava Honeyberry Huckleberry Jabuticaba "
				+ "Jackfruit Jambul Jujube Juniper berry Kiwifruit Kumquat Lemon Lime Loquat "
				+ "Longan Lychee Mango Marionberry Melon Cantaloupe Honeydew Watermelon Miracle "
				+ "fruit Mulberry Nectarine Nance Olive Orange Blood orange Clementine Mandarine "
				+ "Tangerine Papaya Passionfruit Peach Pear Persimmon Physalis Plantain Plum Prune "
				+ "dried plum Pineapple Plumcot Pomegranate Pomelo Purple mangosteen "
				+ "Quince Raspberry Salmonberry Rambutan Redcurrant Salal berry Salak Satsuma Soursop "
				+ "Star fruit Solanum quitoense Strawberry Tamarillo Tamarind Ugli fruit Yuzu";
		String[] names = name.split(" ");
		this.name = names[new Random().nextInt(names.length)];
		this.price = new Random().nextInt(11) + 5;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int compareTo(Product o) {

		return o.price - this.price;
	}

	@Override
	public String toString() {
		return name + " price: " + price + "  ";
	}

}
