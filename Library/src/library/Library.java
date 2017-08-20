
package library;

import java.time.Duration;
import java.time.LocalDateTime;

import java.util.Comparator;
import java.util.HashMap;

import java.util.Iterator;
import java.util.Map.Entry;

import java.util.TreeMap;
import java.util.TreeSet;

import library.readings.Reading;

/**
 *        В библиотеката се съдържат материали за четене.
 *
 *         каталогът на библиотеката е разделен на три части – учебници, книги и
 *         списания.
 */
public class Library {
	
	private HashMap<String, TreeMap<String, TreeSet<Reading>>> catalog = new HashMap<>();
/*
	 * Когато човек си вземе четиво под наем, библиотеката пази в архив
	 * информация за датата на взимане на четивото и датата, на която четивото
	 * трябва да се върне.
	 */
	// date taken / due date
	private TreeMap<Reading, HashMap<LocalDateTime, LocalDateTime>> archive = new TreeMap<>(new Comparator<Reading>() {

		@Override
		public int compare(Reading o1, Reading o2) {
			
			return o1.getTakeDate().compareTo(o2.getTakeDate());
		}
	});
	
	public void addReading(Reading r) {

		String section = r.getType();
		if (!catalog.containsKey(section)) {
			catalog.put(section, new TreeMap<>());
		}
		String subSection = r.getSubSection();
		if (!catalog.get(section).containsKey(subSection)) {
			catalog.get(section).put(subSection, new TreeSet<>());
		}
		catalog.get(section).get(subSection).add(r);

	}


	public double calculateFee(Person p) {
		if(p.getReadings().isEmpty()){
			return 0;
		}
		
		Reading reading = p.getReadings().poll();//the library pulls out of his hands :)
		LocalDateTime returnDate = LocalDateTime.now();
		System.out.println(p +" returns "+reading.getName());
		double sum = calculateSum(reading, returnDate);
		
		reading.setHistory(returnDate);
		reading.setProfit(sum);
		reading.setExpectProfit(0);
		reading.setAvailable(true);

		return sum;
	}
	
	private double calculateSum(Reading reading, LocalDateTime now){
		
		LocalDateTime takeDate = reading.getTakeDate();
		LocalDateTime dueDate = this.archive.get(reading).get(takeDate);
		
		long overdue = Duration.between(dueDate, now).getSeconds();
		
		System.out.println(" Overdue: "+(overdue<0?"in time":""+overdue+"s late"));
		
		double interest = 0;
		
		if (overdue > 0) {
			
			interest = reading.getFee() * 0.01 * overdue;
		}
		return reading.getFee() + interest;
	}

	/*
	 * Библиотеката подлежи на ревизия на всеки 31 дни. По време на ревизия в
	 * библиотеката трябва да могат да се изпълняват следните операции:
	 */
	public void printRevision(){
		System.out.println("Avaible readings count: "+getAllReadingsCount());
		printTakenInfo();
		printBlockBusters();
		
	}
	
	// • Да се върне броя на всички налични четива в библиотеката
	// HashMap<String, TreeMap<String, TreeSet<Reading>>> catalog
	private int getAllReadingsCount() {
		int count = 0;
		for (Entry<String, TreeMap<String, TreeSet<Reading>>> it : this.catalog.entrySet()) {
			for (Entry<String, TreeSet<Reading>> it2 : it.getValue().entrySet()) {
				for (Reading r : it2.getValue()) {
					if (r != null && r.isAvailable()) {
						count++;
					}
				}
			}
		}
		return count;
	}

	// Да се генерира файл(just print), в който са изброени всички взети в
	// момента четива, подредени по дата на тяхното взимане, както и общия им брой.
	// traverse archive HashMap<Reading, HashMap<String, String>> archive
	
	private void printTakenInfo() {
		System.out.println("print not returned by date taken");
		int count = 0;
		for (Entry<Reading, HashMap<LocalDateTime, LocalDateTime>> it : this.archive.entrySet()) {
			Reading r = it.getKey();
			
			if (!r.isAvailable()) {
				++count;
				double sumToMoment = calculateSum(r, LocalDateTime.now());
				System.out.println(r + " sum to moment " + sumToMoment+" Date taken: "+r.getTakeDate());
			}
		}
		System.out.println("Rented readings count: "+count);
		
	}

	// • Да се генерира файл, в който са изброени всички просрочени
	// вземания (име на четиво, име на читател, начислено обезщетение)
	// и общата сума, която се очаква да се получи като обезщетение от
	// тях. Списъкът във файла да е подреден по размер на
	// обезщетението, което се очаква.
	
	private void printBlockBusters() {
		// big copmarator because I don't want to loose money:)
		TreeSet<Reading> blockBusters = new TreeSet<>(new Comparator<Reading>() {
			@Override
			public int compare(Reading o1, Reading o2) {
				if (o1.getExpectProfit() - o2.getExpectProfit() == 0) {
					if (o1.getReaders().size() == o2.getReaders().size()) {
						return o1.getName().compareTo(o2.getName());
					}
					return o2.getReaders().size() - o1.getReaders().size();
				}
				return o1.getExpectProfit() - o2.getExpectProfit() < 0 ? 1 : -1;
			}
		});
		
		for (Entry<String, TreeMap<String, TreeSet<Reading>>> it : this.catalog.entrySet()) {
			for (Entry<String, TreeSet<Reading>> it2 : it.getValue().entrySet()) {
				for (Reading reading : it2.getValue()) {
					if(!reading.isAvailable()){
						reading.setExpectProfit(calculateSum(reading, LocalDateTime.now()));
						blockBusters.add(reading);
					}
					
				}
			}
		}
		double  sum = 0;
		int num = 0;
		for (Iterator<Reading> iterator = blockBusters.iterator(); iterator.hasNext();) {
	
			Reading r = iterator.next();
			sum += r.getExpectProfit();
			//(име на четиво, име на читател, начислено обезщетение)
			Person lastReader = r.getReaders().get(r.getReaders().size()-1);
			System.out.print("N. " + ++num + " Expectetd profit: " + r.getExpectProfit() + " "
			+ r.getName() + " " + r.getSubSection()+ " Reader:"+lastReader );
					
			System.out.println();
		}
		System.out.println("Expected sum to moment "+sum);
	}

	

	public HashMap<String, TreeMap<String, TreeSet<Reading>>> getCatalog() {
		return catalog;
	}

	public TreeMap<Reading, HashMap<LocalDateTime, LocalDateTime>> getArchive() {
		return archive;
	}
}
