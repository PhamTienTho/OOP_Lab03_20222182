package aims.store;

import java.util.ArrayList;
import java.util.Iterator;

import aims.media.DigitalVideoDisc;
import aims.media.Media;

public class Store {
	private static final int MAX_NUMBERS_ITEMS = 20;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media)
	{
		if(itemsInStore.size() < MAX_NUMBERS_ITEMS)
		{
			for(Media m : itemsInStore)
			{
				if(m.getTitle().equals(media.getTitle()))
				{
					System.out.println("The media existed");
					return;
				}
			}
			itemsInStore.add(media);
			System.out.println("Added the media: " + media.getTitle());
		}
		else System.out.println("The cart is full");
	}
	
	public void removeMedia(Media media)
	{
		Iterator<Media> iterator = itemsInStore.iterator();
		while(iterator.hasNext())
		{
			Media m = iterator.next();
			if(m.getTitle().equals(media.getTitle())) 
			{
				iterator.remove();
				System.out.println("Removed the media: " + media.getTitle());
				return;
			}
		}
		System.out.println("Could not be found: " + media.getTitle());
	}
}
