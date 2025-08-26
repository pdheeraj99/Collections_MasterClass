# Bug Busters: ArrayList Common Pitfalls 🐛

`ArrayList` chala powerful and easy-to-use, kani konni sarlu manalni chinna chinna mistakes lo irikistundi. Ee common pitfalls ni avoid cheste, mee code inka strong avtundi!

### Pitfall 1: The Infamous `ConcurrentModificationException`

Idi andaru face chese most common problem. "Donga tho dosti vaddu!" annattu, deenitho friendship manchidi kadu.

**Scenario:** Meeru oka `ArrayList` ni loop chestu, ade samayam lo daanilo nunchi oka element ni remove cheyalani try chestaru.

**Why it happens?**
`for-each` loop (or an explicit `Iterator`) use chesinappudu, an `Iterator` object create avtundi. Ee `Iterator` ki "fail-fast" behaviour untundi. Ante, loop start ayinappati nunchi, collection lo structurally edaina change (add/remove) jarigite, `Iterator` ki kopam vachi, "Hey, nenu loop chestunna, nuvvu madhyalo enduku change chestunnav?" ani `ConcurrentModificationException` ni visurutundi (throws).

**Wrong Code (Leads to Exception):**
```java
List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));

for (String fruit : fruits) {
  if (fruit.equals("Banana")) {
    fruits.remove("Banana"); // BOOM! 💣 ConcurrentModificationException
  }
}
```

**Correct Way (Using `Iterator.remove()`):**
Loop chestu remove cheyalante, `Iterator` object ni direct ga use chesi, daani `remove()` method ni call cheyali. Idi safe.

```java
List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
Iterator<String> iterator = fruits.iterator();

while (iterator.hasNext()) {
  String fruit = iterator.next();
  if (fruit.equals("Banana")) {
    iterator.remove(); // Correct way! ✅
  }
}
```

**Alternative Correct Way (Java 8+):**
Java 8 lo vachina `removeIf()` method inka simple ga untundi.

```java
List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
fruits.removeIf(fruit -> fruit.equals("Banana")); // Clean & Safe! ✅
```

### Pitfall 2: Initializing with Default Size

Prati sari `new ArrayList<>()` ani initialize cheste, adi default ga 10 capacity tho start avtundi. Meeku telusu, daanilo 1000 elements add cheyalsi vastundani, appudu `ArrayList` chala sarlu resize avvalsivastundi. Prati resize operation ki, background lo kotha array create ayyi, paatha elements anni kotha array loki copy avtayi. Idi performance ni debba teestundi.

**Inefficient Code:**
```java
List<Integer> numbers = new ArrayList<>(); // Starts with capacity 10
for (int i = 0; i < 1000; i++) {
  numbers.add(i); // Resizes multiple times
}
```

**Efficient Code:**
Meeku elements count mundare teliste, initial capacity ni set cheyadam best practice.

```java
List<Integer> numbers = new ArrayList<>(1000); // Starts with capacity 1000
for (int i = 0; i < 1000; i++) {
  numbers.add(i); // No resizing needed! 🚀
}
```

Ee chinna chinna vishayalu gurtupettukunte, meeru `ArrayList` ni inka effectively use cheyagalaru! Happy coding!
