import java.util.HashMap;
import java.util.Map;

public class ChatMediator implements Mediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void sendMessage(String from, String to, String message) {
        ChatClient recipient = clients.get(to);
        if (recipient != null) {
            recipient.receiveMessage(from, message);
        } else {
            System.out.println("User " + to + " not found.");
        }
    }

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }
}
