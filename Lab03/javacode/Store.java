package Main;

public class Store {
	private static final int MAX_NUMBERS_ITEMS = 20;
	private DigitalVideoDisc itemInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ITEMS];
	private int qtyItems = 0;
	public void addDVD(DigitalVideoDisc dvd)
	{
		if(qtyItems < MAX_NUMBERS_ITEMS) 
		{
			itemInStore[qtyItems] = dvd;
			qtyItems++;
			System.out.println("Added Item: " + dvd.toString());
		}
		else System.out.println("Failed");
	}
	public void removeDVD(DigitalVideoDisc dvd)
	{
		for(int i=0 ;i<qtyItems; i++)
		{
			if(dvd.equals(itemInStore[i]) == true)
			{
				for(int j=i; j<qtyItems-1; j++)
				{
					itemInStore[j] = itemInStore[j+1];
				}
				qtyItems--;
				System.out.println("Remove item successfully: " + dvd.getTitle());
				return;
			}
		}
		System.out.println("Failed");
	}
}
