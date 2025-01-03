package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class Test {
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc( 1, "Naruto", "Anime", 300, "dir1", 120);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc( 5, "AOT", "Anime", 205, "dir2", 130);
		
		CompactDisc CD3 = new CompactDisc( 3, "Gaoranger", "Superman", 125, "dir3", 200, "Artist1");
		CompactDisc CD4 = new CompactDisc( 4, "Classic Music", "music", 500, "dir2", 400, "Artist2");
		CompactDisc CD6 = new CompactDisc( 6, "CD6", "Music", 125, "dir3", 200, "Artist6");
		CompactDisc CD9 = new CompactDisc( 9, "CD9", "Drama", 190, "dir4", 290, "Artist9");
		
		Book book2 = new Book(2, "Book2", "Novel", 280);
		Book book7 = new Book(7, "Book7", "Novel", 200);
		Book book8 = new Book(8, "Book8", "Novel", 100);
		
		store.addMedia(dvd1);
		store.addMedia(book2);
		store.addMedia(CD3);
		store.addMedia(CD4);
		store.addMedia(dvd5);
		store.addMedia(CD6);
		store.addMedia(book7);
		store.addMedia(book8);
		store.addMedia(CD9);
		
		Cart cart = new Cart();
		new CartScreen(cart, store);
		
	}
}
