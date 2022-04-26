import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HandleUserEvents extends Application implements EventHandler<ActionEvent>{
	
	Button button;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Basic_Window"); 
		
		button = new Button();
		button.setText("Click Me");
		button.setOnAction(this); //whenever they click this button that code to handle this is in this class. Basically look in this class for the handle method
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == button) { //if the button is clicked it will sysout “You clicked me!”
			System.out.println("You clicked me!");
		}
	}
}
