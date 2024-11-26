package test.cart;
import aims.disc.DigitalVideoDisc;
import aims.cart.Cart;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion king",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		cart.print();
		
		String title1 = "Star Wars";
		cart.search(title1);
		String title2 = "The Lion king";
		cart.search(title2);
		String title3 = "Aladin";
		cart.search(title3);
		