# Mini-Project: My Contact Book 🛠️

Welcome to the "My Contact Book" mini-project! Ee project lo, manam ee repository lo nerchukunna concepts anni use chesi, oka practical application ni build cheddam.

## Project Goal

The goal is to build a simple contact book application. We will start with a very basic version and gradually improve it by using more advanced and efficient collections. This will help us understand the real-world impact of choosing the right data structure.

(Ee project mukya uddesham, oka simple contact book application ni build cheyadam. Manam basic version tho start chesi, tarvata efficient collections tho daanini improve cheddam. Deeni valla, correct data structure ni choose cheskovadam entha importanto manaki artham avtundi.)

## Project Stages

This project is divided into three stages:

### 🚀 Version 1: The Basic List (`ContactBook_V1_ArrayList.java`)
*   **Goal:** Create a basic contact book that can store and display contacts.
*   **Collection Used:** `ArrayList`
*   **Learnings:** How to use `ArrayList` to store custom objects. We'll see that searching for a contact is slow (O(n)) as the list grows.

### ⚡ Version 2: The Fast Search (`ContactBook_V2_HashMap.java`)
*   **Goal:** Improve the search functionality to be instantaneous.
*   **Collection Used:** `HashMap`
*   **Learnings:** How to use a `HashMap` with a custom object. We'll use the contact's name as the key for super-fast O(1) lookups. We'll also need to correctly implement `equals()` and `hashCode()` for our `Contact` object.

### 🏆 Version 3: The Thread-Safe Book (`ContactBook_V3_ThreadSafe.java`)
*   **Goal:** Make our contact book usable by multiple threads at the same time without data corruption.
*   **Collection Used:** `ConcurrentHashMap`
*   **Learnings:** How to use concurrent collections to handle multi-threaded environments. This is a crucial skill for building robust, real-world applications.

Let's start building!
