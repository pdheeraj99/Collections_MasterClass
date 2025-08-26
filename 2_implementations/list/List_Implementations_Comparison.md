# Comparison of `List` Implementations

`List` interface ni implement chese chala classes unnayi. Vaatillo main ga `ArrayList`, `LinkedList`, `Vector`, and `Stack` gurinchi telusukovali. Ee table vaati madhya unna key differences ni chupistundi.

| Feature               | `ArrayList`                               | `LinkedList`                                   | `Vector`                                        | `Stack`                                         |
|-----------------------|:-----------------------------------------:|:----------------------------------------------:|:-----------------------------------------------:|:-----------------------------------------------:|
| **Underlying DS**     | Dynamic Array                             | Doubly Linked List                             | Dynamic Array                                   | `Vector` (Dynamic Array)                        |
| **Thread-Safety**     | **Not thread-safe**                       | **Not thread-safe**                            | **Thread-safe** (Synchronized)                  | **Thread-safe** (Synchronized)                  |
| **Performance**       | **Fast** (in single-thread)               | Depends on operation                           | **Slow** (due to synchronization overhead)      | **Slow** (due to synchronization overhead)      |
| **Random Access (`get`)** | **O(1)** - Very Fast                      | O(n) - Slow                                    | O(1) - Very Fast                                | O(1) - Very Fast                                |
| **Add/Remove (Middle)** | O(n) - Slow                               | **O(1)** (if iterator is at position)          | O(n) - Slow                                     | O(n) - Slow                                     |
| **Use Case**          | General purpose, read-heavy list.         | Write-heavy list, frequent insertions/deletions. | Legacy code, or when a simple thread-safe `ArrayList` is needed. | Legacy LIFO stack. **`ArrayDeque` is preferred**. |
| **Introduced in**     | Java 1.2                                  | Java 1.2                                       | Java 1.0                                        | Java 1.0                                        |
| **Allows `null`?**    | Yes                                       | Yes                                            | Yes                                             | Yes                                             |

### Key Takeaways:

*   **Modern Choice for a List:** Use **`ArrayList`** for most cases. If you have a lot of additions/removals in the middle, consider **`LinkedList`**.
*   **Modern Choice for a Stack:** Use an **`ArrayDeque`**, not `Stack`.
*   **Thread-Safety:** If you need a thread-safe list, don't use `Vector`. Instead, use `Collections.synchronizedList(new ArrayList<>())` or, for read-heavy concurrent access, **`CopyOnWriteArrayList`**.

`Vector` and `Stack` anevi legacy classes. Vaati gurinchi telusukovadam important, kani kotha code lo vaatini avoid cheyadam better practice.
