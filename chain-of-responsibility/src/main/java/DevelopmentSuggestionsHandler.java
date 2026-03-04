// Handler for Development suggestions
class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Logging development suggestion from " + message.getSenderEmail() +
                    ": " + message.getContent());
        } else {
            super.handle(message);
        }
    }
}