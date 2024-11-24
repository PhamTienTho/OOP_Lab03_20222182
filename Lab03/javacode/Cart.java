
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
					itemsOrdered[j] = itemsOrdered[i];
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
}
