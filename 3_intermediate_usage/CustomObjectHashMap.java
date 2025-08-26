import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class demonstrates why it's crucial to override equals() and hashCode()
 * when using custom objects as keys in a HashMap.
 */

// --- Version 1: A class WITHOUT overriding equals() and hashCode() ---
// --- Version 1: equals() mariyu hashCode() override cheyani class ---
class Book {
    private String isbn;
    private String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // No equals() or hashCode() here. It uses the default from Object class.
    // Ikkada equals() or hashCode() levu. Object class lo unna default implementation vadutundi.
}

// --- Version 2: A class WITH a proper equals() and hashCode() implementation ---
// --- Version 2: Saraina equals() and hashCode() implementation unna class ---
class ProperBook {
    private String isbn;
    private String title;

    public ProperBook(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // We override equals() to define what makes two books "equal".
    // In this case, if their ISBNs are the same, the books are the same.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProperBook that = (ProperBook) o;
        return Objects.equals(isbn, that.isbn);
    }

    // If we override equals(), we MUST override hashCode().
    // The rule is: if two objects are equal, their hash codes MUST be the same.
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "ProperBook{" + "isbn='" + isbn + '\'' + '}';
    }
}


public class CustomObjectHashMap {
    public static void main(String[] args) {
        // --- Scenario 1: Using the BAD Book class ---
        System.out.println("--- Scenario 1: Without proper equals() and hashCode() ---");
        Map<Book, String> bookStock = new HashMap<>();
        Book book1 = new Book("1234", "Java Basics");

        bookStock.put(book1, "10 copies available");

        // Now, let's try to get the stock using a NEW object that is "logically" the same.
        // Ippudu, manam "logically" same ayina KOTHA object tho stock ni get cheddam.
        Book bookToFind = new Book("1234", "Java Basics");
        String stock = bookStock.get(bookToFind);

        System.out.println("Book to find: A new object with ISBN 1234.");
        System.out.println("Stock found: " + stock); // This will be NULL! 😲
        System.out.println("Why? Because HashMap uses hashCode() to find the bucket, and then equals() to find the book. Without overriding them, two different objects are never equal.");
        System.out.println("Enduku? Endukante HashMap bucket ni vetakadaniki hashCode() ni, book ni vetakadaniki equals() ni vadutundi. Vaatini override cheyakapote, rendu veru objects eppudu equal kaavu.");

        System.out.println("\n------------------------------------------------------\n");

        // --- Scenario 2: Using the GOOD ProperBook class ---
        System.out.println("--- Scenario 2: With proper equals() and hashCode() ---");
        Map<ProperBook, String> properBookStock = new HashMap<>();
        ProperBook properBook1 = new ProperBook("5678", "Advanced Java");

        properBookStock.put(properBook1, "5 copies available");

        // Now, let's try to get the stock using a new, but logically equal, object.
        ProperBook properBookToFind = new ProperBook("5678", "Advanced Java");
        String properStock = properBookStock.get(properBookToFind);

        System.out.println("Book to find: A new object with ISBN 5678.");
        System.out.println("Stock found: " + properStock); // This will work! ✅
        System.out.println("Success! Because we told Java how to check for equality (using ISBN), HashMap can find the correct book.");
        System.out.println("Success! Manam Java ki equality ni ela check cheyalo (ISBN tho) cheppam kabatti, HashMap correct book ni kanukkogaligindi.");
    }
}
