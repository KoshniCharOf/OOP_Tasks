/**
 * 
 */
package merchants;

import supliers.Supplier;
import tradeObjects.TradeObject;

/**
 *  ЕТ – едноличен търговец – той оперира само с доставчици на дребно (не
 * повече от 5) и притежава един търговски обект. ЕТ може да притежава будка на
 * улицата или сергия на пазара.
 *
 */
public class ET extends Merchant {

	public ET(double capital, String name) {
		super(capital, name);
	}

	@Override
	public void addTradeObject(TradeObject to) {
		if (this.tradeObject.size() < 1 && to.isETTrObject()) {//будка на улицата или сергия на пазара
			this.tradeObject.add(to);
		}

	}

	@Override
	public void addSuplier(Supplier supp) {
		if (this.supplier.size() < 5 && supp.getDiscount() == 1) {//с доставчици на дребно без отстъпка
			this.supplier.add(supp);
		}

	}

}
