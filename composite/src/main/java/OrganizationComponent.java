// Abstract base class for all organization elements
// This is the Composite pattern in action
// Both Department and Employee will extend this class

public abstract class OrganizationComponent {

    // Common attribute: both departments and employees have a name
    protected String name;

    // Constructor
    public OrganizationComponent(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Add a child component to the composite
    // Default implementation throws an exception
    // This is overridden by Department but not by Employee
    public void add(OrganizationComponent component){
        throw new UnsupportedOperationException();
    }

    // Remove a child component
    // Only Department can remove components
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException();

    }

    // Returns the total salary of this component
    // For Employee, it returns their salary
    // For Department, it sums the salaries of all its children
    public abstract double getTotalSalary();

    // Prints this component and its children in XML format
    public abstract void printXML(String indent);
}
