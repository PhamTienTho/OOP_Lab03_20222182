package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	@Override
	public int compare(Media o1, Media o2) {
		if(o1.getCost() < o2.getCost()) return 1;
		if(o1.getCost() > o2.getCost()) return -1;
		
		if(o1.getTitle().compareTo(o2.getTitle()) < 0) return -1;
		if(o1.getTitle().compareTo(o2.getTitle()) > 0) return 1;
		return 0;
	}
}
