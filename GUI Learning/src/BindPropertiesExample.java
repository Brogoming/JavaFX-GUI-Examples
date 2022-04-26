import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindPropertiesExample extends Application{
	
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		window.setTitle("Binding"); //sets title of the main window
		
		//Input and Label
		TextField userInput = new TextField();
		userInput.setMaxWidth(200);
		Label label1 = new Label("Welcome to the site ");
		Label label2 = new Label("");
		
		HBox bottomText = new HBox(label1, label2);
		bottomText.setAlignment(Pos.CENTER);
		
		VBox vBox = new VBox(10, userInput, bottomText); //spacing of 10
		vBox.setAlignment(Pos.CENTER);
		
		label2.textProperty().bind(userInput.textProperty()); //text the user put into the field that will be displayed as a label. When the text field is changed this changes too
		
		Scene scene = new Scene(vBox, 300, 250);
		window.setScene(scene); //use this scene for the window of the program
		window.show(); //displays it to the user
	}

}
