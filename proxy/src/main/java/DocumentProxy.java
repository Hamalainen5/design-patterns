import java.time.LocalDateTime;

// This class controls access to the
// Protected document
// The real document is stored inside this proxy, and access to the document's content is controlled based on the user's permissions
public class DocumentProxy implements LibraryItem {
    private final Document realDocument;
    private final AccessControlService accessControlService;

    /**
     * Creates a proxy for a protected document.
     *
     * The proxy uses the singleton AccessControlService to check
     * whether a user is allowed to access the content.
     */
    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    /**
     * Returns the id of the real document.
     * This is public information, so no access check is needed.
     */
    @Override
    public String getId() {
        return realDocument.getId();
    }

    /**
     * Returns the creation date of the real document.
     * This is public information, so no access check is needed.
     */
    @Override
    public LocalDateTime getCreationDate() {
        return realDocument.getCreationDate();
    }

    /**
     * Returns the content only if the user is allowed to access it.
     *
     * Steps:
     * 1. Check that the user object is not null.
     * 2. Ask AccessControlService whether the user may access this document.
     * 3. If allowed, forward the request to the real document.
     * 4. Otherwise throw AccessDeniedException.
     */
    @Override
    public String getContent(User user) {
        if (user == null) {
            throw new AccessDeniedException("Access denied: user is null.");
        }

        boolean allowed = accessControlService.isAllowed(realDocument.getId(), user.getUsername());

        if (allowed) {
            // Forward the request to the real document
            return realDocument.getContent(user);
        }

        throw new AccessDeniedException(
                "Access denied: user '" + user.getUsername()
                        + "' is not allowed to access document '" + realDocument.getId() + "'."
        );
    }
}