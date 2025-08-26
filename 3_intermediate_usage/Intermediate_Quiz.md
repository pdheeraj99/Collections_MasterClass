# Intermediate Quiz: Level Up Your Skills! 🤔

Foundation concepts meeda manchi grip vachindi. Ippudu konchem tough questions try cheddama? Let's go!

---

### Question 1

Meeru oka social media app lo user's friends list ni store cheyali. Friends list lo order mukhyam kaadu, kani prathi friend unique ga undali. Meeru ye collection vadataru?

a) `ArrayList`
b) `HashMap`
c) `HashSet`
d) `PriorityQueue`

---

### Question 2

Custom `Employee` object ni `HashMap` lo key ga vadali anukuntunaru. `HashMap` correct ga pani cheyalante, `Employee` class lo meeru ye methods ni override cheyali?

a) Only `equals()`
b) Only `hashCode()`
c) Both `equals()` and `hashCode()`
d) `toString()`

---

### Question 3

`equals()` and `hashCode()` contract gurinchi kindi vaatilo edi **correct** statement?

a) If `a.equals(b)` is true, then `a.hashCode()` and `b.hashCode()` can be different.
b) If `a.hashCode()` and `b.hashCode()` are the same, then `a.equals(b)` must be true.
c) If `a.equals(b)` is true, then `a.hashCode()` and `b.hashCode()` **must** be the same.
d) `equals()` and `hashCode()` are not related to each other.

---

### Question 4

Meeru 1 million (10 lakh) elements ni `ArrayList` lo store cheyali anukuntunaru. Performance kosam, `ArrayList` ni create chesetappudu ye constructor vadadam better?

a) `new ArrayList<>()`
b) `new ArrayList<>(1000000)`
c) `new LinkedList<>()`
d) Rendu constructors oke rakamaina performance isthayi.

<br>
<br>
<br>

---
### Answers

**Question 1:** **c) `HashSet`**
*   *Explanation:* Friends list lo duplicates undakudadu (`unique`) and order anavasaram. Ee requirements ki `HashSet` perfect match. Mana "Security Guard" katha gurtunda? 😉

**Question 2:** **c) Both `equals()` and `hashCode()`**
*   *Explanation:* `HashMap` (mana "Library Magician") correct ga pani cheyalante, daaniki key object ni ela compare cheyalo (`equals`) and daani correct shelf number (`hashCode`) ela kanukkovaalo manam cheppali. Rendu important.

**Question 3:** **c) If `a.equals(b)` is true, then `a.hashCode()` and `b.hashCode()` must be the same.**
*   *Explanation:* Idhi `hashCode-equals` contract lo golden rule. Rendu objects equal ayite, vaati hashcode kuda tappakunda equal ga undali. Reverse true kaadu (hashcodes equal ayite, objects equal avvalsina avasaram ledu - adi collision).

**Question 4:** **b) `new ArrayList<>(1000000)`**
*   *Explanation:* Manaki elements count mundare telisinappudu, initial capacity set cheyadam valla, `ArrayList` background lo chala sarlu resize avvadam aagipotundi. Idi performance ni chala improve chestundi.

How did you do? Ee questions konchem tricky, kani meeru correct ga answer cheste, you are on the right track to becoming a pro! 💪
