# Guide: How to Choose the Right Collection? 🤔

Correct collection ni choose cheskovadam oka pedda skill. Ee guide tho, ee situation ki edi perfect choice o meeru easy ga decide cheyagalaru. Just ask yourself these questions!

### Step 1: Do you need to store Key-Value pairs?

*   **YES:** Go to the **Map World** 🗺️.
    *   Do you need the keys to be **sorted**?
        *   **YES:** Use `TreeMap`. (e.g., a dictionary, phone book sorted by name).
        *   **NO:** Use `HashMap`. It's generally faster. (e.g., storing user sessions by session ID).
    *   Do you need to maintain the **insertion order** of keys?
        *   **YES:** Use `LinkedHashMap`. (e.g., for building a cache like LRU Cache).

*   **NO:** You need a `List`, `Set`, or `Queue`. Go to Step 2.

---

### Step 2: Do you need to store only UNIQUE elements?

*   **YES:** Go to the **Set World** 🛡️.
    *   Do you need the elements to be **sorted**?
        *   **YES:** Use `TreeSet`. (e.g., storing a list of unique usernames in alphabetical order).
        *   **NO:** Use `HashSet`. It's generally faster. (e.g., storing unique lottery ticket numbers).
    *   Do you need to maintain the **insertion order**?
        *   **YES:** Use `LinkedHashSet`.

*   **NO:** You can have duplicates. Go to Step 3.

---

### Step 3: How will you access the elements?

*   **I need to access elements by an index number (e.g., get the 5th element).**
    *   **Use a `List`!** 📋
        *   Are you doing a lot of `get(index)` operations and fewer additions/removals in the middle?
            *   **YES:** Use `ArrayList`. It's super fast for random access.
        *   Are you doing a lot of additions and removals in the middle of the list?
            *   **YES:** Use `LinkedList`. It's faster for these operations.

*   **I need to process elements in a specific order (e.g., First-In, First-Out or Last-In, First-Out).**
    *   **Use a `Queue` or `Deque`!** 🚶‍♂️🚶‍♀️🚶‍♂️
        *   Do you need a simple **First-In, First-Out (FIFO)** queue (like a ticket counter)?
            *   Use a `LinkedList` or `ArrayDeque`.
        *   Do you need a **Last-In, First-Out (LIFO)** stack (like a stack of plates)?
            *   Use an `ArrayDeque`.
        *   Do you need to process elements based on **priority** instead of insertion time (like a hospital emergency room)?
            *   Use `PriorityQueue`.

---

### Quick Summary Table

| Requirement                               | Best Choice(s)                     |
|-------------------------------------------|------------------------------------|
| Key-Value pairs, unsorted                 | `HashMap`                          |
| Key-Value pairs, sorted by key            | `TreeMap`                          |
| Key-Value pairs, insertion order          | `LinkedHashMap`                    |
| Unique elements, unsorted                 | `HashSet`                          |
| Unique elements, sorted                   | `TreeSet`                          |
| Unique elements, insertion order          | `LinkedHashSet`                    |
| Indexed access, fast reads                | `ArrayList`                        |
| Frequent insertions/deletions in middle   | `LinkedList`                       |
| FIFO Queue / LIFO Stack                   | `ArrayDeque`                       |
| Priority-based processing                 | `PriorityQueue`                    |
