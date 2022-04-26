import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BasicWindow extends Application{
	
	Button button;
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		window.setTitle("Basic_Window"); //sets title of the main window
		
		button = new Button();
		button.setText("Click Me"); //sets button text
		
		StackPane layout = new StackPane(); //this will position the button in the middle
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene); //use this scene for the window of the program
		window.show(); //displays it to the user
	}

}
