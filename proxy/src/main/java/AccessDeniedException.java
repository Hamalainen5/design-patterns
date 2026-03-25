// Custom exception thrown when a user treis to access a document they are not allowed to access

public class AccessDeniedException extends RuntimeException {

    // creates a new AccessDeniedException with the given message
    public AccessDeniedException(String message) {
        super(message);
    }
}
