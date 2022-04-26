import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem; //new
import javafx.scene.control.TreeView; //new
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewExample extends Application{

	Stage window;
	TreeView<String> tree; 

	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("TreeView_Window"); 
		
		TreeItem<String> root, branch1, branch2; //setting the root and its branches
		
		//Root
		root = new TreeItem<>();
		root.setExpanded(true); //when ever the program starts everything is expanded or open
		
		//Branch1
		branch1 = makeBranch("Dakota", root); //sets its name and the parent of it
		makeBranch("Education", branch1); //sets its name and the parent of it
		makeBranch("Athletics", branch1); //sets its name and the parent of it
		makeBranch("Clubs", branch1); //sets its name and the parent of it
		
		//Branch2
		branch2 = makeBranch("Walker", root); //sets its name and the parent of it
		makeBranch("Education", branch2); //sets its name and the parent of it
		makeBranch("Work", branch2); //sets its name and the parent of it
		
		//create tree
		tree = new TreeView<>(root); //the tree needs a main root
		tree.setShowRoot(false); //this makes it so we don't have to expand root to see the others
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> { //prints out everytime a new item is selected
			if(newValue != null) {
				System.out.println(newValue.getValue());
			}
		});
		
		StackPane layout = new StackPane(); 
		layout.getChildren().add(tree);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene); 
		window.show(); 
	}
	//Create branches
	private TreeItem<String> makeBranch(String title, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true); //expands the item passed through
		parent.getChildren().add(item); //makes sure the item is add to the parent
		return item;
	}

}
