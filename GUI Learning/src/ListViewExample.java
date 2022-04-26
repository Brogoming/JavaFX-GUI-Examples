import javafx.application.Application;
import javafx.collections.ObservableList; //new
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView; //new
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExample extends Application{
	
	Stage window;
	Scene scene;
	Button button;
	ListView<String> listView;
	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Listview Demo"); 
		button = new Button("Submit");
		
		listView = new ListView<>();
		listView.getItems().addAll("Iron Man", "Captain America", "Thor", "Hulk");
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //this allows you to select multiple items. control for each individual multiple, shift to get all between to items
		
		button.setOnAction(e -> buttonClicked());
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(listView, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show(); 
	}
	
	private void buttonClicked() {
		String message = "";
		ObservableList<String> movies;
		movies = listView.getSelectionModel().getSelectedItems();
		
		for(String m: movies) { //one by one will store the movies in message
			message += m + "\n";
		}
		
		System.out.println(message);
	}
}