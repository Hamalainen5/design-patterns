public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone");
        Book book2 = new Book("J.R.R. Tolkien", "The Lord of the Rings");

        Recommendation rec1 = new Recommendation("Fantasy Lovers");
        rec1.addBook(book1);
        rec1.addBook(book2);

        // Clone the recommendation
        Recommendation rec2 = rec1.clone();

        // Modify the cloned recommendation
        rec2.setTargetAudience("Young Readers");
        rec2.addBook(new Book("C.S. Lewis", "The Chronicles of Narnia"));
        System.out.println("Recommendation 1: " + rec1);
        System.out.println("Recommendation 2: " + rec2);
    }
}
