package festival;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * 
 */

/**
 *  Фестивалът съдържа няколко акта. Всеки акт включва група, която
 *         изпълнява няколко песни, начало и край на изпълнението. Групите са
 *         съставени от музиканти, свирещи на различни инструменти или
 *         вокалисти. Всяка група има няколко песни, които ще изпълни. Всяка
 *         песен има заглавие и текст. Ако групата има вокалист, то в
 *         отразяването на фестивала, трябва да се види какво е изпял
 *         вокалистът, както и как са свирили останалите музиканти. Ако групата
 *         няма вокалист, приемаме, че пестента е изпълнена като инструментал и
 *         текстът й не бива да се отпечатва.
 */
public class Festival {

	public static void main(String[] args) {

		LocalTime time = LocalTime.of(20, 00); // откриване

		ArrayList<Band> bandi = new ArrayList<>();
		bandi.add(new Band("Queen", 7, 6));// подгряващи
		bandi.add(new Band("KISS", 5, 5));// подгряващи
		bandi.add(new Band("Radka Krashnata", 3, 10));// и звездата на вечерта

		for (Band b : bandi) {
			time = b.playAt(time);
		}

	}

	static String validTextOrName(String s) {
		if (s != null && !s.isEmpty()) {
			return s;
		}
		return "CENSURED";
	}
}
