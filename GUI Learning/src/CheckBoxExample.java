import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox; //new
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxExample extends Application{
	
	Stage window;
	Scene scene;
	Button button;

	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Subs"); 
		
		//CheckBox
		CheckBox box1 = new CheckBox("Bacon"); //appears right of the check box
		CheckBox box2 = new CheckBox("Tuna");
		box2.setSelected(true); //automatically selected by default

		//Button
		button = new Button("Order Me!");
		button.setOnAction(e -> handleOptions(box1, box2));
				
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(box1, box2, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show(); 
	}
	
	//handle check box options
	private void handleOptions(CheckBox box1, CheckBox box2) {
		String message = "Users Order: \n";
		
		if(box1.isSelected()) { //isSelected returns true if selected
			message += "Bacon\n";
		}
		if(box2.isSelected()) { //isSelected returns true if selected
			message += "Tune\n";
		}
		System.out.println(message);
	}
}
