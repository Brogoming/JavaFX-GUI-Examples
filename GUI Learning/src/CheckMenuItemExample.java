import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem; //new
import javafx.scene.control.Menu; 
import javafx.scene.control.MenuBar; 
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CheckMenuItemExample extends Application{

	Stage window;
	BorderPane layout;

	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		window.setTitle("CheckMenuItem");
		
		//File Menu
		Menu fileMenu = new Menu("_File"); 
		
		//Menu Items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a New File...")); 
		fileMenu.getItems().add(newFile);
		fileMenu.getItems().add(new MenuItem("Open...")); 
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem()); 
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit..."));
		
		//Edit Menu
		Menu editMenu = new Menu("_Edit"); 
		editMenu.getItems().add(new MenuItem("Cut")); 
		editMenu.getItems().add(new MenuItem("Copy"));
		MenuItem paste = new MenuItem("Paste");
		paste.setOnAction(e -> System.out.println("Pasted"));
		paste.setDisable(true); 
		editMenu.getItems().add(paste);
		
		//CheckMenuItem - allows you to toggle a check box on and off
		//Help Menu
		Menu helpMenu = new Menu("_Help"); 
		CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
		showLines.setOnAction(e -> {
			if (showLines.isSelected()) { //if showLines is selected
				System.out.println("Program will display line numbers");
			} else { //if showLines is not selected
				System.out.println("Hiding line numbers");
			}
		});
		CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
		autoSave.setSelected(true); //has it so the option is selected by default
		helpMenu.getItems().addAll(showLines, autoSave);
		
		//Main MenuBar
		MenuBar menuBar = new MenuBar(); 
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
		
		layout = new BorderPane();
		layout.setTop(menuBar);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene); 
		window.show(); 
	}

}
