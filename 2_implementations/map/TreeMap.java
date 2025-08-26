import java.util.TreeMap;
import java.util.Map;

/**
 * This file demonstrates the basic usage of TreeMap.
 * TreeMap stores keys in a sorted order (natural ordering or by a Comparator).
 * Note: The class is not public to avoid conflict with java.util.TreeMap.
 */
class TreeMapDemo {
    public static void main(String[] args) {
        // Create a Map using TreeMap. Keys will be sorted automatically.
        // TreeMap use chesi oka Map create cheddam. Keys sort avtayi.
        Map<String, Integer> fruitPrices = new TreeMap<>();

        // Add key-value pairs in a random order
        // Random order lo entries add cheddam
        fruitPrices.put("Apple", 120);
        fruitPrices.put("Orange", 80);
        fruitPrices.put("Banana", 40);
        fruitPrices.put("Grapes", 100);

        // The output will be sorted by key (alphabetically in this case)
        // Output chuste, keys (perlu) alphabetical order lo sort ayyi untayi
        System.out.println("Fruit Prices (Sorted by Fruit Name): " + fruitPrices);

        // Other operations are similar to HashMap
        // Migatha operations HashMap laage untayi
        int orangePrice = fruitPrices.get("Orange");
        System.out.println("Price of Orange is: " + orangePrice);

        // TreeMap has additional methods for sorted navigation, but we'll cover them later.
        // TreeMap lo sorted navigation ki inka special methods untayi, but avi tarvata chuddam.
    }
}
