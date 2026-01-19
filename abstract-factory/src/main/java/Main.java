// Client code
// Depends only on abstract types

import factory.AFactory;
import factory.UIFactory;
import elements.Button;
import elements.Checkbox;
import elements.TextField;

public class Main {

    public static void main(String[] args) {

        // Select the UI style
        UIFactory factory = new AFactory();

        // Create UI elements via the factory
        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("Username");
        Checkbox checkbox = factory.createCheckbox("Accept terms and conditions");

        // Display elements
        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\n--- After updating text ---\n");

        // Change content dynamically
        button.setText("Submit");
        textField.setText("Admin");
        checkbox.setText("I agree");

        // Display elements again
        button.display();
        textField.display();
        checkbox.display();

    }
}
