import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu; 
import javafx.scene.control.MenuBar; 
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem; //new
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuClicks extends Application{

	Stage window;
	BorderPane layout;

	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		window.setTitle("Menu Clicks"); 
		
		//File menu
		Menu fileMenu = new Menu("_File"); //putting an underscore in front of a file, the program will treat it as a short cut
		
		//Menu Items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a New File...")); //has the function of sysout when clicked
		fileMenu.getItems().add(newFile);

		fileMenu.getItems().add(new MenuItem("Open...")); 
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem()); //separates the menuItems into groups
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit..."));
		
		//EditMenu
		Menu editMenu = new Menu("_Edit"); 
		editMenu.getItems().add(new MenuItem("Cut")); 
		editMenu.getItems().add(new MenuItem("Copy"));
		
		MenuItem paste = new MenuItem("Paste");
		paste.setOnAction(e -> System.out.println("Pasted"));
		paste.setDisable(true); //this will disable the paste option
		editMenu.getItems().add(paste);
		
		//Main MenuBar
		MenuBar menuBar = new MenuBar(); 
		menuBar.getMenus().addAll(fileMenu, editMenu);
		
		layout = new BorderPane();
		layout.setTop(menuBar);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene); 
		window.show(); 
	}

}
