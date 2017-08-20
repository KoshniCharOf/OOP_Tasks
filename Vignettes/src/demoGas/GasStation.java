package demoGas;

import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

import vehicles.Vehicle;
import vignettes.BusVin;
import vignettes.CarVin;
import vignettes.TruckVin;
import vignettes.Vignette;
import vignettes.Vignette.Period;

/**
 * Всяка бензиностанция има следните характеристики:
- Оборот за деня,
- Списък с винетки, налични за продажба

 */
public class GasStation {

	private int turnover;
	private TreeMap<Vignette, Integer> vinetes; //vin/instock
	
	public GasStation() {
		this.vinetes = new TreeMap<>();
		for (int i = 0; i < 10000; i++) {
			Vignette v = randomVinette();
			if(!vinetes.containsKey(v)){
				vinetes.put(v, 1);
			}else{
				vinetes.put(v, vinetes.get(v)+1);
			}
		}
		printVignettes();
	}
//	Бензиностанцията има следните операции :
	
/*		- при създаване да генерира на произволен принцип 10 000 винетки от
		всякакъв тип (за кола, за камион, за автобус, дневни, месечни, годишни).
		Изисква се бензиностанцията да поддържа този списък постоянно
		сортиран по цена.*/
	private Vignette randomVinette() {

		Vignette v = null;
		Period p = null;
		switch (new Random().nextInt(3)) {
		case 0:
			p = Period.DAY;
			break;
		case 1:
			p = Period.MONTH;
			break;
		case 2:
			p = Period.YEAR;
			break;
		default:
			break;
		}
		switch (new Random().nextInt(3)) {
		case 0:
			v= new CarVin(p);
			break;
		case 1:
			v= new TruckVin(p);
			break;
		case 2:
			v = new BusVin(p);
			break;
		default:
			break;
		}
		return v;
		
	}
	
/*		- Бензиностанцията има и операция за продажба на винетка за определено
		превозно средство и за даден период (дневна, месечна, годишна). След
		продажба на винетка останалите трябва да останат, отново в сортирана
		последователност.*/
	
	public Vignette sellVinette(Vehicle v, Period p){
		Vignette vin = newVinette(v, p);
		
		if(!this.vinetes.containsKey(vin) || this.vinetes.get(vin) <= 0){
			System.out.println("No vinette");
			return null;
/*			I would try to avoid null if not 10000 vinettes and ask for diff period
			for (Period p1 : Period.values()) {
				vin = newVinette(v, p1);
				if(this.vinetes.containsKey(vin) && this.vinetes.get(vin) > 0){//repeating code
					this.vinetes.put(vin, this.vinetes.get(vin)-1);
					this.turnover +=vin.getPrice();
					return vin; 
				}
			}	*/
			
		}else{
			this.vinetes.put(vin, this.vinetes.get(vin)-1);
			this.turnover +=vin.getPrice();
			
		}
		return vin; 
	}

	public void printVignettes(){
		System.out.println("GAS STATION VINETTES: ");
		for (Entry<Vignette, Integer> v : this.vinetes.entrySet()) {

			System.out.println(v.getKey() + " QUANTITY: " + v.getValue());
		}
	}
	
	public TreeMap<Vignette, Integer> getVinetes() {
		return vinetes;
	}
	
	private Vignette newVinette(Vehicle v, Period p){
			Vignette vin = null;
			switch (v.getType()) {
			case 123:
				vin = new CarVin(p); 
				break;
			case 456:
				vin = new BusVin(p); 
				break;
			case 789:
				vin = new TruckVin(p); 
				break;
			default:
				break;
			}
			return vin;
	}

	public int getTurnover() {
		return turnover;
	}
	
	public int tellThePrice(Vehicle v, Period p){
		
		Vignette vin = newVinette(v, p);
		
		return vin.getPrice();
	}
}
