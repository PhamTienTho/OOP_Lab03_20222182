package test.store;

import aims.media.DigitalVideoDisc;
import aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion king",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		store.removeMedia(dvd2);
		store.removeMedia(dvd1);
	}
}
