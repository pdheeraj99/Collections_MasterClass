import java.util.ArrayList;
import java.util.List;

/**
 * This file demonstrates the basic usage of ArrayList.
 * Note: The class is not public to avoid conflict with java.util.ArrayList.
 * Ee file ArrayList యొక్క basic usage ni chupistundi.
 * Class peru public kaadu, endukante java.util.ArrayList tho conflict avvakunda undataniki.
 */
class ArrayListDemo {
    public static void main(String[] args) {
        // Create a List using ArrayList
        List<String> languages = new ArrayList<>();
        System.out.println("Created an empty ArrayList: " + languages);

        // Add elements
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        System.out.println("After adding elements: " + languages);

        // Access an element by its index (0-based)
        String firstLang = languages.get(0);
        System.out.println("The first language is: " + firstLang);

        // Add an element at a specific index
        languages.add(1, "C++");
        System.out.println("After adding C++ at index 1: " + languages);

        // Remove an element
        languages.remove("Python");
        System.out.println("After removing 'Python': " + languages);
    }
}
