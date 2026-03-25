import java.time.LocalDateTime;

/**
 * Common interface for both real documents and proxies
 * This is important because the Library must be able to store
 * bot unprotected documents and proxies in the same collection
 */

public interface LibraryItem {

    // Returns an unique identifier for the document.
    String getId();

    // Returns the date the document was created.
    LocalDateTime getCreationDate();

    // Returns the content of the document.
    // For unprotected documents, this will return the content directly.
    // For protected documents, this will check the user's permissions and return the content if allowed.
    String getContent(User user);
}
