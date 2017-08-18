package festival;
import java.time.LocalTime;
import java.util.ArrayList;

import festival.Musician.MusicianT;



public class Band {

	/* Групите са съставени от музиканти, свирещи на различни
инструменти или вокалисти. Всяка група има няколко песни, които ще изпълни.*/
	private String name;
	private ArrayList<Musician>  musicians ;
	private ArrayList<Song> songs;
	
	
	public Band(String name, int musicians, int songs) {
		super();
		this.name = Festival.validTextOrName(name);
		this.musicians = new ArrayList<>();
		for (int i = 0; i < musicians; i++) {
			this.musicians.add(new Musician(""));
		}
		this.songs = new ArrayList<>();
		for (int i = 0; i < songs; i++) {
			this.songs.add(new Song("title: "+(i+1), "text "+(i+1), 200+i*10));
		}
		
	}

	private boolean hasVocal(){
		for (Musician m : musicians) {
			if(m.isVocal()){
				return true;
			}
		}
		return false;
		
	}
	public LocalTime playAt(LocalTime time){
		System.out.println(this.name+" on scene at "+time);
		int duration = 0;
		LocalTime songStart = time;
		for (Song s : songs) {
			System.out.println("song start at "+songStart+" "+this+" plays "+(this.hasVocal()?s.getText():"Instrumental"));
			duration+=s.getDurration();
			songStart = songStart.plusSeconds(s.getDurration());
		}
		System.out.println("Thank you guys it is "+time.plusSeconds(duration)+" we need some rest");
		return time.plusSeconds(duration);
	}

	@Override
	public String toString() {
		return "Band [" + name + " musicians: " + musicians + "]";
	}
	
}
