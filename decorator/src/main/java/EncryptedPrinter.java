public class EncryptedPrinter extends PrinterDecorator {

    private static final int SHIFT = 3;
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }
    @Override
    public void print(String message) {
        String EcryptedMessage = encrypt(message);
        printer.print(EcryptedMessage);
    }

    private String encrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            result.append((char) (c + SHIFT));
        }
        return result.toString();
    }
}
