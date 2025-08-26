import java.util.TreeSet;
import java.util.Set;

/**
 * This file demonstrates the basic usage of TreeSet.
 * TreeSet is a Set that stores elements in a sorted order.
 * Note: The class is not public to avoid conflict with java.util.TreeSet.
 */
class TreeSetDemo {
    public static void main(String[] args) {
        // Create a Set using TreeSet. Elements will be sorted.
        Set<String> sortedFruits = new TreeSet<>();

        // Add elements in a random order
        sortedFruits.add("Orange");
        sortedFruits.add("Apple");
        sortedFruits.add("Banana");
        sortedFruits.add("Grapes");

        // Try to add a duplicate
        sortedFruits.add("Apple"); // This will be ignored

        // The output will be sorted by key (alphabetically)
        // Output chuste, elements alphabetical order lo sort ayyi untayi
        System.out.println("Sorted Fruits Set: " + sortedFruits);

        // TreeSet, being a NavigableSet, has methods to get first/last elements
        // TreeSet (NavigableSet) lo first/last elements ni get cheyadaniki special methods untayi
        TreeSet<String> fruitTree = (TreeSet<String>) sortedFruits;
        System.out.println("First fruit: " + fruitTree.first());
        System.out.println("Last fruit: " + fruitTree.last());
    }
}
