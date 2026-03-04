// Abstract handler in the chain
public class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    // Set the next handler
    public void setNextHandler(FeedbackHandler handler) {
        this.nextHandler = handler;
    }

    // Handle method: either process the feedback or pass it
    public void handle(Message message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No further handlers to process the message" + message);
        }
    }
}
