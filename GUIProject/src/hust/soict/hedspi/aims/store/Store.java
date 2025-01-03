package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
	private static final int MAX_NUMBERS_ITEMS = 20;
	private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();
	public void addMedia(Media media)
	{
		if(itemsInStore.size() < MAX_NUMBERS_ITEMS)
		{
			if(this.contain(media))
			{
				System.out.println("The media existed");
				return;
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
	public boolean contain(Media media)
	{
		for(Media m : itemsInStore)
		{
			if(m.equals(media))
			{
				return true;
			}
		}
		return false;
	}
	
	public Media search(String title)
	{
		for(Media media : itemsInStore)
		{
			if(media.getTitle().equals(title)) 
			{
				return media;
			}
		}
		return null;
	}
	public void print_store()
	{
		System.out.println("--------------------------------");
		System.out.println("The list of items in the store:");
		for(Media media : itemsInStore)
		{
			System.out.println(media.toString());
		}
	}
	public ObservableList<Media> getItemsInStore()
	{
		return this.itemsInStore;
	}
}
