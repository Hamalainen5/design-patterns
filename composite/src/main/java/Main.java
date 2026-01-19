public class Main {

    public static void main(String[] args) {

        // Root of the organization
        Department organization = new Department("My Organization");

        // Create departments
        Department it = new Department("IT");
        Department hr = new Department("HR");

        // Create employees
        Employee alice = new Employee("Alice", 4000);
        Employee bob = new Employee("Bob", 3500);
        Employee charlie = new Employee("Charlie", 3000);

        // Add employees to departments
        it.add(alice);
        it.add(bob);
        hr.add(charlie);

        // Add departments to the organization
        organization.add(it);
        organization.add(hr);

        // Single method call to get total salary
        System.out.println("Total salary: " + organization.getTotalSalary());

        // Single method call to print in XML format
        System.out.println("\nOrganization structure (XML):");
        organization.printXML("");
    }
}
