package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookToStoreController {

	private Store store;
	private Stage stage;
	private StoreScreen2 storeScreen2;
	
    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtTitle;
    
    public AddBookToStoreController(Store store, Stage stage, StoreScreen2 storeScreen2)
    {
    	this.storeScreen2 = storeScreen2;
    	this.store = store;
    	this.stage = stage;
    }

    @FXML
    void addToStore(ActionEvent event) {
    	try {
    		String title = txtTitle.getText();
    		String category = txtCategory.getText();
    		float cost = Float.parseFloat(txtCost.getText());
    	
    		Book book = new Book(title, category, cost);
    		store.addMedia(book);
    		
    		
    		stage.close();
    		storeScreen2.setVisible(true);
    	}
    	catch (Exception e) {
			System.out.println("Invalid cost value");
		}
    	
    	
    }
    

    @FXML
    void backToStore(ActionEvent event) {
    	stage.close();
    	storeScreen2.setVisible(true);
    }

}
