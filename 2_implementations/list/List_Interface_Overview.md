# Interface Overview: What is a `List`? 📋

`ArrayList` and `LinkedList` gurinchi nerchukune mundu, asalu vaati parent ayina `List` interface gurinchi telusukovali.

Think of `List` as a **contract** or a **blueprint**. Idi, "Nannu implement chese ye class ayina, ee rules ni pakka follow avvali" ani cheptundi.

(`List` ni oka contract anukondi. Ee contract meeda sign chese ye class (like `ArrayList`) ayina, aa contract lo unna rules ni follow avvali.)

### The Core Rules of the `List` Contract

`List` contract lo unna 3 main rules:

1.  **Ordered Collection:** `List` lo elements ye order lo add chestaro, ave order lo store avtayi and retrieve avtayi. Order chala mukhyam. First add chesindi index 0 lo, second di index 1 lo... ila untayi.
2.  **Allows Duplicates:** `List` lo manam duplicate elements ni store cheyochu. For example, `['Apple', 'Banana', 'Apple']` anedi perfect ga valid `List`.
3.  **Index-Based Access:** `List` lo prathi element ki oka index (position number) untundi, starting from 0. Manam aa index ni use chesi, element ni direct ga get cheyochu (`get(index)`), update cheyochu (`set(index, element)`), or remove cheyochu (`remove(index)`).

### Common Methods in the `List` Contract

`List` interface lo unna konni common and important methods:

*   `void add(int index, E element)`: Specified index lo element ni add chestundi.
*   `E get(int index)`: Specified index lo unna element ni return chestundi.
*   `E set(int index, E element)`: Specified index lo unna element ni kotha element tho replace chestundi.
*   `E remove(int index)`: Specified index lo unna element ni remove chestundi.
*   `int indexOf(Object o)`: Oka element యొక్క first occurrence index ni return chestundi.
*   `int lastIndexOf(Object o)`: Oka element యొక్క last occurrence index ni return chestundi.
*   `List<E> subList(int fromIndex, int toIndex)`: List lo nunchi oka chinna part ni kotha list laaga return chestundi.

### Famous Children of `List`

`List` contract ni implement chese chala classes unnayi, kani veetillo most famous:
*   **`ArrayList`**: Resizable array tho implement chesaru. `get(index)` operations ki super fast.
*   **`LinkedList`**: Doubly-linked list tho implement chesaru. Madhyalo elements ni add or remove cheyadaniki fast.

Ippudu ee overview tarvata, `ArrayList` and `LinkedList` files ni chadivite, meeku inka clear ga artham avtundi!
