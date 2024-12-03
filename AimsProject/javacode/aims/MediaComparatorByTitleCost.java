package aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	public int compare(Media o1, Media o2)
	{
		if(o1.getTitle().compareTo(o2.getTitle()) < 0) return -1;
		if(o1.getTitle().compareTo(o2.getTitle()) > 0) return 1;
		
		if(o1.getCost() > o2.getCost()) return -1;
		if(o1.getCost() < o2.getCost()) return 1;
		return 0;
	}
}
