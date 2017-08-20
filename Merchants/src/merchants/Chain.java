/**
 * 
 */
package merchants;

import supliers.Supplier;
import tradeObjects.TradeObject;

/**
 *  Търговска верига – работи с много доставчици на дребно и на едро (не повече
 * от 15) и има много търговски обекти (не повече от 10). Притежава както будки,
 * така и магазини в моловете.
 *
 */
public class Chain extends Merchant {

	public Chain(double capital, String name) {
		super(capital, name);

	}

	@Override
	public void addTradeObject(TradeObject to) {
		if (this.tradeObject.size() < 10 && to.isChainTrObject()) {
			this.tradeObject.add(to);
		}
	}

	@Override
	public void addSuplier(Supplier supp) {
		if (this.supplier.size() < 15) {
			this.supplier.add(supp);
		}
	}

}
