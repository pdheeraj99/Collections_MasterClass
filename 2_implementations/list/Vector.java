import java.util.Vector;
import java.util.List;

/**
 * This file demonstrates the usage of Vector.
 * Vector is a legacy class, similar to ArrayList, but it is synchronized (thread-safe).
 * In modern Java, ArrayList or CopyOnWriteArrayList are often preferred.
 */
class VectorDemo {
    public static void main(String[] args) {
        // Vector is thread-safe, so operations are slower than ArrayList.
        List<String> legacyList = new Vector<>();

        legacyList.add("Zebra");
        legacyList.add("Yak");
        legacyList.add("Xerus");

        System.out.println("Vector contents: " + legacyList);

        // Vector has methods similar to ArrayList
        System.out.println("Element at index 1: " + legacyList.get(1));
        System.out.println("Size of vector: " + legacyList.size());
    }
}
