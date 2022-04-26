import javafx.application.Application;
import javafx.geometry.Insets; //new
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane; //new
import javafx.stage.Stage;

public class CSSThemesandStyles extends Application{
	
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("CSSTHEME"); 
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10)); 
		grid.setVgap(8);
		grid.setHgap(10);
		
		//name label
		Label nameLabel = new Label("Username: ");
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
		
		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2); 
		
		loginButton.setOnAction(e -> { //when clicked the GUI will change to a different style
			setUserAgentStylesheet(STYLESHEET_CASPIAN);
		});
		
		grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, loginButton);
		Scene scene = new Scene(grid, 300, 250);
		scene.getStylesheets().add("CSS1.css"); //overrides all the current styles to the GUI
		window.setScene(scene);
		window.show(); 
	}

}
