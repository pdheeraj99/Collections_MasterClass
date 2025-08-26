import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Define the Contact record here as well to make the file self-contained.
record ContactV3(String name, String phoneNumber) {
}

/**
 * Version 3 of the Contact Book.
 * Uses a ConcurrentHashMap to make the contact book thread-safe.
 */
public class ContactBook_V3_ThreadSafe {

    // Using ConcurrentHashMap for thread-safe operations.
    private final Map<String, ContactV3> contacts = new ConcurrentHashMap<>();

    public void addContact(String name, String phoneNumber) {
        ContactV3 newContact = new ContactV3(name, phoneNumber);
        contacts.put(name.toLowerCase(), newContact);
    }

    public ContactV3 findContactByName(String name) {
        return contacts.get(name.toLowerCase());
    }

    public void displayAllContacts() {
        System.out.println("\n--- All Contacts (" + contacts.size() + " total) ---");
        // The iterator of ConcurrentHashMap is fail-safe and will not throw
        // ConcurrentModificationException.
        for (ContactV3 contact : contacts.values()) {
            System.out.println("Name: " + contact.name() + ", Phone: " + contact.phoneNumber());
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) throws InterruptedException {
        ContactBook_V3_ThreadSafe book = new ContactBook_V3_ThreadSafe();
        System.out.println("--- Contact Book V3 (Using ConcurrentHashMap) ---");

        // Simulate multiple threads adding contacts at the same time.
        // Okesari chala threads contacts ni add chestunnattu simulate cheddam.
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            final int index = i;
            executor.submit(() -> {
                String name = "User" + index;
                String phone = "555-01" + String.format("%02d", index);
                book.addContact(name, phone);
            });
        }

        // Wait for all threads to finish.
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Display all contacts. We should have 100 contacts.
        book.displayAllContacts();

        // Test finding a contact
        System.out.println("\nSearching for User50...");
        ContactV3 found = book.findContactByName("user50");
        System.out.println("Found: " + found);
    }
}
