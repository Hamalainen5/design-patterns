// Demonstrates how the Visitor pattern works in practice.

public class Main {

    public static void main(String[] args) {

        // Create files
        FileItem f1 = new FileItem("report.pdf", 2.5);
        FileItem f2 = new FileItem("photo.jpg", 4.0);
        FileItem f3 = new FileItem("notes.txt", 1.2);
        FileItem f4 = new FileItem("todo.txt", 0.5);

        // Create directories
        Directory root = new Directory("root");
        Directory docs = new Directory("documents");
        Directory images = new Directory("images");

        // Build structure
        docs.addElement(f1);
        docs.addElement(f3);
        docs.addElement(f4);

        images.addElement(f2);

        root.addElement(docs);
        root.addElement(images);

        // ---------------------------
        // Visitor 1: Size calculation
        // ---------------------------
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        // ---------------------------
        // Visitor 2: Search .txt files
        // ---------------------------
        SearchVisitor searchVisitor = new SearchVisitor(".txt", null);
        root.accept(searchVisitor);

        System.out.println("\nTXT files found:");
        for (FileItem file : searchVisitor.getMatchingFiles()) {
            System.out.println(file.getName());
        }
    }
}