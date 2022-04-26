import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu; //new
import javafx.scene.control.MenuBar; //new
import javafx.scene.control.MenuItem; //new
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MakingMenus extends Application{

	Stage window;
	BorderPane layout;

	public static void main(String[] args) {
		launch(args); //calls the start method
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; 
		window.setTitle("Basic_Menu"); //sets title of the main window
		
		//File menu
		Menu fileMenu = new Menu("File"); //takes one string parameter as the menu name
		
		//Menu Items - adds items to your menu
		fileMenu.getItems().add(new MenuItem("New Project...")); //adds in a new menu item named New Project
		fileMenu.getItems().add(new MenuItem("Package...")); 
		fileMenu.getItems().add(new MenuItem("Class..."));
		fileMenu.getItems().add(new MenuItem("Interface..."));
		//if a menuItem has ... when you click it a new window/dialogue will open
		//if a menuItem has > when you click it there's a new sub-menu 
		//if a menuItem has nothing there is only one option
		
		//Main MenuBar - this adds the file menu, you can add more menus to it
		MenuBar menuBar = new MenuBar(); //no text needed, just a bar to organize the menu
		menuBar.getMenus().addAll(fileMenu);
		
		layout = new BorderPane();
		layout.setTop(menuBar);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene); //use this scene for the window of the program
		window.show(); //displays it to the user
	}

}
