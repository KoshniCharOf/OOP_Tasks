package festival;

public class Song {

	private String title;
	private String text;
	private int durration;// sec

	public Song(String title, String text, int durration) {
		super();
		this.title = Festival.validTextOrName(title);
		this.text = Festival.validTextOrName(text);
		this.durration = durration > 0 ? durration : 180;
	}

	// this is also true
	public boolean isInstrumental() {
		return this.text.isEmpty();
	}

	public int getDurration() {
		return durration;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Song [" + title + "  text: " + (text.isEmpty() ? "Instrumental" : text) + "]";
	}

}
