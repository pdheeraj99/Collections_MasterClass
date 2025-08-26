# Interview Prep: Frequently Asked Questions (FAQ) 🔥

Collections meeda interviews lo adige konni common but tricky questions and vaati detailed answers ikkada unnai.

### Q1: Explain the internal working of a HashMap.
**(HashMap internal working cheppu?)**

**Answer:**
Ee question ki answer cheyadaniki, manam mana "Library Magician" katha (`2_implementations/map/HashMap_Internal_Story.md`) ni gurtucheskovali.

1.  **Core Idea:** `HashMap` works on the principle of **hashing**. It stores data as **Key-Value pairs** in an array of "buckets" or "nodes".
2.  **`put(key, value)`:**
    *   When we put a key-value pair, Java first calculates the `hashCode()` of the **key**.
    *   This hash code is then used to determine the **bucket index** (shelf number) where the entry should be stored. `index = hashCode % array_size`.
    *   The `HashMap` goes to that index. If the bucket is empty, it stores the new entry (key, value, and hash) as a `Node`.
    *   **Collision:** If the bucket is not empty (another key has the same bucket index), it's a collision. The new entry is added to the existing bucket, usually by forming a **linked list** of entries. (In modern Java, if the list becomes too long, it's converted to a **balanced tree** for better performance).
3.  **`get(key)`:**
    *   Again, it calculates the `hashCode()` of the key to find the bucket index.
    *   It goes to that bucket. If the bucket is not empty, it iterates through each entry in that bucket's linked list (or tree).
    *   For each entry, it first checks if the hash codes match. If they do, it then calls the **`.equals()`** method to confirm if the keys are truly identical.
    *   If both `hashCode` and `equals` match, it returns the corresponding value. Otherwise, it returns `null`.

**Key things to mention:** `hashCode()`, `equals()`, `buckets`, `collision`, `LinkedList`, and `balanced tree` (for bonus points).

---

### Q2: What is the difference between ArrayList and LinkedList?

| Feature               | `ArrayList`                                       | `LinkedList`                                      |
|-----------------------|---------------------------------------------------|---------------------------------------------------|
| **Underlying DS**     | Dynamic Array                                     | Doubly Linked List (Node with data, prev, next)   |
| **Random Access**     | **Fast (O(1))**. `get(index)` is very efficient.  | **Slow (O(n))**. It has to traverse from the start. |
| **Insertion/Deletion**| **Slow (O(n))**. It requires shifting elements.    | **Fast (O(1))**, if you are at the position.      |
| **Memory**            | Less memory overhead.                             | More memory overhead (for storing prev/next pointers). |
| **Best For**          | Read-heavy operations. When you need fast `get()`. | Write-heavy operations. Frequent insertions/deletions. |

---

### Q3: What is the difference between HashMap and Hashtable?

*   **Synchronization:** `Hashtable` is **synchronized** (thread-safe). `HashMap` is **not synchronized**. This makes `HashMap` faster in single-threaded environments. For a thread-safe alternative to `HashMap`, use `ConcurrentHashMap`.
*   **Null values:** `HashMap` allows **one null key** and **multiple null values**. `Hashtable` does **not allow any null keys or null values**.
*   **Performance:** `HashMap` is generally faster because it's non-synchronized.
*   **Legacy:** `Hashtable` is a legacy class from Java 1.0. `HashMap` was introduced in Java 1.2 and is the preferred choice in most cases.

---

### Q4: What is the `hashCode()` and `equals()` contract?

This is the most important contract in Java collections.
1.  If `obj1.equals(obj2)` is true, then `obj1.hashCode()` **must** be equal to `obj2.hashCode()`.
2.  If `obj1.hashCode()` is equal to `obj2.hashCode()`, it **does not** mean that `obj1.equals(obj2)` must be true. (This is a collision).
3.  If `obj1.equals(obj2)` is false, their hash codes can be the same or different.

Ee questions ni master cheste, meeru collections interviews lo chala confident ga untaru!
