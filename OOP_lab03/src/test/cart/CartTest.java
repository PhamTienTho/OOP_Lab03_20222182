package test.cart;
import aims.cart.Cart;
import aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion king",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", "Ricardor", 90, 18.99f);
		cart.addMedia(dvd3);
		
		cart.print();
		
		String title1 = "Star Wars";
		cart.search(title1);
		String title2 = "The Lion king";
		cart.search(title2);
		String title3 = "Aladin";
		cart.search(title3);
		
	}
}
