package hust.soict.hedspi.aims.screen;

import java.io.IOException;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StoreScreenController {

	private Store store;
	private Cart cart;
	private CartScreen cartScreen;
	private StoreScreen2 storeScreen2;
	
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colCategory;

    @FXML
    private TableColumn<Media, Float> colCost;

    @FXML
    private TableColumn<Media, String> colTitle;
    
    @FXML
    void addBookToStore(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().
    				getResource("/hust/soict/hedspi/aims/screen/addBookToStore.fxml"));
    	
    		Stage stage = new Stage();
    	
    		AddBookToStoreController controller = new AddBookToStoreController(store, stage, storeScreen2);
    	
    		loader.setController(controller);
			stage.setScene(new Scene(loader.load()));
			
			this.storeScreen2.setVisible(false);
			stage.showAndWait();
			this.storeScreen2.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void addCDDVDToStore(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().
    				getResource("/hust/soict/hedspi/aims/screen/AddDiscToStore.fxml"));
    		
    		Stage stage = new Stage();
    		AddDiscToStoreController controller = new AddDiscToStoreController(store, stage);
    		loader.setController(controller);
    		stage.setScene(new Scene(loader.load()));
    		
    		storeScreen2.setVisible(false);
    		stage.showAndWait();
    		storeScreen2.setVisible(true);
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    		
    }

    @FXML
    void addMediaToCart(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	try {
			cart.addMedia(media);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void viewCart(ActionEvent event) {
    	this.cartScreen.setVisible(true);
    	this.storeScreen2.dispose();
    }
    
    public StoreScreenController(Store store, Cart cart, CartScreen cartScreen, StoreScreen2 storeScreen2)
    {
    	super();
    	this.store = store;
    	this.cart = cart;
    	this.cartScreen = cartScreen;
    	this.storeScreen2 = storeScreen2;
    }
    
    @FXML
    private void initialize()
    {
    	colTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	
    	tblMedia.setItems(this.store.getItemsInStore());
    }

}
