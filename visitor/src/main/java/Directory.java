import java.util.ArrayList;
import java.util.List;

// Represents a directory that can contain files and other directories

public class Directory extends FileSystemElement {

    private String name;
    private List<FileSystemElement> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }

    // Add file or subdirectory

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    // Accept visitor and allow it to process this directory

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
