package aims.disc;
public class DigitalVideoDisc {
	private static int nbDigitalVideoDisc = 0;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	@Override
	public boolean equals ( Object obj )
	{
		DigitalVideoDisc disc = (DigitalVideoDisc) obj; 
		if(this.category == disc.getCategory() && 
				this.cost == disc.getCost() && 
				this.director == disc.getDirector() &&
				this.length == disc.getLength() && 
				this.title == disc.getTitle())  return true;
		else return false;
	}
	@Override
	public String toString()
	{
		return ("DVD - " + getTitle() + " - " + getCategory()
				+ " - " + getDirector() + " - " + getLength()
				+ ": " + getCost() + "$");
	}
	
}
