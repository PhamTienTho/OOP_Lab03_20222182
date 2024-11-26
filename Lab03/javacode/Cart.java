package Main;
public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private static int qtyOrdered = 0;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	int getQtyOrderd()
	{
		return qtyOrdered;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) 
	{
		if( this.qtyOrdered < MAX_NUMBERS_ORDERED )
		{
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else System.out.println("The cart is almost full");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		for(int i=0; i < qtyOrdered; i++)
		{
			if( itemsOrdered[i].equals(disc) == true)
			{
				for(int j=i; j<qtyOrdered-1; j++)
				{
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyOrdered--;
				System.out.println("The disc has been removed");
				return;
			}
		}
		System.out.println("No disc in the cart found");
	}
	
	public float totalCost() 
	{
		float sum = 0;
		for(int i=0; i<qtyOrdered; i++)
		{
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList)
	{
		for(int i=0; i<dvdList.length; i++)
		{
			if(qtyOrdered < MAX_NUMBERS_ORDERED)
			{
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
			}
			else break;
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
	{
		if(qtyOrdered < MAX_NUMBERS_ORDERED)
		{
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
		}
		else return;
		if(qtyOrdered < MAX_NUMBERS_ORDERED)
		{
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
		}
		else return;
	}
	public void print()
	{
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i=0; i<qtyOrdered; i++)
		{
			System.out.println(itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void search (String title)
	{
		for(int i=0; i<qtyOrdered; i++)
		{
			if(title == itemsOrdered[i].getTitle())
			{
				System.out.println(itemsOrdered[i].toString());
			}
		}
	}
}

