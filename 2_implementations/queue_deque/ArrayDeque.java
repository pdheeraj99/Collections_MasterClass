import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This file demonstrates the usage of ArrayDeque.
 * ArrayDeque can be used as a Queue (FIFO) or a Stack (LIFO).
 * Note: The class is not public to avoid conflict with java.util.ArrayDeque.
 */
class ArrayDequeDemo {
    public static void main(String[] args) {
        // Using ArrayDeque as a Queue (First-In, First-Out)
        System.out.println("--- ArrayDeque as a Queue (FIFO) ---");
        Deque<String> ticketQueue = new ArrayDeque<>();

        ticketQueue.offer("Person 1"); // offer adds to the tail
        ticketQueue.offer("Person 2");
        ticketQueue.offer("Person 3");
        System.out.println("People in queue: " + ticketQueue);

        System.out.println("Serving: " + ticketQueue.poll()); // poll removes from the head
        System.out.println("Remaining in queue: " + ticketQueue);
        System.out.println("Serving: " + ticketQueue.poll());
        System.out.println("Remaining in queue: " + ticketQueue);

        System.out.println("\n---------------------------------------\n");

        // Using ArrayDeque as a Stack (Last-In, First-Out)
        System.out.println("--- ArrayDeque as a Stack (LIFO) ---");
        Deque<String> plateStack = new ArrayDeque<>();

        plateStack.push("Plate 1"); // push adds to the head
        plateStack.push("Plate 2");
        plateStack.push("Plate 3");
        System.out.println("Stack of plates: " + plateStack);

        System.out.println("Taking plate: " + plateStack.pop()); // pop removes from the head
        System.out.println("Remaining plates: " + plateStack);
        System.out.println("Taking plate: " + plateStack.pop());
        System.out.println("Remaining plates: " + plateStack);
    }
}
