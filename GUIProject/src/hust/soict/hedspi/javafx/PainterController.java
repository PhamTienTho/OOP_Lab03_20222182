package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton eraserTool;

    @FXML
    private ToggleGroup iden;

    @FXML
    private RadioButton penTool;
    
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle;
    	if((RadioButton)iden.getSelectedToggle() == penTool) 
    	{
    		newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
    	}
    	else if((RadioButton)iden.getSelectedToggle() == eraserTool) 
    	{
    		newCircle = new Circle(event.getX(), event.getY(), 18, Color.WHITE);
    	}
    	else 
    	{
    		return;
    	}
    	drawingAreaPane.getChildren().add(newCircle);
    }

}