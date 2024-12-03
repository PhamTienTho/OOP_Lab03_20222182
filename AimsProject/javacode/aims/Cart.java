package aims.cart;

import java.util.ArrayList;
import java.util.Iterator;

import aims.media.DigitalVideoDisc;
import aims.media.Media;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public ArrayList<Media> getItemOrdered()
	{
		return this.itemsOrdered;
	}
	public float totalCost() 
	{
		float sum = 0;
		for(Media media : itemsOrdered)
		{
			sum += media.getCost();
		}
		return sum;
	}
	
	public void addMedia(Media media)
	{
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED)
		{
			if(this.contain(media))
			{
				System.out.println("The media existed");
				return;
			}
			itemsOrdered.add(media);
			System.out.println("Added the media: " + media.getTitle());
		}
		else System.out.println("The cart is full");
	}
	
	public void removeMedia(Media media)
	{
		Iterator<Media> iterator = itemsOrdered.iterator();
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
	
	public void print()
	{
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(Media media : itemsOrdered)
		{
			System.out.println(media.toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void search (String title)
	{
		for(Media media : itemsOrdered)
		{
			if(title.equals(media.getTitle()))
			{
				System.out.println(media.toString());
				return;
			}
		}
		System.out.println("The media doesnot exist");
	}
	
	public void search (int id)
	{
		for(Media media : itemsOrdered)
		{
			if(id == media.getId())
			{
				System.out.println(media.toString());
				return;
			}
		}
		System.out.println("The media doesnot exist");
	}
	
	public int getQtyOrderd()
	{
		return itemsOrdered.size();
	}
	
	public boolean contain(Media media)
	{
		for(Media m : itemsOrdered)
		{
			if(m.equals(media))
			{
				return true;
			}
		}
		return false;
	}
	
}