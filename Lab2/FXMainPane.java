package application; 


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	private TextField input;
    private Label label1; 
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private HBox hbox1;
    private HBox hbox2; 


	
	//student Task #4:
	//  declare an instance of DataManager
    DataManager dm;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
    
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
        button1 = new Button("Hello");
        button2 = new Button("Howdy");
        button3 = new Button("Chinese");
        button4 = new Button("Clear");
        button5 = new Button("Exit");
        button6 = new Button("Spanish");
        label1  = new Label("Feedback :");

        input = new TextField();
        hbox1 = new HBox();
        hbox2 = new HBox();
        
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
        dm = new DataManager();
        HBox.setMargin(button1, new Insets(5));
        HBox.setMargin(button2, new Insets(5));
        HBox.setMargin(button3, new Insets(5));
        HBox.setMargin(button4, new Insets(5));
        HBox.setMargin(button5, new Insets(5));
        HBox.setMargin(button6, new Insets(5));
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
        hbox1.getChildren().addAll(button1,button2,button3,button6,button4,button5);
        hbox2.getChildren().addAll(label1,input);
		getChildren().addAll(hbox1,hbox2); 
		
		button1.setOnAction(this::handle);
	    button2.setOnAction(this::handle);
	    button3.setOnAction(this::handle);
	    button4.setOnAction(this::handle);
	    button5.setOnAction(this::handle);
	    button6.setOnAction(this::handle);
	}
	//Task #4:
		//  create a private inner class to handle the button clicks
	public void handle(ActionEvent event) {
		if(event.getTarget()==button1) {
			input.setText(dm.getHello());
		}else if(event.getTarget()==button2) {
			input.setText(dm.getHowdy());
		}else if(event.getTarget()==button3) {
			input.setText(dm.getChinese());
		}else if(event.getTarget()==button6) {
			input.setText(dm.getSpanish());
		}else if(event.getTarget()==button4) {
			input.setText("");
		}else if(event.getTarget()==button5) {
			Platform.exit();
		}
	}
}
	
