import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtractandValidateInput extends Application{
	
	Stage window;
	Scene scene;
	Button button;
	Label label;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("GridPane"); 
		
		//Form
		label = new Label("UserAge: ");
		TextField ageInput = new TextField();
		button = new Button("Click Me");
		button.setOnAction(e -> isInt(ageInput, ageInput.getText())); //when you click on the button it calls the the isInt method
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(label, ageInput, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show(); 
	}

	private boolean isInt(TextField ageInput, String message) {
		try {
			int age = Integer.parseInt(ageInput.getText()); //this converts the text into an integer
			System.out.println("User is: " + age);
			return true;
		}catch(NumberFormatException e){
			System.out.println("Error Wrong " + message + " is not a number");
			return false;
		}
	}
	
}
