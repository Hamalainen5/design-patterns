// Base interface for all elements in the file system
// Both files and directories must implement this

public class FileSystemElement {

    // Accept method for visitor pattern
    // A visitor is passed in and performs an operation on this element

    void accept(FileSystemVisitor visitor) {

    }
}
