
public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dics1 = new DigitalVideoDisc("The Lion King", "Animation", 
				"Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dics1);
		DigitalVideoDisc dics2 = new DigitalVideoDisc("Star Wars", "Scinece Fiction", 
				"George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dics2);
		DigitalVideoDisc dics3 = new DigitalVideoDisc("Aladin", "Animation", 
				"George Lucas", 18.99f);
		anOrder.addDigitalVideoDisc(dics3);
		
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		System.out.println("So luong: " + anOrder.getQtyOrderd());
		
		DigitalVideoDisc disc4 = new DigitalVideoDisc("The Lion King", "Animation", 
				"Roger Allers", 87, 19.95f);
		anOrder.removeDigitalVideoDisc(disc4);
		
		System.out.println("New total cost is:");
		System.out.println(anOrder.totalCost());
		System.out.println("So luong: " + anOrder.getQtyOrderd());
		
	}

}
