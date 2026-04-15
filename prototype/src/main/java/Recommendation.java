import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype{

    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public Recommendation clone() {
        // DEEP COPY
        Recommendation cloned = new Recommendation(this.targetAudience);
        for (Book book : books) {
            cloned.addBook(book.clone());
        }
        return cloned;
    }

    @Override
    public String toString() {
        return "Recommendation{" + "targetAudience=" + targetAudience + ", books=" + books + '}';
    }
}
