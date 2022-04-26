import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClosingtheProgramProperly extends Application{
	
	Button button;
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		primaryStage.setTitle("Closing the Program Properly"); 
		
		window.setOnCloseRequest(e -> {
			e.consume(); //this will consume the event instead of letting it close 
			closeProgram();
		}); //whenever you click the X icon
		
		button = new Button("Close Program");
		button.setOnAction(e -> closeProgram()); //whenever you click the Close Program Button, it will call the closeProgram method
		
		StackPane layout = new StackPane(); 
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	
	private void closeProgram() { //closeProgram method that calls the ConfirmBox class to get the boolean value
		Boolean answer = ConfirmBox.display(null, "Are you sure?");
		if(answer) { //if answer is true
			System.out.println("File is saved");
			window.close();
		}
	}
}
