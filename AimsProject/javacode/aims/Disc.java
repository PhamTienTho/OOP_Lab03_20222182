package aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Disc() {
		super();
	}
	public Disc(int id, String title, String category, float cost, String directory, int length) {
		super(id, title, category, cost);
		this.setLength(length);
		this.setDirector(directory);
	}
	
	
}
