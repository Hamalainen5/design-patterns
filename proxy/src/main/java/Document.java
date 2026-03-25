import java.time.LocalDateTime;

// Real document class
// this class stores actual document data: id, creation date, content
// Unprotected documents can be created directly in the Library
// Protected documents should be wrapped inside a DocumentProxy


public class Document implements LibraryItem {
    private final String id;
    private final LocalDateTime creationDate;
    private final String content;

    //Creates a document with id, creation date, and content
    public Document(String id, LocalDateTime creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }
    //Returns the id,
    @Override
    public String getId() {
        return id;
    }
    //Returns the creation date,
    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    //Returns the content
    @Override
    public String getContent(User user) {
        return content;
    }
}
