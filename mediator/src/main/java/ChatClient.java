public interface ChatClient {
    String getUsername();
    void receiveMessage(String from, String message);
}
