
public interface Mediator {
    void sendMessage(String from, String to, String message);
    void registerClient(ChatClient client);
}