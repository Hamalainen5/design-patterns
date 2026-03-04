// Handler for Compensation claims
class CompensationHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("Processing compensation claim from " + message.getSenderEmail() +
                    ": " + message.getContent());
            // Here you can add logic to approve/reject
        } else {
            super.handle(message); // Pass to next handler
        }
    }
}
