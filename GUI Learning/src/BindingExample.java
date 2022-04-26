import javafx.application.Application;
import javafx.beans.property.IntegerProperty; //new
import javafx.beans.property.SimpleIntegerProperty; //new
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BindingExample extends Application{
	
	Button button;
	Stage window;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		window.setTitle("Binding"); //sets title of the main window
		
		IntegerProperty x = new SimpleIntegerProperty(3); //sets the x initial value to 3
		IntegerProperty y = new SimpleIntegerProperty(); //y has a null value
		
		y.bind(x.multiply(10)); //the value of y is bound to the value of x * 10
		System.out.println("x: " + x.getValue());
		System.out.println("y: " + y.getValue() + "\n");
		
		x.setValue(9); //sets the value to 9
		System.out.println("x: " + x.getValue());
		System.out.println("y: " + y.getValue() + "\n");
		
		button = new Button("Click Me");
		
		StackPane layout = new StackPane(); //this will position the button in the middle
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene); //use this scene for the window of the program
		window.show(); //displays it to the user
	}

}
