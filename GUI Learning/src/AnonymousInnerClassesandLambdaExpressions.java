import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AnonymousInnerClassesandLambdaExpressions extends Application {
	
	Button button;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Anonymous Inner Classes and Lambda Expressions"); 
		
		button = new Button();
		button.setText("Click Me");
		button.setOnAction(new EventHandler<ActionEvent>(){ //A more compact button method used just one time
			@Override
			public void handle(ActionEvent event) {
				System.out.println("I am Anonymous inner class");
			}
		});
		
		button = new Button();
		button.setText("Lambda");
		button.setOnAction(e -> System.out.println("This is a lambda expression"));
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
}
