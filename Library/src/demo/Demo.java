package demo;

import java.time.LocalDateTime;

import library.Library;
import library.Person;
import library.readings.Book;
import library.readings.Magazine;
import library.readings.Reading;
import library.readings.TextBook;
import library.readings.Book.Janre;
import library.readings.Magazine.Category;
import library.readings.TextBook.Theme;

public class Demo {
	public static void main(String[] args) {
		
		
		Reading book1 = new Book("Animals", "me", "Koceto", Janre.KIDS);
		Reading book2 = new Book("Humans", "me", "Koceto", Janre.ROMANCE);
		Reading book3 = new Book("Monkeys", "me", "Koceto", Janre.ROMANCE);
		
		Reading mag1 = new Magazine("Jenata dnes", "me", Category.FASHION, 1);
		Reading mag2 = new Magazine("Talpata utre", "me", Category.FISHING, 7);
		Reading mag3 = new Magazine("Jenata dnes", "me", Category.FASHION, 2);
		
		Reading tex1 = new TextBook("Aapromat", "he", Theme.MATHEMATICS, "Valkov");
		Reading tex2 = new TextBook("Mathematics", "he", Theme.MATHEMATICS, "Lesichev");
		Reading tex3 = new TextBook("Java for everyone 3rd Edition", "S&T", Theme.PROGRAMING, "S&T");
		
		Library yavorov = new Library();
		yavorov.addReading(book1);
		yavorov.addReading(book2);
		yavorov.addReading(book3);
		yavorov.addReading(mag1);
		yavorov.addReading(mag2);
		yavorov.addReading(mag3);
		yavorov.addReading(tex1);
		yavorov.addReading(tex2);
		yavorov.addReading(tex3);
		
		Person goshko = new Person("Goshko");
		Person boshko = new Person("Boshko");
		goshko.previewCatalog(yavorov);
		goshko.previewSection(yavorov, "BOOKS");
		
		//minus seconds - for test purpose
		goshko.takeReading(LocalDateTime.now().minusSeconds(500), yavorov, "BOOKS", "Humans");
		boshko.takeReading(LocalDateTime.now().minusSeconds(1000), yavorov, "TEXTBOOKS", "Java for everyone 3rd Edition");
		goshko.takeReading(LocalDateTime.now(), yavorov, "BOOKS", "Humans");
		goshko.takeReading(LocalDateTime.now().minusSeconds(350), yavorov, "BOOKS", "Monkeys");
		boshko.takeReading(LocalDateTime.now(), yavorov, "Magazines", "Jenata dnes");
		
		
		
		System.out.println("======revision-start======");
		
		yavorov.printRevision();
	
		System.out.println("========revision-end=====");
		
		goshko.returnReading( yavorov);

		
		
	}

}
