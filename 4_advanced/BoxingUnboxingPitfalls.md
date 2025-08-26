# Performance Pitfall: The Hidden Cost of Boxing & Unboxing 🥊

Java lo collections (like `ArrayList<Integer>`) objects ni matrame store cheyagalavu. Avi `int`, `double`, `long` lanti primitive types ni direct ga store cheyalevu.

Ayite, manam `List<Integer> list = new ArrayList<>(); list.add(5);` ani రాసినప్పుడు (rasinappudu - when we write), adi ela pani chestundi?

Deeni venaka unna magic ye **Autoboxing**.

### What is Boxing and Unboxing?

*   **Boxing:** Java compiler automatically converts a primitive type into its corresponding wrapper class object.
    *   `int` becomes `Integer`
    *   `double` becomes `Double`
    *   `boolean` becomes `Boolean`
    *   Example: `list.add(5);` is converted by the compiler to `list.add(Integer.valueOf(5));`.

*   **Unboxing:** The reverse process. The compiler converts a wrapper object back to a primitive type.
    *   `Integer` becomes `int`
    *   Example: `int myNum = list.get(0);` is converted to `int myNum = list.get(0).intValue();`.

Ee feature code ni chala clean ga kanipinchేలా (kanipinchela - to appear) chestundi, kani deeni venaka oka hidden performance cost undi.

### The Performance Pitfall 🐛

Prati boxing operation, background lo oka kotha object ni create chestundi. Meeru oka loop lo lakshalakonddi (lakhs of) numbers tho pani chestunnappudu, antha mandi kotha objects create avvadam anedi Garbage Collector (GC) meeda chala load create chestundi and mee application ni slow cheyochu.

**Example: Inefficient Code**

Ee code lo, loop lo prati sari `sum` ki `i` ni add chesetappudu, unboxing (`sum` becomes `int`) and boxing (`result` is put back into `sum` as an `Integer`) jarugutunnayi.

```java
List<Integer> numbers = new ArrayList<>();
for (int i = 0; i < 10_000_000; i++) {
    numbers.add(i);
}

// Inefficient way: lots of boxing/unboxing
long startTime = System.currentTimeMillis();
Integer sum = 0; // Wrapper type
for (Integer i : numbers) {
    sum = sum + i; // Unboxing: sum.intValue(). Boxing: Integer.valueOf(result)
}
long endTime = System.currentTimeMillis();
System.out.println("Sum (with boxing): " + sum);
System.out.println("Time taken (with boxing): " + (endTime - startTime) + " ms");
```

**Example: Efficient Code**

Ikkada, manam `long` ane primitive type ni vadutunnam kabatti, loop lo ye boxing/unboxing jaragadu.

```java
// Efficient way: using primitives
startTime = System.currentTimeMillis();
long primitiveSum = 0L; // primitive type
for (int i : numbers) {
    primitiveSum = primitiveSum + i; // No boxing/unboxing
}
endTime = System.currentTimeMillis();
System.out.println("Sum (primitive): " + primitiveSum);
System.out.println("Time taken (primitive): " + (endTime - startTime) + " ms");
```

Ee rendu code snippets ni run cheste, meeku time difference chala clear ga kanipistundi. Primitive version will be significantly faster!

### Key Takeaway

Autoboxing chala convenient, kani performance-critical code lo, especially loops lo, primitives ni vadadaniki try cheyandi. Ee chinna change mee application performance ni chala improve cheyochu.
