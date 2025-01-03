package hust.soict.hedspi.aims.screen;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

public class CartScreenController {
	
	private Cart cart;
	private Store store;
	private CartScreen cartscreen;
	
	@FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private Button btnPlay;
    
    @FXML
    private Button btnRemove;
    
    @FXML
    private Label totalCostLabel;

    public CartScreenController(Cart cart, Store store, CartScreen cartscreen)
    {
    	super();
    	this.cart = cart;
    	this.store = store;
    	this.cartscreen = cartscreen;
    }
    
    @FXML
    private void initialize()
    {
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	
    	tblMedia.setItems(this.cart.getItemOrdered());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {

					@Override
					public void changed(ObservableValue<? extends Media> observable, 
							Media oldValue, Media newValue) {
						if(newValue != null)
						{
							updateButtonBar(newValue);
						}
					}
				});
    	this.cart.getItemOrdered().addListener((ListChangeListener<Media>) change -> {
            updateCostTotat();
        });

    }
    
    @FXML
    void btnRemovePressed(ActionEvent event)
    {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    
    
    @FXML
    void viewStore(ActionEvent event) {
    	cartscreen.setVisible(false);
    	new StoreScreen2(store, cart, cartscreen);
    }
    
    void updateButtonBar(Media media)
    {
    	btnRemove.setVisible(true);
    	if(media instanceof Playable)
    	{
    		btnPlay.setVisible(true);
    	}
    	else btnPlay.setVisible(false);
    }
    
    void updateCostTotat()
    {
    	Platform.runLater(() -> {
    	totalCostLabel.setText(String.format("%.2f$", cart.totalCost()));
    	});
    }
    
    
}
