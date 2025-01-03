package hust.soict.hedspi.aims.screen;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.CartScreenController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class CartScreen extends JFrame{
	
	private Cart cart;
	private Store store;
	
	public Cart getCart()
	{
		return this.cart;
	}
	
	public CartScreen(Cart cart, Store store)
	{
		super();
		
		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		this.setSize(new Dimension(900, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
				FXMLLoader loader = new FXMLLoader(getClass()
						.getResource("/hust/soict/hedspi/aims/screen/cart.fxml"));
				CartScreenController controller = new CartScreenController(cart, store, CartScreen.this);
				loader.setController(controller);
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
