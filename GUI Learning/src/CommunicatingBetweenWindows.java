import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CommunicatingBetweenWindows extends Application{
	
	Button button;
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Basic_Window"); //sets title of the main window
		button = new Button("Click Me");
		
		button.setOnAction(e -> {
			boolean result = ConfirmBox.display("Question:", "Are you studying GUI?");
			System.out.println(result);
		});
		
		StackPane layout = new StackPane(); 
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}

}
