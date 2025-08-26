import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class demonstrates the Iterator design pattern.
 * We'll create a custom collection and an iterator for it.
 */

// Our custom object
class PatternBook {
    private final String title;

    public PatternBook(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "'}";
    }
}

// Our custom collection that holds books
class BookShelf implements Iterable<PatternBook> {
    private final List<PatternBook> books;

    public BookShelf() {
        this.books = new ArrayList<>();
    }

    public void addBook(PatternBook book) {
        this.books.add(book);
    }

    // This is the key method for the Iterable interface.
    // It returns a new iterator object.
    @Override
    public Iterator<PatternBook> iterator() {
        return new BookShelfIterator(this.books);
    }
}

// Our custom iterator for the BookShelf
class BookShelfIterator implements Iterator<PatternBook> {
    private final List<PatternBook> books;
    private int index = 0;

    public BookShelfIterator(List<PatternBook> books) {
        this.books = books;
    }

    // Checks if there is a next element
    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    // Returns the next element and moves the pointer
    @Override
    public PatternBook next() {
        if (!hasNext()) {
            // In a real implementation, you'd throw a NoSuchElementException
            return null;
        }
        PatternBook book = books.get(index);
        index++;
        return book;
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        shelf.addBook(new PatternBook("The Lord of the Rings"));
        shelf.addBook(new PatternBook("The Hobbit"));
        shelf.addBook(new PatternBook("The Silmarillion"));

        System.out.println("--- Using the custom iterator directly ---");
        Iterator<PatternBook> iterator = shelf.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n--- Using the for-each loop (which uses our iterator internally!) ---");
        // Ee for-each loop pani cheyalante, mana BookShelf class `Iterable` ni implement cheyali.
        // Adi mana custom `iterator()` method ni call chestundi!
        for (PatternBook book : shelf) {
            System.out.println(book);
        }
    }
}
