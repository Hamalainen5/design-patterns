
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ChatClientController implements ChatClient {

    private String username;
    private Mediator mediator;

    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> recipientBox;
    private Button sendButton;

    public ChatClientController(String username, Mediator mediator, List<String> allUsers) {
        this.username = username;
        this.mediator = mediator;

        chatArea = new TextArea();
        chatArea.setEditable(false);

        messageField = new TextField();
        messageField.setPromptText("Type message...");

        recipientBox = new ComboBox<>();
        for (String user : allUsers) {
            if (!user.equals(username)) {
                recipientBox.getItems().add(user);
            }
        }
        recipientBox.setPromptText("Select recipient");

        sendButton = new Button("Send");

        sendButton.setOnAction(e -> sendMessage());

        VBox root = new VBox(10, chatArea, recipientBox, messageField, sendButton);
        root.setPadding(new Insets(10));

        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(new Scene(root, 350, 300));
        stage.show();
    }

    private void sendMessage() {
        String recipient = recipientBox.getValue();
        String message = messageField.getText();

        if (recipient == null || message.isBlank()) {
            return;
        }

        mediator.sendMessage(username, recipient, message);

        chatArea.appendText("To " + recipient + ": " + message + "\n");
        messageField.clear();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void receiveMessage(String from, String message) {
        chatArea.appendText("From " + from + ": " + message + "\n");
    }
}