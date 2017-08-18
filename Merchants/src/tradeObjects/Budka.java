/**
 * 
 */
package tradeObjects;

import java.util.Random;

/**
 *  3. будка на улицата – площ между 4 и 6 квадратни метра. Годишен
 *         данък към държавата в размер на 50 лева.
 */
public class Budka extends TradeObject {

	public Budka(String name, int area) {
		super(name, area);
		
	}

	@Override
	public int validArea(int area) {
		if (area < 4 || area > 6) {
			return new Random().nextInt(3) + 4;
		}
		return area;
	}

	@Override
	public double validTax(double tax) {
		return 50;
	}
}
