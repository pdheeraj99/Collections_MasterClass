import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class demonstrates how to implement a simple LRU (Least Recently Used) Cache
 * using LinkedHashMap. This is a classic expert-level use of the Collections Framework.
 *
 * @param <K> the type of keys maintained by this cache
 * @param <V> the type of mapped values
 */
public class CacheImplementation<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    /**
     * Constructs an CacheImplementation with a given capacity.
     *
     * @param capacity the maximum number of entries this cache can hold
     */
    public CacheImplementation(int capacity) {
        // The 'true' for accessOrder is the magic! It orders entries by access time.
        // Ikkada 'true' anedi chala magic! Idi entries ni access order lo pedutundi.
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    /**
     * This method is called by put and putAll after inserting a new entry.
     * It returns true if the oldest entry should be removed.
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // Remove the eldest entry if the size exceeds the capacity.
        // Size capacity ni daatithe, paatha entry ni remove cheyali.
        return size() > capacity;
    }

    public static void main(String[] args) {
        System.out.println("--- Creating an LRU Cache with capacity 3 ---");
        CacheImplementation<Integer, String> cache = new CacheImplementation<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Cache after adding 1, 2, 3: " + cache);

        // Accessing key 1 makes it the most recently used.
        System.out.println("\nAccessing value for key 1: " + cache.get(1));
        System.out.println("Cache after accessing 1: " + cache);

        // Adding a new entry (4) should cause the least recently used entry (2) to be removed.
        System.out.println("\nAdding a new entry (4, 'Four')...");
        cache.put(4, "Four");
        System.out.println("Cache after adding 4: " + cache);
        System.out.println("(Notice that key 2 was removed because it was the least recently used)");
    }
}
