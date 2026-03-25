import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores all available documents in the document library.
 *
 * The library must be able to store:
 * - real unprotected documents
 * - protected documents through proxy objects
 *
 * Therefore, the map stores LibraryItem references.
 */
public class Library {
    private final Map<String, LibraryItem> documents;

    /**
     * Creates an empty library.
     */
    public Library() {
        documents = new HashMap<>();
    }

    /**
     * Adds an unprotected document directly to the library.
     *
     * Anyone can read its content.
     */
    public void addUnprotectedDocument(String id, LocalDate creationDate, String content) {
        Document document = new Document(id, creationDate.atStartOfDay(), content);
        documents.put(id, document);
    }

    /**
     * Adds a protected document to the library.
     *
     * Important:
     * - First create the real document
     * - Then wrap it inside a DocumentProxy
     * - Store only the proxy in the library
     *
     * This ensures that the protected real document is not directly accessible.
     */
    public void addProtectedDocument(String id, LocalDate creationDate, String content) {
        Document realDocument = new Document(id, creationDate.atStartOfDay(), content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        documents.put(id, proxy);
    }

    /**
     * Returns the document (or proxy) by id.
     *
     * The client does not need to know whether the returned object
     * is a real document or a proxy because both implement LibraryItem.
     */
    public LibraryItem getDocument(String id) {
        return documents.get(id);
    }
}