import java.util.Stack;

/**
 * This file demonstrates the usage of the legacy Stack class.
 * Stack represents a last-in-first-out (LIFO) stack of objects.
 * It extends Vector, which is generally not ideal.
 * For modern applications, using a Deque (like ArrayDeque) is recommended for stack operations.
 */
class StackDemo {
    public static void main(String[] args) {
        Stack<String> bookStack = new Stack<>();

        // Pushing items onto the stack
        System.out.println("Pushing books onto the stack...");
        bookStack.push("Book A");
        bookStack.push("Book B");
        bookStack.push("Book C");
        System.out.println("Stack: " + bookStack);

        // Peeking at the top item without removing it
        System.out.println("\nTop of the stack (peek): " + bookStack.peek());

        // Popping items from the stack
        System.out.println("\nPopping books from the stack...");
        System.out.println("Popped: " + bookStack.pop());
        System.out.println("Popped: " + bookStack.pop());
        System.out.println("Stack after two pops: " + bookStack);

        System.out.println("\nIs the stack empty? " + bookStack.isEmpty());
    }
}
