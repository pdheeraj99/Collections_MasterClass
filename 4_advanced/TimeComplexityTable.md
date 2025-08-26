# Performance: Time Complexity Table (Big O) ⚡

Collections tho pani chesetappudu, performance chala mukhyam. Ye operation ki entha time padutundo teliste, manam better code rayagalam. Ee table, common collections lo common operations ki average time complexity (Big O Notation) ni chupistundi.

*   **O(1) - Constant Time:** Super fast. Collection size tho sambandham lekunda, time constant ga untundi.
*   **O(log n) - Logarithmic Time:** Very fast. Collection size double ayina, time konchem matrame perugutundi.
*   **O(n) - Linear Time:** Okay performance. Collection size perige koddi, time kuda proportionally perugutundi.
*   **O(n log n) - Linearithmic Time:** Sorting algorithms lo common ga untundi.
*   `n` = number of elements in the collection.

---

### `List` Implementations

| Operation             | `ArrayList` | `LinkedList` | Ekkada idi Best?                                 |
|-----------------------|:-----------:|:------------:|--------------------------------------------------|
| `get(index)`          | **O(1)**    | O(n)         | `ArrayList` is the clear winner for random access. |
| `add(element)` (at end) | O(1) am*    | **O(1)**     | Both are fast. `ArrayList` might resize.         |
| `add(index, element)` | O(n)        | O(n)         | Both are slow. `LinkedList` is slightly better if you already have a pointer to the middle. |
| `remove(index)`       | O(n)        | O(n)         | Both are slow. `LinkedList` slightly better if pointer is ready. |
| `contains(element)`   | O(n)        | O(n)         | Both require scanning the list.                  |

`*` *Amortized constant time. Ante, chala sarlu O(1), kani okkosari resize ayinappudu O(n). Average ga O(1) laane untundi.*

---

### `Set` Implementations

| Operation      | `HashSet` | `LinkedHashSet` | `TreeSet`     |
|----------------|:---------:|:---------------:|:-------------:|
| `add`          | **O(1)**  | **O(1)**        | O(log n)      |
| `remove`       | **O(1)**  | **O(1)**        | O(log n)      |
| `contains`     | **O(1)**  | **O(1)**        | O(log n)      |
| **Sorted?**    | No        | No (Insertion)  | **Yes**       |

---

### `Map` Implementations

| Operation      | `HashMap` | `LinkedHashMap` | `TreeMap`     |
|----------------|:---------:|:---------------:|:-------------:|
| `put`          | **O(1)**  | **O(1)**        | O(log n)      |
| `get`          | **O(1)**  | **O(1)**        | O(log n)      |
| `remove`       | **O(1)**  | **O(1)**        | O(log n)      |
| `containsKey`  | **O(1)**  | **O(1)**        | O(log n)      |
| **Sorted?**    | No        | No (Insertion)  | **Yes**       |

### Key Takeaways

*   **Need speed?** `HashMap` and `HashSet` are your best friends for general purpose storage. O(1) operations chala fast.
*   **Need sorted data?** `TreeMap` and `TreeSet` are the way to go. O(log n) is still very fast.
*   **Need indexed access?** `ArrayList` is the king.
*   **Need to add/remove a lot from the ends?** `LinkedList` or `ArrayDeque` are great.

Ee table ni gurtupettukunte, meeru mee application ki perfect collection ni choose cheskuni, performance ni optimize cheyagalaru!
