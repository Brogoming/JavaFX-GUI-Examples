import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreatingAlertBoxes extends Application{
	
	Stage window;
	Button button;

	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Creates Alert Boxes");
		
		button = new Button();
		button.setText("Click Me"); 
		button.setOnAction(e -> AlertBox.display("The Alert Box", "You found the Alert Box!"));
		
		StackPane layout = new StackPane(); 
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
}	
