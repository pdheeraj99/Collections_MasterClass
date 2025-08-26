# System Design: Thread-Safe Cache 👨‍💻

"Design a thread-safe, in-memory cache" anedi oka common system design interview question. Deeniki perfect answer undadu, but meeru discuss cheyalsina key points and trade-offs ikkada unnai.

### 1. Core Requirements

First, manam interviewer tho requirements clarify cheskovali.
*   **Capacity:** Cache ki fixed size undala? (e.g., 10,000 entries)
*   **Eviction Policy:** Cache full ayite, ye element ni remove cheyali?
    *   LRU (Least Recently Used): Chala rojulanunchi vadani element.
    *   LFU (Least Frequently Used): Takkuva sarlu vadina element.
    *   FIFO (First-In, First-Out): First vachina element.
*   **Thread Safety:** Multiple threads okesari cache ni access cheyagalali (read and write).
*   **Expiration:** Entries kontha time tarvata expire avvala? (e.g., after 5 minutes).

### 2. Choosing the Right Data Structures

Ee problem ni solve cheyadaniki, manam collections ni smart ga combine cheyali.

#### For Thread-Safety: `ConcurrentHashMap`

*   Normal `HashMap` thread-safe kaadu. `Hashtable` or `Collections.synchronizedMap()` vadite, lokesari okka thread matrame pani cheyagaladu, adi performance ni debba teestundi (low concurrency).
*   **`ConcurrentHashMap` is the perfect choice.** Idi high performance and thread-safe. Idi "lock-stripping" ane technique vadutundi, ante map antha lock cheyakunda, కేవలం (kevalam) konni parts matrame lock chestundi. Deeni valla, multiple threads okesari map meeda pani cheyochu.

#### For Eviction Policy (e.g., LRU): `LinkedHashMap` or a custom Doubly Linked List

*   Manaki LRU policy kavali ante, elements access order teliyali. Deeniki `LinkedHashMap` perfect.
*   **Problem:** `LinkedHashMap` thread-safe kaadu.

### 3. Combining for a Solution

Ikkade asalu challenge undi. Thread-safe `ConcurrentHashMap` ki, eviction policy unna `LinkedHashMap` ni ela kalapali?

**Approach 1: `ConcurrentHashMap` + `Deque`**

*   Data antha `ConcurrentHashMap` lo store cheyandi for fast, thread-safe lookups.
    *   `Map<Key, Value> map = new ConcurrentHashMap<>();`
*   Access order ni track cheyadaniki, manam oka `Deque` (like `ConcurrentLinkedDeque`) vadali.
    *   Prati sari oka entry ni access chesinappudu (`get`), aa key ni `Deque` lo nunchi teesi, malli venakala (tail) add cheyali.
    *   Cache full ayinappudu, `Deque` mundu (head) nunchi key ni teesi, aa key ni `ConcurrentHashMap` lo nunchi kuda remove cheyali.
*   **Challenge:** Ee `get` and `put` operations (map and deque ni update cheyadam) antha **atomic** ga (okesari) jaragali. Deeniki manam `synchronized` blocks or `ReentrantLock` vadali.

**Approach 2: Build on top of a Library**

*   Real-world lo, manam deenini scratch nunchi build cheyam. Google's **Guava Cache** or **Caffeine** lanti libraries vadatam.
*   Interview lo, ee libraries gurinchi cheppadam mee awareness ni chupistundi. Meeru ila cheppochu: "For a production-ready solution, I would use a well-tested library like Google's Guava Cache, which handles all these complexities internally. However, if I were to build it from scratch, I would use a `ConcurrentHashMap` combined with a `Deque` and explicit locking..."

### 4. Discussing Expiration

*   Expiration handle cheyalante, `Value` object lo creation timestamp ni store cheyali.
*   `get` chesinappudu, timestamp ni check chesi, entry expire ayite, daanini remove chesi `null` return cheyali.
*   Alternatively, oka separate "cleanup thread" ni run chesi, adi periodically paatha entries ni remove chestu untundi.

Ee points anni discuss cheste, meeru ee system design question ni successfully tackle cheyagalaru!
