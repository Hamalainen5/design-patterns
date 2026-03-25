// Representation of a user

// User only needs to have a username and can be created directly with a constructor
public class User {
    private final String username;

    // Creates a new user with the given username

    public User(String username) {
        this.username = username;
    }

    // Returns the username

    public String getUsername() {
        return username;
    }
}
