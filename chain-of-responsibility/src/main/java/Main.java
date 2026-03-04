public class Main {

    public static void main(String[] args) {
        // Create handlers
        FeedbackHandler compensationHandler = new CompensationHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler developmentHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        // Chain the handlers
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(generalHandler);

        // Test the chain
        Message[] messages = {
                new Message(MessageType.COMPENSATION, "I want a refund for my order.", "alice@example.com"),
                new Message(MessageType.CONTACT_REQUEST, "Please call me regarding my account.", "bob@example.com"),
                new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add dark mode to the app.", "carol@example.com"),
                new Message(MessageType.GENERAL_FEEDBACK, "Great service, keep it up!", "dave@example.com")
        };

        // Process each message
        for (Message message : messages) {
            compensationHandler.handle(message);
            System.out.println("--------------------------------------------------");
        }

    }
}
