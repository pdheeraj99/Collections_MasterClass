import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This file demonstrates the usage of PriorityQueue.
 * A PriorityQueue orders elements based on their natural order or a custom Comparator.
 * It's a "priority-in, priority-out" queue, not a "first-in, first-out" queue.
 * Note: The class is not public to avoid conflict with java.util.PriorityQueue.
 */
class PriorityQueueDemo {
    public static void main(String[] args) {
        // By default, PriorityQueue orders elements in their natural ascending order.
        // For numbers, this means the smallest number has the highest priority.
        Queue<Integer> patientQueue = new PriorityQueue<>();

        // Add patients with a priority number (lower number = higher priority)
        patientQueue.offer(3); // Low priority
        patientQueue.offer(1); // High priority
        patientQueue.offer(2); // Medium priority
        System.out.println("Patients in queue (internal order might differ): " + patientQueue);

        // When we poll(), the element with the highest priority (smallest number) is removed first.
        // Manam poll() chesinappudu, highest priority (chinna number) unna element mundu vastundi.
        System.out.println("Serving patient with priority: " + patientQueue.poll());
        System.out.println("Serving patient with priority: " + patientQueue.poll());
        System.out.println("Serving patient with priority: " + patientQueue.poll());
    }
}
