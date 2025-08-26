import java.util.HashSet;
import java.util.Set;

/**
 * This file demonstrates the basic usage of HashSet.
 * HashSet does not allow duplicate elements and does not guarantee order.
 * Note: The class is not public to avoid conflict with java.util.HashSet.
 */
class HashSetDemo {
    public static void main(String[] args) {
        // Create a Set using HashSet
        Set<String> uniqueFruits = new HashSet<>();

        // Add elements
        uniqueFruits.add("Apple");
        uniqueFruits.add("Banana");
        uniqueFruits.add("Orange");
        System.out.println("Initial Set: " + uniqueFruits);

        // Try to add a duplicate element
        // Duplicate element add cheyadaniki try cheddam
        boolean isAdded = uniqueFruits.add("Apple");
        System.out.println("Was 'Apple' added again? " + isAdded);
        System.out.println("Set after trying to add a duplicate: " + uniqueFruits);

        // The order is not guaranteed. It might seem ordered now, but don't rely on it.
        // Order guarantee ledu. Ippudu order lo unattu anipinchina, daani meeda depend avvoddu.
        uniqueFruits.add("Mango");
        uniqueFruits.add("Grapes");
        System.out.println("Set after adding more fruits: " + uniqueFruits);

        // Check if an element exists
        boolean hasBanana = uniqueFruits.contains("Banana");
        System.out.println("Does the set contain 'Banana'? " + hasBanana);
    }
}
