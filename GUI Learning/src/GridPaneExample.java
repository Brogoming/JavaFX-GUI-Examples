import javafx.application.Application;
import javafx.geometry.Insets; //new
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane; //new
import javafx.stage.Stage;

public class GridPaneExample extends Application{
	
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("GridPane"); 
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10)); //sets the padding around the edges
		grid.setVgap(8); //vertical spacing of individual cells
		grid.setHgap(10); //Horizontal spacing of individual cells
		
		//name label
		Label nameLabel = new Label("Username: ");
		GridPane.setConstraints(nameLabel, 0, 0); //sets the label variable at column 0 and row 0
		//name Input
		TextField nameInput = new TextField("Userlog"); //the textfield will have text already set
		GridPane.setConstraints(nameInput, 1, 0); //sets the textfield variable at column 1 and row 0
		//password label
		Label passwordLabel = new Label("Password: ");
		GridPane.setConstraints(passwordLabel, 0, 1); //sets the label variable at column 0 and row 1
		//name Input
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("Password"); //sets the password input prompt in light gray
		GridPane.setConstraints(passwordInput, 1, 1); //sets the textfield variable at column 1 and row 1
		
		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2); //sets the button variable at column 1 and row 2
		
		grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, loginButton);
		Scene scene = new Scene(grid, 300, 250);
		window.setScene(scene);
		window.show(); 
	}

}
