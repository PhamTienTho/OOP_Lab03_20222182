package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddDiscToStoreController {

	private Store store;
	private Stage stage;
	
    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtLength;

    @FXML
    private TextField txtTitle;

    public AddDiscToStoreController(Store store, Stage stage)
    {
    	this.store = store;
    	this.stage = stage;
    }
    @FXML
    void addToStore(ActionEvent event) {
    	String title = txtTitle.getText();
    	String category = txtCategory.getText();
    	float cost = Float.parseFloat(txtCost.getText());
    	int length = Integer.parseInt(txtLength.getText());
    	
    	DigitalVideoDisc disc = new DigitalVideoDisc(title, category, cost, length);
    	
    	store.addMedia(disc);
    	this.stage.close();
    }

    @FXML
    void backToStore(ActionEvent event) {
    	this.stage.close();
    }

}
