// Visitor that calculates the size of all files

public class SizeCalculatorVisitor implements FileSystemVisitor {

    private double totalSize = 0;

    // When visiting a file, add its size


    @Override
    public void visit(FileItem file) {
        totalSize += file.getSize();
    }

    // When visiting a directory, traverse all its contents

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public double getTotalSize() {
        return totalSize;
    }
}
