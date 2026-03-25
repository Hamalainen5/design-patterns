

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Singleton service responsible for access control.
 *
 * It stores which users are allowed to access which documents.
 * All DocumentProxy objects use the same shared service instance.
 */
public class AccessControlService {

    /**
     * The single instance of the service.
     */
    private static final AccessControlService INSTANCE = new AccessControlService();

    /**
     * Stores permissions in the form:
     * username -> set of document ids the user may access
     */
    private final Map<String, Set<String>> permissions;

    /**
     * Private constructor so no other instances can be created.
     */
    private AccessControlService() {
        permissions = new HashMap<>();
    }

    /**
     * Returns the single shared instance of the service.
     */
    public static AccessControlService getInstance() {
        return INSTANCE;
    }

    /**
     * Grants a user access to a specific document.
     *
     * Example:
     * allowAccess("alice", "doc2");
     */
    public void allowAccess(String username, String documentId) {
        permissions.computeIfAbsent(username, key -> new HashSet<>()).add(documentId);
    }

    /**
     * Checks whether the given user is allowed to access the given document.
     *
     * Returns:
     * - true if allowed
     * - false otherwise
     */
    public boolean isAllowed(String documentId, String username) {
        Set<String> allowedDocuments = permissions.get(username);
        return allowedDocuments != null && allowedDocuments.contains(documentId);
    }
}