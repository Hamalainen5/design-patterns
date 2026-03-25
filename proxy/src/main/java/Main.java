

import java.time.LocalDate;

/**
 * Demonstrates the use of the protected document system.
 *
 * Scenarios shown:
 * 1. Accessing an unprotected document
 * 2. Accessing a protected document with permission
 * 3. Accessing a protected document without permission
 * 4. Accessing public metadata such as id and creation date
 */
public class Main {

    public static void main(String[] args) {
        // Create the library
        Library library = new Library();

        // Get the singleton access control service
        AccessControlService accessControlService = AccessControlService.getInstance();

        // Create some users
        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        // Add one unprotected document
        library.addUnprotectedDocument(
                "doc1",
                LocalDate.of(2026, 3, 25),
                "This is a public document. Everyone can read it."
        );

        // Add two protected documents
        library.addProtectedDocument(
                "doc2",
                LocalDate.of(2026, 3, 20),
                "This is a secret project plan."
        );

        library.addProtectedDocument(
                "doc3",
                LocalDate.of(2026, 3, 21),
                "This is a confidential salary report."
        );

        // Grant permissions
        accessControlService.allowAccess("alice", "doc2");
        accessControlService.allowAccess("charlie", "doc3");

        // --------------------------------------------------
        // Scenario 1: Unprotected document
        // --------------------------------------------------
        System.out.println("=== SCENARIO 1: UNPROTECTED DOCUMENT ===");
        LibraryItem publicDoc = library.getDocument("doc1");

        System.out.println("Document ID: " + publicDoc.getId());
        System.out.println("Creation date: " + publicDoc.getCreationDate());

        // Anyone can access this content
        System.out.println("Alice reads: " + publicDoc.getContent(alice));
        System.out.println("Bob reads: " + publicDoc.getContent(bob));

        // --------------------------------------------------
        // Scenario 2: Protected document, allowed user
        // --------------------------------------------------
        System.out.println("\n=== SCENARIO 2: PROTECTED DOCUMENT (ALLOWED USER) ===");
        LibraryItem protectedDoc2 = library.getDocument("doc2");

        // Public metadata is always accessible
        System.out.println("Document ID: " + protectedDoc2.getId());
        System.out.println("Creation date: " + protectedDoc2.getCreationDate());

        try {
            // Alice has permission to access doc2
            System.out.println("Alice reads: " + protectedDoc2.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        // --------------------------------------------------
        // Scenario 3: Protected document, denied user
        // --------------------------------------------------
        System.out.println("\n=== SCENARIO 3: PROTECTED DOCUMENT (DENIED USER) ===");

        try {
            // Bob does NOT have permission to access doc2
            System.out.println("Bob reads: " + protectedDoc2.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        // --------------------------------------------------
        // Scenario 4: Another protected document
        // --------------------------------------------------
        System.out.println("\n=== SCENARIO 4: SECOND PROTECTED DOCUMENT ===");
        LibraryItem protectedDoc3 = library.getDocument("doc3");

        // Metadata is public
        System.out.println("Document ID: " + protectedDoc3.getId());
        System.out.println("Creation date: " + protectedDoc3.getCreationDate());

        try {
            // Charlie has access to doc3
            System.out.println("Charlie reads: " + protectedDoc3.getContent(charlie));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Alice does NOT have access to doc3
            System.out.println("Alice reads: " + protectedDoc3.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}