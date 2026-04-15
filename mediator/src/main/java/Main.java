import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatMediator();

        List<String> users = List.of("Alice", "Bob", "Charlie");

        ChatClientController alice = new ChatClientController("Alice", mediator, users);
        ChatClientController bob = new ChatClientController("Bob", mediator, users);
        ChatClientController charlie = new ChatClientController("Charlie", mediator, users);

        mediator.registerClient(alice);
        mediator.registerClient(bob);
        mediator.registerClient(charlie);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
