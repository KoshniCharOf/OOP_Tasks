package demoGas;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Random;

import driver.Driver;
import vehicles.Bus;
import vehicles.Car;
import vehicles.Truck;
import vehicles.Vehicle;


public class Demo {
	public static void main(String[] args) {

		// �� �� ��������� ���� ��������, ����� ��� �������� �����������:
		// 1. ��������� �� �������������� � ����������� ���������� �������. ��
		// �� ������� �� ������, ������ � ������� ���� � ����.
		GasStation monopOil = new GasStation();
		
		
		// 2. ��������� �� 20 ������� � ���������� �����. �� �� �� ����� ����������
		// �������� ����. �� �� �� ������ ��������������, �� ����� �� ��������� �������. -
		
		ArrayList<Driver> drivers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			drivers.add(new Driver("Pernishki " + (i + 1), new Random().nextInt(20000), monopOil));
		}
		
		// 3. ��������� �� 200 �������� �������� �� ���������� ��� (����,
		// �������, ������)
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			switch (new Random().nextInt(3)) {
			case 0:
				vehicles.add(new Car("Golf " + i));
				break;
			case 1:
				vehicles.add(new Truck("Actros " + i));
				break;
			case 2:
				vehicles.add(new Bus("Solaris " + i));
				break;
			default:
				break;
			}
		}
		// � �� ����� ������ �� �� ����� �� 10 �� ��� ���� ����� ��������
		// �������� �� ��������� �� ���� ������. - 10�.
		int k = 0;
		for (Driver d : drivers) {
			for (int m = 0; m < 10; m++) {
				if(k < vehicles.size()){
					d.addVehile(vehicles.get(k++));
				}
					
			}
		}
		// if want I equal vehicles next time
		// int t = 0;
		// for (Driver d : drivers) {
		// if(vehicles.get(t+1)==null)break;
		// for (int m = 0; m < vehicles.size()/drivers.size(); m++) {
		// d.addVehile(vehicles.get(t++));
		// }
		// }

		// 4. ����� 3-�� ������ �� ���������� ������� �� ����� �������� �������� ��
		// ���� 5 ������� �� ���������� ��������� ���� (���, �����, ������).
		// ���������� ������� �� ����� ������� �� �������� �� �������� �������� ��
		// ���������� ��������� ����. - 10�.
		for (int i = 0; i < drivers.size(); i++) {
			Driver d = drivers.get(i);
			if (i % 3 == 0) { 
				for (int j = 0; j < 5; ) {
					int v = new Random().nextInt(d.getVehicles().size());
					if(d.getVehicles().get(v).getVignette()==null){
						d.buyVinette(v, d.randomPeriod());
						j++;
					}
				}
				continue;
			}
			d.buyForAll();
		}
		
		// 5. �� �� ������ ���������� �� ������ ������� � ����� ���� �����,
		// ����� �� ������� �������� �������� ���� ������� � ������� ���� �� ������ ����
		// � ����� ���� �� �� ��������.
		LocalDate date1 = LocalDate.of(2017, 8, 17);
		for (Driver d : drivers) {
			System.out.println(d+" count of expiring vignettes before : "+date1+
								"   "+d.getExpiredVinettes(d.getVehicles(), date1).size());
		}
		
		// 6. �� �� ������� ������ �������� ������� � ���������������� � �������� �� ���� ���
		monopOil.printVignettes();
		System.out.println("    DAY TURNOVER:   " + monopOil.getTurnover());
		
		// 7. �� �� ������� ������ �������, ����� ���� ������� ������� �� ������ ����. -
		LocalDate date = LocalDate.of(2017, 8, 17);
		printExpiredVinetteTrucks(drivers, date);
	}

	static void printExpiredVinetteTrucks(ArrayList<Driver> d, LocalDate date) {
		System.out.println("EXPIRED VINETTE TRUCKS ON "+date);
		ArrayList<Vehicle> trucks = new ArrayList<>();
		//for each driver
		for (Driver dri : d) {
			for (Vehicle v : dri.getVehicles()) {
				//add all trucks    that has vinnete
				if (v.getVignette() != null && v.getVignette().getStickTime() == 10) {
					trucks.add(v);
				}
			}
			//print expired           //reuse old method
			for (Vehicle vehicle : dri.getExpiredVinettes(trucks, date)) {
				System.out.println(vehicle+" "+vehicle.getVignette());
			}
			trucks.clear();
		}
	}
}
