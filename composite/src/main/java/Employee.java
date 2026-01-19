// Employee is a Leaf in the Composite pattern
// It cannot have children

public class Employee extends OrganizationComponent {

    // Salary specific to employees
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    // Print employee as a single XML element
    // Employees have no children, so this is a self-closing tag

    @Override
    public void printXML(String indent) {
        System.out.println(
                indent + "<employee name=\"" + name +
                        "\" salary=\"" + salary + "\" />"
        );
    }
}
