import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PropertiesExample extends Application{
	
	Button button;
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		window.setTitle("Properties"); //sets title of the main window
		
		Person person1 = new Person();
		person1.firstNameProperty().addListener((v, oldValue, newValue) -> {
			System.out.println("Name change to " + newValue);
			System.out.println("firstNameProperty(): " + person1.firstNameProperty());
			System.out.println("getFirstName(): " + person1.getFirstName());
		}); //when we give the variable a name the listener will kick off
		
		button = new Button("Click Me");
		button.setOnAction(e -> person1.setFirstName("Dakota"));
		
		StackPane layout = new StackPane(); //this will position the button in the middle
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene); //use this scene for the window of the program
		window.show(); //displays it to the user
	}

}
