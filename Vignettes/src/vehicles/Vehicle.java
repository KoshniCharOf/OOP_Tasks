/**
 * 
 */
package vehicles;

import vignettes.Vignette;

/**
 * ����� �������� �������� ��� �������� ��������������:
 ����� �� ���������� �������� ,
 �������, ����� � �������� �� �������� ��,
 ������ �� ������������.
���������� �������� ����� : ����, �������, ������.
 *
 */
public abstract class Vehicle {

	protected String model;
	protected Vignette vignette;
	protected int year;
	protected int type;
	
	
	
	public Vehicle(String model) {
		if(model!=null && model!=""){
			this.model = model;
		}else{
			this.model = "Niva";
		}
		
	}
	public Vignette getVignette() {
		return vignette;
	}
	public void setVignette(Vignette vignette) {
		this.vignette = vignette;
	}
	public int getType() {
		return type;
	}
	@Override
	public String toString() {
		return  this.model ;
	}
	
	
	
}
