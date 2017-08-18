package festival;

import java.util.ArrayList;
import java.util.Random;

public class Musician {

	enum MusicianT {
		VOCAL, BASSGUITAR, GUITAR, KLAVIR, DRUM, GAIDA
	}

	private String name;
	private MusicianT type;
	private ArrayList<Song> songs;

	public Musician(String name) {
		super();
		this.name = Festival.validTextOrName(name);
		this.type = getNextType();
	}

	public MusicianT getNextType() {
		int pick = new Random().nextInt(MusicianT.values().length);
		return MusicianT.values()[pick];
	}

	public boolean isVocal() {
		return this.type == MusicianT.VOCAL;
	}

	@Override
	public String toString() {
		return "Musician [" + type + "]";
	}

}
