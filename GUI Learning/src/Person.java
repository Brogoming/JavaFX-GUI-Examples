import javafx.beans.property.SimpleStringProperty; //new, allows us to use new string properties to read and write to
import javafx.beans.property.StringProperty; //new

public class Person {
	
	private StringProperty firstName = new SimpleStringProperty(this, "firstName", ""); //this variable, the variable name, default value
	
	//returns the StringProperty object
	public StringProperty firstNameProperty() {
		return firstName;
	}

	//return the firstName of value (ie. "Dakota")
	public String getFirstName() {
		return firstName.get();
	}

	//set the firstName value
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	
	
}
