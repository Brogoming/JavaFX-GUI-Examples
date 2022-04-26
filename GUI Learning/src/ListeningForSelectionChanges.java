import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox; //new
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListeningForSelectionChanges extends Application{
	
	Stage window;
	Scene scene;
	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Drop Down List"); 
		
		//Choice Box
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		
		//getItems returns ObservableList object which you can add items to
		choiceBox.getItems().add("Apples"); //adds one item to the list
		choiceBox.getItems().addAll("Oranges", "Grapes", "Bananas"); //adds a bunch of items to the list
		choiceBox.setValue("Apples"); //Set the default value (set it to one that already exists)
		
		//Listen for Selection Changes
		choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue)); //the item the user selected from the list. v is the property of the item, oldValue is the item previously selected, newValue is the new item selected
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show(); 
	}
}
