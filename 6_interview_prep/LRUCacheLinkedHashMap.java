import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class provides a solution to the famous "LRU Cache" coding problem
 * using Java's LinkedHashMap. This is a very common interview question.
 *
 * Problem Statement: Design a data structure that follows the constraints of a
 * Least Recently Used (LRU) cache.
 */
public class LRUCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        // Call the LinkedHashMap constructor with accessOrder = true
        // Ee 'true' parameter ye asalu magic. Idi entries ni access order lo sort chestundi.
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    /**
     * This method is the key to the LRU logic. It's called after a new entry
     * is inserted. We override it to remove the oldest entry when the cache
     * is full.
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    // The problem usually requires a get and put method.
    // LinkedHashMap already provides them. We can add them here for clarity if needed,
    // but they just call the superclass methods.
    public int get(int key) {
        return super.getOrDefault(key, -1); // Return -1 if not found, as is common in the problem.
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


    public static void main(String[] args) {
        System.out.println("--- Testing the LRU Cache (Interview Problem Solution) ---");
        System.out.println("Capacity: 2");
        LRUCacheLinkedHashMap lruCache = new LRUCacheLinkedHashMap(2);

        lruCache.put(1, 1); // cache is {1=1}
        System.out.println("put(1, 1): " + lruCache);

        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println("put(2, 2): " + lruCache);

        System.out.println("get(1): " + lruCache.get(1)); // returns 1, makes 1 most recently used. cache is {2=2, 1=1}
        System.out.println("Cache state: " + lruCache);


        lruCache.put(3, 3); // evicts key 2. cache is {1=1, 3=3}
        System.out.println("put(3, 3): " + lruCache);
        System.out.println("(Key 2 was evicted as it was the least recently used)");


        System.out.println("get(2): " + lruCache.get(2)); // returns -1 (not found)

        lruCache.put(4, 4); // evicts key 1. cache is {3=3, 4=4}
        System.out.println("put(4, 4): " + lruCache);
        System.out.println("(Key 1 was evicted)");

        System.out.println("get(1): " + lruCache.get(1)); // returns -1 (not found)
        System.out.println("get(3): " + lruCache.get(3)); // returns 3
        System.out.println("get(4): " + lruCache.get(4)); // returns 4
    }
}
