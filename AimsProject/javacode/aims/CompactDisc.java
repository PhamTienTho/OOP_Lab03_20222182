package aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}

	public CompactDisc() {
		super();
	}

	public CompactDisc(int id, String title, String category, float cost, String directory, int length, String artist, List<Track> tracks) {
		super(id, title, category, cost, directory, length);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public boolean addTrack(Track track)
	{
		for(int i=0; i<tracks.size(); i++)
		{
			if(tracks.get(i).getTitle().equals(track))
			{
				System.out.println("The track already existed");
				return false;
			}
		}
		tracks.add(track);
		this.setLength(getLength() - track.getLength());
		System.out.println("the track is added sucessfully");
		return true;
	}
	
	public boolean removeTrack(Track track)
	{
		Iterator<Track> iterator = tracks.iterator();
		while(iterator.hasNext())
		{
			Track current = iterator.next();
			if(track.getTitle().equals(current.getTitle()))
			{
				this.setLength(getLength() - current.getLength());
				iterator.remove();
				System.out.println("The track is removed successfully");
				return true;
			}
		}
		System.out.println("The track does not exist");
		return false;
	}
	@Override
	public int getLength()
	{
		int result = 0;
		for(Track track : tracks)
		{
			result += track.getLength();
		}
		this.setLength(result);
		return result;
	}
	
	@Override
	public void play()
	{
		System.out.println("Playing compactDVD: " + this.getTitle());
		System.out.println("The artist: " + this.getArtist());
		for(Track track : tracks)
		{
			track.play();
		}
	}
	
	
}
