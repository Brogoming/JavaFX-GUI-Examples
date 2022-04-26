import javafx.application.Application;
import javafx.collections.FXCollections; //new
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn; //new
import javafx.scene.control.TableView; //new
import javafx.scene.control.cell.PropertyValueFactory; //new
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IntroToTableView extends Application{
	
	Stage window;
	TableView<Product> table;

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("TableView");
		
		//Name column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200); //minimum width of 200px
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //last thing to do, this need to be the exact name of teh object
		
		//Price column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100); //minimum width of 100px
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price")); //last thing to do
				
		//Quantity column
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(100); //minimum width of 100px
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity")); //last thing to do
			
		table = new TableView<>();
		table.setItems(getProduct()); //loads in all of our data
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table);
		
		Scene scene = new Scene(vBox); //don't need WxH for this since the table already sets them
		window.setScene(scene);
		window.show();
	}
	
	//get all of the products. when this is called it will return all of the products in the observable list
	private ObservableList<Product> getProduct(){
		ObservableList<Product> products = FXCollections.observableArrayList(); //a type of list that can store JavaFx objects
		products.add(new Product("Laptop", 859.90, 20));
		products.add(new Product("Tablet", 200.99, 11));
		products.add(new Product("Samrt Phone", 500.76, 45));
		products.add(new Product("Desktop", 1000.89, 5));
		products.add(new Product("XBox", 550.45, 23));
		return products;
	}

}
