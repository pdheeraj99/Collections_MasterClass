# The Core Interfaces of JCF

JCF antha interfaces meeda build aipoindi. Ee interfaces ni JCF ki building blocks anukovachu. Manam main ga telusukovalsina core interfaces konni unnayi.

`README.md` lo unna `CoreInterfacesDiagram.png` (ee diagram ni manam create cheyalem, but imagine it) ee hierarchy ni chupistundi.

### 1. The `Iterable` Interface

Idi JCF hierarchy lo root level lo untundi (kani `Collection` interface ki parent). Oka object ni `for-each` loop lo vadali ante, adi `Iterable` interface ni implement cheyali. Deenilo `iterator()` ane okka method matrame untundi.

### 2. The `Collection` Interface

Idi most collections ki root interface (`Map` ki kaadu). Idi oka group of objects ni represent chestundi. Deenilo `add()`, `remove()`, `contains()`, `size()`, `isEmpty()` lanti basic methods untayi. `Collection` interface ni direct ga implement cheyam, daani sub-interfaces ni vadatam.

`Collection` interface ki 3 main children unnayi:

#### a. `List` Interface
*   **What it is:** An **ordered** collection (sequence).
*   **Key Features:** Maintains insertion order, allows duplicate elements, elements can be accessed by their integer index.
*   **Analogy:** Mana Party Planner's guest list.
*   **Implementations:** `ArrayList`, `LinkedList`, `Vector`.

#### b. `Set` Interface
*   **What it is:** A collection that contains **no duplicate** elements.
*   **Key Features:** Does not allow duplicates. Order is generally not guaranteed (except for some implementations).
*   **Analogy:** Mana VIP Security Guard's unique guest list.
*   **Implementations:** `HashSet`, `LinkedHashSet`, `TreeSet`.

#### c. `Queue` Interface
*   **What it is:** A collection used to hold elements prior to processing. Typically orders elements in a **FIFO (First-In, First-Out)** manner.
*   **Key Features:** `offer()` (to add), `poll()` (to remove), `peek()` (to see the head element).
*   **Analogy:** Cinema ticket counter line.
*   **Implementations:** `LinkedList`, `PriorityQueue`, `ArrayDeque`.

---

### 3. The `Map` Interface

*   **Important:** `Map` anedi `Collection` interface ni extend cheyadu. Idi separate hierarchy.
*   **What it is:** An object that maps **keys** to **values**.
*   **Key Features:** Keys must be unique. Each key can map to at most one value.
*   **Analogy:** A dictionary (Key = word, Value = meaning).
*   **Implementations:** `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`.

Ee interfaces JCF ki foundation. Veetini ardham cheskunte, different implementations madhya unna similarities and differences easy ga ardham avtayi.
