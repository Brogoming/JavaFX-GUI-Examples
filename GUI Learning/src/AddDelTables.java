import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddDelTables extends Application{
	
	Stage window;
	TableView<Product> table;
	TextField nameInput, priceInput, quantityInput;

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
			
		//Name Input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		
		//Price Input
		priceInput = new TextField();
		priceInput.setPromptText("Price");
		priceInput.setMinWidth(100);
		
		//Quantity Input
		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");
		quantityInput.setMinWidth(100);
		
		//Button
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked()); //when button is clicked it adds the new row
		Button delButton = new Button("Delete");
		delButton.setOnAction(e -> delButtonClicked()); //when button is clicked it deletes the selected row
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10)); //gives padding around the layout (this hBox)
		hBox.setSpacing(10); //spaces out the objects 
		hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, delButton);
		
		table = new TableView<>();
		table.setItems(getProduct()); //loads in all of our data
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);
		
		Scene scene = new Scene(vBox); //don't need WxH for this since the table already sets them
		window.setScene(scene);
		window.show();
	}
	
	//Add button
	private void addButtonClicked() {
		Product product = new Product();
		product.setName(nameInput.getText()); //getText gets the value of the property text
		product.setPrice(Double.parseDouble(priceInput.getText())); //sets the priceInput text to double
		product.setQuantity(Integer.parseInt(quantityInput.getText())); //sets the quantityInput text to int
		table.getItems().add(product);
		nameInput.clear(); //clears the items in the table
		priceInput.clear(); //clears the items in the table
		quantityInput.clear(); //clears the items in the table
	}
	
	private void delButtonClicked() {
		ObservableList<Product> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove); //for all products selected remove them from allProducts
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
