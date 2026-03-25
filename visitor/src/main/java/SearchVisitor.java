import java.util.ArrayList;
import java.util.List;

// Visitor for searching files that match a certain criteria

public class SearchVisitor implements FileSystemVisitor {

    private String extension;
    private String nameContains;
    private List<FileItem> matchingFiles = new ArrayList<>();

    // you can search by extension or substring

    public SearchVisitor(String extension, String nameContains) {
        this.extension = extension;
        this.nameContains = nameContains;
    }
    // Check if a file matches criteria

    @Override
    public void visit(FileItem file) {
        boolean matches = true;

        if (extension != null && !file.getName().endsWith(extension)) {
            matches = false;
        }

        if (nameContains != null && !file.getName().toLowerCase().contains(nameContains.toLowerCase())) {
            matches = false;
        }

        if (matches) {
            matchingFiles.add(file);
        }
    }

    // Traverse directory contents

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public List<FileItem> getMatchingFiles() {
        return matchingFiles;
    }
}
