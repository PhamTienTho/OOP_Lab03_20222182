package test.cart;
import aims.disc.DigitalVideoDisc;
import aims.cart.Cart;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion king",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		store.addDVD(dvd3);
		
		store.removeDVD(dvd2);
		store.removeDVD(dvd1);
		store.removeDVD(dvd3);
	}
}
