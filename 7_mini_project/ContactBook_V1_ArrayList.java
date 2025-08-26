import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single contact with a name and phone number.
 * Using a record for a simple, immutable data carrier.
 */
record Contact(String name, String phoneNumber) {
}

/**
 * Version 1 of the Contact Book.
 * Uses an ArrayList to store contacts.
 * Search is simple but inefficient (O(n)).
 */
public class ContactBook_V1_ArrayList {

    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);
        System.out.println("Added: " + newContact);
    }

    // This is a linear search, which is slow for large lists.
    // Idi linear search. Pedda list unte, idi chala slow ga untundi (O(n)).
    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.name().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null; // Not found
    }

    public void displayAllContacts() {
        System.out.println("\n--- All Contacts ---");
        if (contacts.isEmpty()) {
            System.out.println("Contact book is empty.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.name() + ", Phone: " + contact.phoneNumber());
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        ContactBook_V1_ArrayList book = new ContactBook_V1_ArrayList();
        System.out.println("--- Contact Book V1 (Using ArrayList) ---");

        book.addContact("Alice", "111-222-333");
        book.addContact("Bob", "444-555-666");
        book.addContact("Charlie", "777-888-999");

        book.displayAllContacts();

        System.out.println("\nSearching for Bob...");
        Contact foundContact = book.findContactByName("Bob");
        if (foundContact != null) {
            System.out.println("Found Bob: " + foundContact);
        } else {
            System.out.println("Bob not found.");
        }

        System.out.println("\nSearching for David...");
        Contact notFoundContact = book.findContactByName("David");
        if (notFoundContact != null) {
            System.out.println("Found David: " + notFoundContact);
        } else {
            System.out.println("David not found.");
        }
    }
}
