package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class Test2 {
	public static void main(String[] args) {
		Store store = new Store();
		store.addMedia(new Book("naruto", "anime", 120));
		Cart cart = new Cart();
		
		new CartScreen(cart, store);
	}
}
