# Basic (But Powerful) Concepts

Interfaces and implementations tho paatu, JCF effectively vadadaniki konni basic concepts teliyali. Ivvi chala powerful.

### 1. Generics (`<>`)

Generics ante enti? `List<String>` or `Map<Integer, String>` lo manam use chese angle brackets (`<>`) ye generics.

*   **Why use them?** Generics manaki **type-safety** isthayi.
*   **Before Generics (The Problem):**
    ```java
    List list = new ArrayList();
    list.add("Hello");
    list.add(123); // No error! It accepts any Object.

    String text = (String) list.get(1); // Throws ClassCastException at RUNTIME! 💣
    ```
    Generics lekapothe, collection lo em type of data undoo compiler ki teliyadu. Manam data ni retrieve chesinappudu, daanini manually type-cast cheyali, and adi tappu ayite, program runtime lo crash avtundi.

*   **With Generics (The Solution):**
    ```java
    List<String> list = new ArrayList<>();
    list.add("Hello");
    // list.add(123); // COMPILE-TIME ERROR! ✅

    String text = list.get(0); // No casting needed.
    ```
    Generics tho, manam collection lo `String` matrame store cheyagalam ani compiler ki cheptunnam. Vere type add cheyalani try cheste, code compile avvadu. Idi runtime errors ni thaggistundi.

> **Rule:** Eppudu collections tho generics vadandi. Raw types (like `List` without `<>`) vadakandi.

### 2. Iterators

An `Iterator` is an object that lets you traverse through a collection's elements one by one, without exposing the underlying implementation.

*   `for-each` loop manam vadinappudu, background lo Java ee `Iterator` ni use chestundi.
    ```java
    List<String> list = ...;
    for (String s : list) { // Internally uses an iterator
        System.out.println(s);
    }
    ```
*   **Why use it directly?** Loop chestunnappudu, collection nunchi element ni safely remove cheyalante, manam `Iterator` యొక్క (yokka) `remove()` method ni vadali. Direct ga `list.remove()` vadite, `ConcurrentModificationException` vastundi. (Ee topic gurinchi manam `2_implementations/list/ArrayList_Pitfalls.md` lo inka deep ga chusam).

### 3. Autoboxing & Unboxing

Collections lo objects matrame store avtayi. `int`, `double` lanti primitives store avvavu. Kani manam `List<Integer> list = new ArrayList<>(); list.add(5);` ani rayagalam.

*   **Autoboxing:** Java compiler automatically `int` (primitive) ni `Integer` (object) ga marchadam. `list.add(5)` -> `list.add(Integer.valueOf(5))`.
*   **Unboxing:** `Integer` (object) ni `int` (primitive) ga marchadam. `int x = list.get(0)` -> `int x = list.get(0).intValue()`.

Idi code ni easy ga chestundi, kani deeni valla performance issues vachche chance undi, especially loops lo. (Deeni gurinchi `4_advanced/BoxingUnboxingPitfalls.md` lo detailed ga matladukunnam).
