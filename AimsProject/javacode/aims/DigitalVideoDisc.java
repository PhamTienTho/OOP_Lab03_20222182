package aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDisc = 0;
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String directory, int length) {
		super(id, title, category, cost, directory, length);
		nbDigitalVideoDisc++;
	}

	public DigitalVideoDisc(String title, String category, String directory, int length, float cost)
	{
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.setLength(length);
		this.setDirector(directory);
		nbDigitalVideoDisc++;
	}
	
	public DigitalVideoDisc(String title)
	{
		super();
		this.setTitle(title);
	}
	@Override
	public void play()
	{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
}
