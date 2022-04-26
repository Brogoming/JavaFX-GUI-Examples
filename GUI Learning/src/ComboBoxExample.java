import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox; //new
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxExample extends Application{
	
	Stage window;
	Scene scene;
	Button button;
	ComboBox<String> comboBox;
	
	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("ComboBox Demo"); 
		button = new Button("Submit");
		
		comboBox = new ComboBox<>(); //like a choice box
		comboBox.getItems().addAll("Spider-Man", "The Princess Bride", "Django"); 
		comboBox.setPromptText("What is your Favorite Movie?");
		
		comboBox.setEditable(true); //gives the user the option to write in their own movie
		
		button.setOnAction(e -> printMovie());
		comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue())); //prints when selected
	
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(comboBox, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show(); 
	}
	
	//Print out a movie
	private void printMovie() {
		System.out.println(comboBox.getValue()); //gets value then prints value when the button is selected
	}
}
