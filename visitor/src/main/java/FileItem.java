// Represent a file in the file system.

public class FileItem extends FileSystemElement {

    private String name;
    private double size; // in MB

    public FileItem(String name, double size) {
        this.name = name;
        this.size = size;
    }

    // Getters

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    // This method allows a visitor to visit
    // It calls the correct visit method in the visitor

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
