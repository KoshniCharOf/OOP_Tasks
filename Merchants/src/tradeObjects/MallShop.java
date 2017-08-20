
package tradeObjects;

import java.util.Random;

/**
 * 
 * 2. магазин в мола – площ между 10 и 100 квадратни метра. Годишен данък
към държавата в размер на 150 лева.
 */
public class MallShop extends TradeObject {

	public MallShop(String name, int area) {
		super(name, area);
	}

	@Override
	public int validArea(int area) {
		if(area < 10 || area > 100){
			return new Random().nextInt(91)+10;
		}
		return area;
	}

	@Override
	public double validTax(double tax) {
		return 150;
	}

	@Override
	public boolean isETTrObject() {
		
		return false;
	}
	
}
