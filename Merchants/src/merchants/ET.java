/**
 * 
 */
package merchants;

import supliers.Supplier;
import tradeObjects.TradeObject;

/**
 * � �� � ��������� �������� � ��� ������� ���� � ���������� �� ������ (��
 * ������ �� 5) � ��������� ���� ��������� �����. �� ���� �� ��������� ����� ��
 * ������� ��� ������ �� ������.
 *
 */
public class ET extends Merchant {

	public ET(double capital, String name) {
		super(capital, name);
	}

	@Override
	public void addTradeObject(TradeObject to) {
		if (this.tradeObject.size() < 1 && to.isETTrObject()) {//����� �� ������� ��� ������ �� ������
			this.tradeObject.add(to);
		}

	}

	@Override
	public void addSuplier(Supplier supp) {
		if (this.supplier.size() < 5 && supp.getDiscount() == 1) {//� ���������� �� ������ ��� ��������
			this.supplier.add(supp);
		}

	}

}
