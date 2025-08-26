import java.util.HashMap;
import java.util.Map;

// To make this file self-contained, we define a Contact record here.
// In a real app, this would be in its own file.
record ContactV2(String name, String phoneNumber) {
}

/**
 * Version 2 of the Contact Book.
 * Uses a HashMap to store contacts for fast, O(1) lookups by name.
 */
public class ContactBook_V2_HashMap {

    // Key is the contact's name (String), Value is the Contact object.
    private final Map<String, ContactV2> contacts = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        ContactV2 newContact = new ContactV2(name, phoneNumber);
        contacts.put(name.toLowerCase(), newContact); // Use lowercase name as key for case-insensitive search
        System.out.println("Added: " + newContact);
    }

    // This search is now super fast (O(1) on average)!
    // Ee search ippudu chala fast (average ga O(1))!
    public ContactV2 findContactByName(String name) {
        return contacts.get(name.toLowerCase());
    }

    public void displayAllContacts() {
        System.out.println("\n--- All Contacts ---");
        if (contacts.isEmpty()) {
            System.out.println("Contact book is empty.");
            return;
        }
        // We iterate over the values of the map to display all contacts.
        for (ContactV2 contact : contacts.values()) {
            System.out.println("Name: " + contact.name() + ", Phone: " + contact.phoneNumber());
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        ContactBook_V2_HashMap book = new ContactBook_V2_HashMap();
        System.out.println("--- Contact Book V2 (Using HashMap) ---");

        book.addContact("Alice", "111-222-333");
        book.addContact("Bob", "444-555-666");
        book.addContact("Charlie", "777-888-999");

        book.displayAllContacts();

        System.out.println("\nSearching for Bob (should be very fast)...");
        ContactV2 foundContact = book.findContactByName("Bob");
        if (foundContact != null) {
            System.out.println("Found Bob: " + foundContact);
        } else {
            System.out.println("Bob not found.");
        }
    }
}
