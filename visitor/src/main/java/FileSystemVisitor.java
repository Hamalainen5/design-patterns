// Visitor interface
// Declares a visit method for each type of elemet

public interface FileSystemVisitor {

    void visit(FileItem file);

    void visit(Directory directory);
}
