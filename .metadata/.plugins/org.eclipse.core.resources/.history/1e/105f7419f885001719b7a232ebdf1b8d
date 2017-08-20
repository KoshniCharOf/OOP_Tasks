/**
 * 
 */
package tradeObjects;

import java.util.Random;

/**
 * @author NIE
 *1. сергия на пазара – площ между 2 и 10 квадратни метра. Годишен данък
към държавата в размер на 50 лева.
 */
public class Sergia extends TradeObject {

	public Sergia(String name, int area) {
		super(name, area);
		
	}

	@Override
	public int validArea(int area) {
		if(area < 2 || area > 10){
			return new Random().nextInt(9)+2;
		}
		return area;
	}

	@Override
	public double validTax(double tax) {
		return 50;
	}

	@Override
	public boolean isChainTrObject() {
		return false;
	}

}
