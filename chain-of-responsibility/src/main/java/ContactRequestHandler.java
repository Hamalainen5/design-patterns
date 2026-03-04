// Handler for Contact requests
class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Forwarding contact request to support team from " + message.getSenderEmail() +
                    ": " + message.getContent());
        } else {
            super.handle(message);
        }
    }
}