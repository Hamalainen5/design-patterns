import java.util.ArrayList;
import java.util.List;

// Department is a Composite in the Composite pattern
// It can contain other departments and employees

public class Department extends OrganizationComponent {

    // List of child components
    private List<OrganizationComponent> children = new ArrayList<>();

    // Constructor
    public Department(String name) {
        super(name);
    }

    // Add a child component
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    // Remove a child component
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    // Calculate the total salary of this department and its children
    @Override
    public double getTotalSalary() {
        double total = 0;

        for (OrganizationComponent child : children) {
            total += child.getTotalSalary();
        }

        return total;
    }
    // Print department and its children in XML format
    @Override
    public void printXML(String indent) {
        // Opening tag for a department
        System.out.println(
                indent + "<department name=\"" + name + "\">"
        );

        // Print all children recursively
        for (OrganizationComponent child : children) {
            child.printXML(indent + "  ");
        }

        // Closing tag for department
        System.out.println(indent + "</department>");
    }
}
