package application;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {
	   
	/**
	 * The main method for the GUI example program JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	public static void main(String[] args) {
		launch(args);   
	}
		   
	@Override
	public void start(Stage stage) throws IOException {
		//student Task #1:
		//  instantiate the FXMainPane, name it root
		//  set the scene to hold root
		//set stage title
		FXMainPane_Task3 root = new FXMainPane_Task3();
		stage.setTitle("Hello World GUI");

        stage.setScene(new Scene(root, 300, 200));
		//display the stage 
		stage.show();

	}
}
