import javafx.application.Application;
import javafx.geometry.Insets; //new
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane; //new
import javafx.stage.Stage;

public class CSSCustom extends Application{
	
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("CSS Custom"); 
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10)); 
		grid.setVgap(8);
		grid.setHgap(10);
		
		//name label
		Label nameLabel = new Label("Username: ");
		nameLabel.setId("label-bold"); //sets the variable to the Id
		GridPane.setConstraints(nameLabel, 0, 0);
		
		//name Input
		TextField nameInput = new TextField(); 
		nameInput.setPromptText("Userlog"); 
		GridPane.setConstraints(nameInput, 1, 0);
		
		//password label
		Label passwordLabel = new Label("Password: ");
		GridPane.setConstraints(passwordLabel, 0, 1); 
		
		//name Input
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("Password"); 
		GridPane.setConstraints(passwordInput, 1, 1); 
		
		//Login 
		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2); 
		
		//Sign up 
		Button signUpButton = new Button("Sign Up");
		signUpButton.getStyleClass().add("button-blue"); //the sign up button has the style of button-blue from the css file
		GridPane.setConstraints(signUpButton, 1, 3); 
		
		loginButton.setOnAction(e -> { //when clicked the GUI will change to a different style
			setUserAgentStylesheet(STYLESHEET_CASPIAN);
		});
		
		grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, loginButton, signUpButton);
		Scene scene = new Scene(grid, 300, 250);
		scene.getStylesheets().add("CSS1.css"); //overrides all the current styles to the GUI
		window.setScene(scene);
		window.show(); 
	}

}
