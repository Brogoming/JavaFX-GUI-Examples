import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox; //new
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxDropDownMenu extends Application{
	
	Stage window;
	Scene scene;
	Button button;
	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Drop Down List"); 
		button = new Button("Click Me");
		
		//Choice Box
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		
		//getItems returns ObservableList object which you can add items to
		choiceBox.getItems().add("Apples"); //adds one item to the list
		choiceBox.getItems().addAll("Oranges", "Grapes", "Bananas"); //adds a bunch of items to the list
		choiceBox.setValue("Apples"); //Set the default value (set it to one that already exists)
		
		button.setOnAction(e -> getChoice(choiceBox));
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show(); 
	}
	//to get the value of the item selected
	private void getChoice(ChoiceBox<String> choiceBox) {
		String food = choiceBox.getValue(); //gets the value of the choice selected
		System.out.println(food);
	}
}
