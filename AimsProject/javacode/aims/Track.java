package aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return this.length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	@Override
	public void play()
	{
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Track)
		{
			Track track = (Track) obj;
			if(this.title.equals(track.getTitle()) && this.length == track.getLength())
				return true;
			else return false;
		}
		else return false;
	}
	
}
