package hust.soict.hedspi.aims.screen;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StoreScreen2 extends JFrame{
	
	private Store store;
	private Cart cart;
	private CartScreen cartScreen;
	public StoreScreen2(Store store, Cart cart, CartScreen cartScreen)
	{
		this.store = store;
		this.cart = cart;
		this.cartScreen = cartScreen;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Store");
		this.setVisible(true);
		this.setSize(new Dimension(900, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try
				{
					FXMLLoader loader = new FXMLLoader(getClass().
						getResource("/hust/soict/hedspi/aims/screen/store.fxml"));
					StoreScreenController controller = new StoreScreenController(store, cart, cartScreen, StoreScreen2.this);
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